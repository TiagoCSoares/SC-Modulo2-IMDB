package org.example.entites;

import java.util.List;

public class Artista extends Pessoa{
    public Artista(String nome, String dataNascimento, char sexo, List<Filme> filmes) {
        super(nome, dataNascimento, sexo, filmes);
    }
}
