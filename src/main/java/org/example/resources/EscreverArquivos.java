package org.example.resources;

import org.example.entites.Artista;
import org.example.entites.Diretor;
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

        public void escreverDiretores(List<Diretor> diretores) {
            escreverDadosDiretores("src/main/java/org/example/arquivos/diretores.txt", diretores);
        }

        public void escreverFilmes(List<Filme> filmes) {
            escreverDadosFilmes("src/main/java/org/example/arquivos/filmes.txt", filmes);
        }

        private void escreverDadosArtistas(String nomeArquivo, List<Artista> artistas) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
                for (Artista artista : artistas) {
                    writer.write(String.format("%-8d | %-25s | %-10s | %-2c", artista.getId(), artista.getNome(), artista.getDataNascimento(), artista.getSexo()));
                    for(Filme filmes : artista.getFilmes()) {
                        writer.write(String.format(" | %-25s - %-15s - %-4d - %-4d - %-100s" ,
                                filmes.getNome(), filmes.getGenero(), filmes.getDataLancamento(),
                                filmes.getDuracao(), filmes.getDescricao()));
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
                for (Diretor diretor : filme.getDiretores()) {
                    writer.write(String.format(" \\ %-30s - %-10s - %-2c", diretor.getNome(), diretor.getDataNascimento(), diretor.getSexo()));
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void escreverDadosDiretores(String nomeArquivo, List<Diretor> diretores) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Diretor diretor : diretores) {
                writer.write(String.format("%-8d | %-25s | %-10s | %-2c", diretor.getId(),
                        diretor.getNome(), diretor.getDataNascimento(), diretor.getSexo()));
                for(Filme filmes : diretor.getFilmes()) {
                    writer.write(String.format(" | %-25s - %-15s - %-4d - %-4d - %-100s" ,
                            filmes.getNome(), filmes.getGenero(), filmes.getDataLancamento(),
                            filmes.getDuracao(), filmes.getDescricao()));
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

