package org.example.resources;

import java.io.File;
import java.io.IOException;

public class IniciarArquivos {

    public void iniciarArquivos() {
        novaPasta("src/main/java/org/example/arquivos");

        novoArquivo("src/main/java/org/example/arquivos/artistas.txt");
        novoArquivo("src/main/java/org/example/arquivos/diretores.txt");
        novoArquivo("src/main/java/org/example/arquivos/filmes.txt");
    }


    public static void novaPasta(String pasta) {
        File novaPasta = new File(pasta);
        if (!novaPasta.exists()) {
            novaPasta.mkdirs();
        }
    }

    public static void novoArquivo(String arquivo) {
        File novoArquivo = new File(arquivo);
        try {
            if (!novoArquivo.exists()) {
                novoArquivo.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
