package com.exercicios;


//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SegundoDesafio {

    public static void main(String[] agrs) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create("https://www.reddit.com/r/programming/"))
                .build();

        //Comunicação síncrona
        HttpResponse<String> response = client.send(req,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }

}

