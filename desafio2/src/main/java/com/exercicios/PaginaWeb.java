package com.exercicios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaginaWeb {

    public static String getContentPage(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        //Comunicação síncrona
        HttpResponse<String> response = client.send(req,
                HttpResponse.BodyHandlers.ofString());

        return response.body();
    }


    public static ArrayList<String> filterResult(String response) {
        int cont = 0;
        String itemList = "";
        ArrayList<String> item = new ArrayList<String>();
        String[] filterResult = response.split(",");
        List<String> list = Arrays.asList(filterResult);
        for (String titleList : list) {
            if (titleList.length() >= 6) {
                itemList = titleList.substring(1, 6);
            }
            if (itemList.equals("title") && cont < 20) {
                    if (!titleList.isEmpty()) {
                        titleList = titleList.substring(8, titleList.lastIndexOf("\""));
                        if (titleList.length() > 1) {
                            item.add(titleList);
                            cont++;
                        }
                    }
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

