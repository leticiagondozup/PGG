package com.exercicios;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.exercicios.PaginaWeb.listSort;


public class SegundoDesafio {

    private static ArrayList<String> listTitle;
    private static ArrayList<String> ordenacao;

    public static void main(String[] agrs) throws IOException, InterruptedException {


       String contentPage = "";

        try {
            contentPage = PaginaWeb.getContentPage("https://www.reddit.com/r/programming/");
        } catch (InterruptedException | IOException e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }



        listTitle = PaginaWeb.filterResult(contentPage);
        ordenacao = PaginaWeb.listSort(listTitle);
        for (String title : ordenacao) {
            System.out.println(title);

        }
    }
}

