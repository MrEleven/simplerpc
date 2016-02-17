package com.mreleven.rpc.invoke;

import com.mreleven.rpc.exception.RpcException;
import com.mreleven.rpc.exception.RpcExceptionCodeEnum;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * rpc调用与响应传输接口的http实现
 * Created by huiyao on 16-2-15.
 */
public class HttpInvoker implements Invoker{
    private static final HttpClient httpClient = getHttpClient();

    public static final Invoker invoker = new HttpInvoker();

    public String request(String request, ConsumerConfig consumerConfig) throws RpcException {
        HttpPost post = new HttpPost(consumerConfig.getUrl());
        post.setHeader("Connection", "Keep-Alive");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("data", request));
        try {
            post.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            HttpResponse response = httpClient.execute(post);
            if (response.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toString(response.getEntity(), "UTF-8");
            }
            throw new RpcException(RpcExceptionCodeEnum.DATA_PARSER_ERROR.getCode(), request);
        }
        catch (Exception e) {
            throw new RpcException("http 调用异常", e, RpcExceptionCodeEnum.INVOKE_REQUEST_ERROR.getCode(), request);
        }
    }

    public void response(String response, OutputStream outputStream) throws RpcException {
        try {
            outputStream.write(response.getBytes("UTF-8"));
            outputStream.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static HttpClient getHttpClient() {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();

        cm.setMaxTotal(200);
        cm.setDefaultMaxPerRoute(20);

        HttpHost localhost = new HttpHost("localhost", 8080);

        cm.setMaxPerRoute(new HttpRoute(localhost), 50);

        return HttpClients.custom().setConnectionManager(cm).build();
    }
}
