package com.exercicios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.exercicios.PaginaWeb.listSort;


public class SegundoDesafio {

    private static ArrayList<String> listTitle;

    public static void main(String[] agrs) throws IOException, InterruptedException {


        String contentPage = "";

        try {
            contentPage = PaginaWeb.getContentPage("https://www.reddit.com/r/programming/");
        } catch (InterruptedException | IOException e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }

        listTitle = PaginaWeb.filterResult(contentPage);
        listSort(listTitle);
        for (String title : listSort(listTitle)) {
            System.out.println(title);

        }
    }
}

