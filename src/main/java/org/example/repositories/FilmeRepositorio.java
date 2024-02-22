package org.example.repositories;

import org.example.banco.BancoDeDados;
import org.example.entites.Filme;

import java.util.List;

public class FilmeRepositorio extends AbstractRepositorio{

    public FilmeRepositorio(BancoDeDados bancoDeDados) {
        super(bancoDeDados);
    }

    @Override
    protected Class classeModelo() {
        return Filme.class;
    }

    @Override
    protected Boolean filtraPorId(Object objeto, Long id) {
        Filme filme = (Filme) objeto;
        return filme.getId().equals(id);
    }

    public List<Filme> buscarPorNome(String nome) {
        List<Filme> filmes = listar();
        List<Filme> filmesEncontrados = null;
        for (Filme filme : filmes) {
            if (filme.getNome().contains(nome)) {
                filmesEncontrados.add(filme);
            }
        }
        return filmesEncontrados;
    }

}
