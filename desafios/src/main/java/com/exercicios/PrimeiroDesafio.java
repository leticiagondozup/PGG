package com.exercicios;

import java.io.File;
import java.util.Scanner;

public class PrimeiroDesafio {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o caminho que deseja listar: ");

        String caminho = sc.nextLine();

        File folder = new File(caminho);

        try {
            for (File arquivo : folder.listFiles()) {
                listarArquivos(arquivo);
            }
        }catch (NullPointerException exception){
            System.out.println("Error: Não é possível identificar diretorio/arquivo nulo");
        }

        sc.close();

    }

    public static void listarArquivos(File file) {
        if (file.isFile()) {
            System.out.println("Arquivo: " + file.getName());
            return;
        }
        System.out.println("Diretorio: " + file.getName());
        for (File no : file.listFiles()) {
            listarArquivos(no);
        }

    }

}