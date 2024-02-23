package org.example.resources.lerArquivos;

import org.example.entites.Artista;
import org.example.entites.Diretor;
import org.example.entites.Filme;
import org.example.services.FilmeService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerArquivoFilmes extends LerArquivoAbstract{

    @Override
    protected String getNomeArquivo() {
        return "src/main/java/org/example/arquivos/filmes.txt";
    }

    protected void preencherBanco(Object service) {

        if (service instanceof FilmeService filmeService) {
            try(var reader = new BufferedReader(new FileReader(getNomeArquivo()))) {
                String linha;
                while((linha = reader.readLine()) != null) {
                    String[] elementos = linha.split("\\s*\\|\\s*");
                    if (elementos.length > 0 && !elementos[0].trim().isEmpty()) {
                        Filme filme = getFilme(elementos, linha);
                        filmeService.criar(filme);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Filme getFilme(String[] elementos, String linha) {
        // O primeiro elemento será a id
        String nome = elementos[1].trim();
        String descricao = elementos[2].trim();
        String genero = elementos[3].trim();
        Integer dataLancamento = Integer.parseInt(elementos[4].trim());
        Integer duracao = Integer.parseInt(elementos[5].trim());

        List<Artista> artistas = getArtistas(elementos);

        elementos = linha.split("\\s*\\\\\\s*");
        List<Diretor> diretores = getDiretores(elementos);

        return new Filme(nome, descricao, genero, dataLancamento, duracao, artistas, diretores);
    }

    private static List<Artista> getArtistas(String[] elementos) {
        List<Artista> artistas = new ArrayList<>();

        for(int i = 6; i < elementos.length-1; i++) {
            String[] filme = elementos[i].split("\\s*-\\s*");
            String nomeArtista = filme[0].trim();
            String dataNascimento = filme[1].trim();
            char sexo = filme[2].trim().charAt(0);
            Artista novoArtista = new Artista(nomeArtista, dataNascimento, sexo, null);
            artistas.add(novoArtista);
        }
        return artistas;
    }

    private static List<Diretor> getDiretores(String[] elementos) {
        List<Diretor> diretores = new ArrayList<>();
        for(int i = 0; i < elementos.length; i++) {
            String[] diretor = elementos[i].split("\\s*-\\s*");
            String nomeDiretor = diretor[0].trim();
            String dataNascimento = diretor[1].trim();
            char sexo = diretor[2].trim().charAt(0);
            Diretor novoDiretor = new Diretor(nomeDiretor, dataNascimento, sexo, null);
            diretores.add(novoDiretor);
        }
        return diretores;
    }
}
