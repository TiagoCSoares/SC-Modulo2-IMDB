package org.example.resources;

import org.example.entites.Artista;
import org.example.repositories.ArtistaRepositorio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class EscreverArquivos {
        public void escreverArtistas(Set<Object> artistas) {
            escreverDados("src/main/java/org/example/arquivos/artistas.txt", artistas);
        }

        public void escreverDiretores(Set<Object> diretores) {
            escreverDados("src/main/java/org/example/arquivos/diretores.txt", diretores);
        }

        public void escreverFilmes(Set<Object> filmes) {
            escreverDados("src/main/java/org/example/arquivos/filmes.txt", filmes);
        }

        private void escreverDados(String nomeArquivo, Set<Object> dados) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
                for (Object obj : dados) {
                    writer.write(obj.toString());
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
