package org.example.resources;

import org.example.entites.Artista;
import org.example.entites.Filme;
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
        }*/

        public void escreverFilmes(List<Filme> filmes) {
            escreverDadosFilmes("src/main/java/org/example/arquivos/filmes.txt", filmes);
        }

        private void escreverDadosArtistas(String nomeArquivo, List<Artista> artistas) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
                for (Artista artista : artistas) {
                    writer.write(String.format("%-8d | %-30s | %-10s | %-2c", artista.getId(), artista.getNome(), artista.getDataNascimento(), artista.getSexo()));
                    for(Filme filmes : artista.getFilmes()) {
                        writer.write(String.format(" | %-8d | %-25s - %-15s - %-10s", filmes.getId(), filmes.getNome(), filmes.getGenero(), filmes.getDataLancamento()));
                    }
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    private void escreverDadosFilmes(String nomeArquivo, List<Filme> filmes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Filme filme : filmes) {
                writer.write(String.format("%-8d | %-25s | %-15s | %-100s | %-4d | %-3d | ", filme.getId(),
                        filme.getNome(), filme.getGenero(), filme.getDescricao(), filme.getDataLancamento(),
                        filme.getDuracao()));
                for(Artista artista : filme.getArtistas()) {
                    writer.write(String.format(" | %-30s - %-10s - %-2c", artista.getNome(), artista.getDataNascimento(), artista.getSexo()));
                }
                /*for (Diretor diretor : filmes.getDiretor()) {
                    writer.write(String.format(" | %-8d - %-45s - %-10s", diretor.getId(), diretor.getNome()));
                }*/
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

