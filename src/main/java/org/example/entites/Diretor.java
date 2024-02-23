package org.example.entites;

import java.util.List;

public class Diretor extends Pessoa{
    public Diretor(String nome, String dataNascimento, char sexo, List<Filme> filmes) {
        super(nome, dataNascimento, sexo, filmes);
    }
}
