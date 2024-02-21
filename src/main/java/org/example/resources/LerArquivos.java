package org.example.resources;

import org.example.entites.Artista;
import org.example.entites.Filme;
import org.example.services.ArtistaService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LerArquivos {

    public static Boolean lerArtistasTxt() {

        File arquivoArtistas = new File("src/main/java/org/example/arquivos/artistas.txt");

        try {
            if (!arquivoArtistas.exists()) {
                arquivoArtistas.createNewFile();
            } else if (arquivoArtistas.length() > 0) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static void preencherBancoArtistas(ArtistaService artistaService) {
        boolean dadosArtistas = lerArtistasTxt();

        if (dadosArtistas) {
            try(BufferedReader reader = new BufferedReader(new FileReader("src/main/java/org/example/arquivos/artistas.txt"))) {
                String linha;
                while((linha = reader.readLine()) != null) {
                    String[] elementos = linha.split("\\s*\\|\\s*");
                    if (elementos.length > 0 && !elementos[0].trim().isEmpty()) {
                        String nome = elementos[0].trim();
                        String dataNascimento = elementos[1].trim();
                        char sexo = elementos[2].trim().charAt(0);
                        List<Filme> filmes = null;
                        for(int i = 3; i < elementos.length; i++) {
                            String[] filme = elementos[i].split("\\s*\\-\\s*");
                            String nomeFilme = filme[0].trim();
                            String genero = filme[1].trim();
                            String dataLancamento = filme[2].trim();
                            Float duracao = Float.parseFloat(filme[3].trim());
                            Filme novoFilme = new Filme(nomeFilme, genero, dataLancamento, duracao, null, null);
                            filmes.add(novoFilme);
                        }
                        Artista artista = new Artista(nome, dataNascimento, sexo, filmes);
                        artistaService.criar(artista);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}