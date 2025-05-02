package com.example.app.httpsManagers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;

public class HttpsManager {
    HttpsURLConnection httpsURLConnection;
    BufferedReader bufferedReader;
    String jsonURL;

    public HttpsManager(String jsonURL) {
        this.jsonURL = jsonURL;
    }

    public String procesare() {
        try {
            trustEveryone();
            httpsURLConnection = (HttpsURLConnection) new URL(jsonURL).openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String linie = "";
            linie = bufferedReader.readLine();
            while (linie != null) {
                stringBuilder.append(linie);
                linie = bufferedReader.readLine();
            }
            httpsURLConnection.disconnect();
            bufferedReader.close();

            return stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void trustEveryone() {
        try {
            HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, new X509TrustManager[]{new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain,
                                               String authType) {
                }

                public void checkServerTrusted(X509Certificate[] chain,
                                               String authType) {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }}, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(
                    context.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
