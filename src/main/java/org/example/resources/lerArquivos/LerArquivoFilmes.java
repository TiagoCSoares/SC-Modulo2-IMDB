package org.example.resources.lerArquivos;

import org.example.entites.Artista;
import org.example.entites.Diretor;
import org.example.entites.Filme;
import org.example.services.FilmeService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerArquivoFilmes {

    public static Boolean lerFilmesTxt() {

        File arquivoArtistas = new File("src/main/java/org/example/arquivos/filmes.txt");

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


    public static void preencherBancoFilmes(FilmeService filmeService) {
        boolean dadosFilmes = lerFilmesTxt();

        if (dadosFilmes) {
            try(BufferedReader reader = new BufferedReader(new FileReader("src/main/java/org/example/arquivos/filmes.txt"))) {
                String linha;
                while((linha = reader.readLine()) != null) {
                    String[] elementos = linha.split("\\s*\\|\\s*");
                    if (elementos.length > 0 && !elementos[0].trim().isEmpty()) {
                        // O primeiro elemento será a id
                        String nome = elementos[1].trim();
                        String descricao = elementos[2].trim();
                        String genero = elementos[3].trim();
                        Integer dataLancamento = Integer.parseInt(elementos[4].trim());
                        Integer duracao = Integer.parseInt(elementos[5].trim());

                        List<Artista> artistas = new ArrayList<>();
                        for(int i = 6; i < elementos.length-1; i++) {
                            String[] filme = elementos[i].split("\\s*\\-\\s*");
                            String nomeArtista = filme[0].trim();
                            String dataNascimento = filme[1].trim();
                            char sexo = filme[2].trim().charAt(0);
                            Artista novoArtista = new Artista(nomeArtista, dataNascimento, sexo, null);
                            artistas.add(novoArtista);
                        }
                        List<Diretor> diretores = new ArrayList<>();
                        elementos = linha.split("\\s*\\\\\\s*");
                        for(int i = 0; i < elementos.length; i++) {
                            String[] diretor = elementos[i].split("\\s*\\-\\s*");
                            String nomeDiretor = diretor[0].trim();
                            String dataNascimento = diretor[1].trim();
                            char sexo = diretor[2].trim().charAt(0);
                            Diretor novoDiretor = new Diretor(nomeDiretor, dataNascimento, sexo, null);
                            diretores.add(novoDiretor);
                        }

                        Filme filme = new Filme(nome, descricao, genero, dataLancamento, duracao, artistas, diretores);
                        filmeService.criar(filme);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
