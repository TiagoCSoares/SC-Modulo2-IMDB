package org.example.entites;

import java.util.List;

public class Artista extends Pessoa{

    private List<Filme> filmes;


    public Artista(String nome, String dataNascimento, char sexo, List<Filme> filmes) {
        super(nome, dataNascimento, sexo);
        this.filmes = filmes;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public void associarFilme(Filme filme) {
        filmes.add(filme);
    }
}
