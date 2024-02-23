package org.example.repositories;

import org.example.banco.BancoDeDados;
import org.example.entites.Artista;
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
        nome = nome.toUpperCase();
        List<Filme> filmes = listar();
        List<Filme> filmesEncontrados = null;
        for (Filme filme : filmes) {
            if (filme.getNome().toUpperCase().contains(nome)) {
                filmesEncontrados.add(filme);
            }
        }
        return filmesEncontrados;
    }

    public void associarFilme(Artista artista, Filme filme) {
        filme.associarArtista(artista);
    }

    /*public void associarDiretor(Artista diretor, Filme filme) {
        filme.associarDiretor(diretor);
    }*/

    public void excluirArtista(Artista artista) {
        List<Filme> filmes = listar();
        for (Filme filme : filmes) {
            if(filme.getArtistas() == null){
                continue;

            } else if(filme.getArtistas().contains(artista)) {
                filme.desassociarArtista(artista);
            }
        }
    }
}
