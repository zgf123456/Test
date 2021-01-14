package com.zgf.Test.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author liyi
 * @date 2015-12-1下午9:59:26
 */
public class HttpClientUtil {

    public static final int TIMEOUT_15 = 15;
    public static final int TIMEOUT_10 = 10;
    public static final int TIMEOUT_20 = 20;
    public static final int TIMEOUT_25 = 25;
    public static final int TIMEOUT_30 = 30;
    public static final int TIMEOUT_60 = 60;

    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);


    /**
     * @param timeout
     * @return
     * @throws Exception
     */
    public static CloseableHttpClient newCloseableHttpSSLClient(int timeout) {
        TrustManager[] trustAllCerts = new TrustManager[1];
        TrustManager tm = new EaTrustManager();
        trustAllCerts[0] = tm;
        SSLContext sc = null;
        try {
            sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, null);
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage(), e);
        } catch (KeyManagementException e) {
            logger.error(e.getMessage(), e);
        }

        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(timeout * 1000) //
                .setConnectTimeout(timeout * 1000) //
                .setConnectionRequestTimeout(timeout * 1000) //
                .build();

        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sc, NoopHostnameVerifier.INSTANCE);
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(socketFactory) //
                .setDefaultRequestConfig(defaultRequestConfig) //
                .build();
        return httpClient;

    }

    private static class EaTrustManager implements TrustManager, X509TrustManager {

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
            //don't check
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
            //don't check
        }
    }


    /**
     * HTTP Get 获取内容
     *
     * @param url     请求的url地址 ?之前的地址
     * @param params  请求的参数
     * @param charset 编码格式
     * @return 页面内容
     */
    public static String httpRequest(String url, Map<String, String> params, String charset) {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        CloseableHttpResponse response = null;
        try {
            if (params != null && !params.isEmpty()) {
                List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    String value = entry.getValue();
                    if (value != null) {
                        pairs.add(new BasicNameValuePair(entry.getKey(), value));
                    }
                }
                url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, charset));
            }
            logger.info("请求地址url:{}", url);
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpClient closeableHttpClient = HttpClientUtil.newCloseableHttpSSLClient(TIMEOUT_30);
            response = closeableHttpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpGet.abort();
                throw new RuntimeException("HttpClient,error status code :" + statusCode);
            }
            return EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
//        String s = HttpClientUtil.httpRequest("http://hbank-account-api.fql.ksh:1443/hbank-account-web/outer/pay/transfer.htm", null, null);
//        String s = HttpClientUtil.httpRequest("https://www.liantu.com/", null, null);
        String s = HttpClientUtil.httpRequest("https://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php?query=2020&resource_id=6018", null, null);
        System.out.println(s);
    }
}
