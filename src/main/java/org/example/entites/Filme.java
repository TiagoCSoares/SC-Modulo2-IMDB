package org.example.entites;

import java.util.List;

public class Filme {

    private Long id;
    private String nome;
    private String genero;
    private String dataLancamento;
    private Float duracao;
    private List<Artista> artistas;
    private List<Diretor> diretores;

    public Filme(String nome, String genero, String dataLancamento, Float duracao, List<Artista> artistas, List<Diretor> diretores) {
        this.nome = nome;
        this.genero = genero;
        this.dataLancamento = dataLancamento;
        this.duracao = duracao;
        this.artistas = artistas;
        this.diretores = diretores;
    }
}
