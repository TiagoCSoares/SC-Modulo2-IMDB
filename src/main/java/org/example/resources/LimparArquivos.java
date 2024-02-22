package org.example.resources;

import java.io.FileWriter;
import java.io.IOException;

public class LimparArquivos {

    public void limparArquivos() {
        limpar("src/main/java/org/example/arquivos/artistas.txt");
        limpar("src/main/java/org/example/arquivos/diretores.txt");
        limpar("src/main/java/org/example/arquivos/filmes.txt");
    }


    public void limpar(String arquivo){
        try (FileWriter writer = new FileWriter(arquivo)) {
            // Nada será escrito no arquivo, limpando assim seu conteúdo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
