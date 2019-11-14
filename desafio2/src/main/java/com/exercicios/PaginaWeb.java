package com.exercicios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaginaWeb {

    public static String getContentPage (String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofMinutes(1))
                .build();

        //Comunicação síncrona
        HttpResponse<String> response = client.send(
                req,
                HttpResponse.BodyHandlers.ofString());


        return response.body();
    }


        /*public static RequestConfig configTimeout(){
            int timeout = 60;
            RequestConfig config =  RequestConfig.custom()
                    .setConnectTimeout(timeout * 1000)
                    .setConnectionRequestTimeout(timeout * 1000)
                    .setSocketTimeout(timeout * 1000)
                    .build();

            return config;
        }*/



    public static ArrayList<String> filterResult(String response) {
        ArrayList<String> item = new ArrayList<String>();
        String[] filterResult = response.split(",");
        List<String> list = Arrays.asList(filterResult);
        for (String titleList : list) {
            if (titleList.contains("title")) {
               titleList = titleList.substring(titleList.indexOf(":") + 2, titleList.length() - 1);
                item.add(titleList);
                
                }
            }
        return item;
    }

    public static ArrayList<String> listSort (ArrayList<String> item) {
        int i;
        String key;
        int n = item.size();
        for (i = 1; i < n; ++i) {
            key = item.get(i);
            int j = i - 1;
            while (j >= 0 && item.get(j).compareTo(key) > 0) {
                item.set(j + 1, item.get(j));
                j = j - 1;
            }
            item.set(j + 1, key);
        }
        return item;
    }
}

