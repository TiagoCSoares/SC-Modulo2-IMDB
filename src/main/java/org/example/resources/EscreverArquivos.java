package org.example.resources;

import org.example.entites.Artista;
import org.example.repositories.ArtistaRepositorio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class EscreverArquivos {

        public void escreverArtistas(List<Artista> artistas) {
            escreverDadosArtistas("src/main/java/org/example/arquivos/artistas.txt", artistas);
        }

        /*public void escreverDiretores(Set<Object> diretores) {
            escreverDadosDiretores("src/main/java/org/example/arquivos/diretores.txt", diretores);
        }

        public void escreverFilmes(Set<Object> filmes) {
            escreverDadosFilmes("src/main/java/org/example/arquivos/filmes.txt", filmes);
        }
*/
        private void escreverDadosArtistas(String nomeArquivo, List<Artista> artistas) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
                for (Artista artista : artistas) {
                    writer.write(String.format("%-8d | %-45s | %-10s | %-2c", artista.getId(), artista.getNome(), artista.getDataNascimento(), artista.getSexo()));
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}

