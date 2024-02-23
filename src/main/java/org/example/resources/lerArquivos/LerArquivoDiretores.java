package org.example.resources.lerArquivos;

import org.example.entites.Diretor;
import org.example.entites.Filme;
import org.example.services.DiretorService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerArquivoDiretores extends LerArquivoAbstract {


    @Override
    protected String getNomeArquivo() {
        return "src/main/java/org/example/arquivos/diretores.txt";
    }


    protected void preencherBanco(Object service) {

        if (service instanceof DiretorService) {
            DiretorService diretorService = (DiretorService) service;
            try (var reader = new BufferedReader(new FileReader(getNomeArquivo()))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    String[] elementos = linha.split("\\s*\\|\\s*");
                    if (elementos.length > 0 && !elementos[0].trim().isEmpty()) {
                        Diretor diretor = getDiretor(elementos);
                        diretorService.criar(diretor);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static Diretor getDiretor(String[] elementos) {
        // O primeiro elemento será a id
        String nome = elementos[1].trim();
        String dataNascimento = elementos[2].trim();
        char sexo = elementos[3].trim().charAt(0);
        List<Filme> filmes = new ArrayList<>();
        for (int i = 4; i < elementos.length; i++) {
            Filme novoFilme = getFilme(elementos[i]);
            filmes.add(novoFilme);
        }
        Diretor diretor = new Diretor(nome, dataNascimento, sexo, filmes);
        return diretor;
    }
    private static Filme getFilme(String elementos) {
        String[] filme = elementos.split("\\s*-\\s*");
        String nomeFilme = filme[0].trim();
        String genero = filme[1].trim();
        String descricao = filme[2].trim();
        Integer dataLancamento = Integer.parseInt(filme[3].trim());
        Integer duracao = Integer.parseInt(filme[4].trim());
        return new Filme(nomeFilme, genero, descricao, dataLancamento, duracao, null, null);
    }
}
