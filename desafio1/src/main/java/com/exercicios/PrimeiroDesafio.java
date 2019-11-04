package com.exercicios;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class PrimeiroDesafio {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o caminho que deseja listar: ");

        String caminho = sc.nextLine();

        File folder = new File(caminho);


        getFolders(folder);

        //  File file = getFolders(folder);

        //for (File arquivo : file.listFiles(){
        //   listarArquivos(arquivo);
        //}


        sc.close();

    }

    public static void getFolders(File folder) {
        try {
            if (folder != null) {
                //return folder;
                for (File arquivo : folder.listFiles()) {
                    listarArquivos(arquivo);
                }
            } else {
                //return null;
                throw new Exception("Não é possivel identificar arquivos ou diretorios nulos");

            }
        } catch (Exception exception) {
            //throw new Exception("Não é possivel identificar arquivos ou diretorios nulos");
            System.out.println("Error: " + exception.getMessage());
            // return null;
        }

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
