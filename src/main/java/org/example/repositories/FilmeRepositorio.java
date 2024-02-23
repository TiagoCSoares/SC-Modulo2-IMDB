package org.example.repositories;

import org.example.banco.BancoDeDados;
import org.example.entites.Artista;
import org.example.entites.Diretor;
import org.example.entites.Filme;

import java.util.ArrayList;
import java.util.List;

public class FilmeRepositorio extends AbstractRepositorio {

    public FilmeRepositorio(BancoDeDados bancoDeDados) {
        super(bancoDeDados);
    }

    @Override
    protected Class classeModelo() {
        return Filme.class;
    }

    @Override
    public void gravar(Object objeto) {
        Filme filme = (Filme) objeto;
        if (filme.getId() == null) {
            filme.setId(bancoDeDados.proximoId());
        }
        super.gravar(objeto);
    }

    @Override
    protected Boolean filtraPorId(Object objeto, Long id) {
        Filme filme = (Filme) objeto;
        return filme.getId().equals(id);
    }

    @Override
    public List<Filme> buscarPorNome(String nome) {
        nome = nome.toUpperCase();
        List<Filme> filmes = listar();
        List<Filme> filmesEncontrados = new ArrayList<>();

        if (filmes != null) {
            for (Filme filme : filmes) {
                if (filme.getNome().toUpperCase().contains(nome)) {
                    filmesEncontrados.add(filme);
                }
            }
        }
        if (filmesEncontrados.isEmpty()) {
            return null;
        }
        return filmesEncontrados;
    }

    @Override
    public void associarFilme(Object object, Filme filme) {
    }

    @Override
    public void excluirFilme(Filme filme) {
    }


    public void associarArtista(Artista artista, Filme filme) {
        filme.associarArtista(artista);
    }

    public void associarDiretor(Diretor diretor, Filme filme) {
        filme.associarDiretor(diretor);
    }

    public void excluirArtista(Artista artista) {
        List<Filme> filmes = listar();

        if (filmes != null) {
            for (Filme filme : filmes) {
                if (filme.getArtistas() == null) {
                    continue;
                } else if (filme.getArtistas().contains(artista)) {
                    filme.desassociarArtista(artista);
                }
            }
        }
    }

    public void excluirDiretor(Diretor diretor) {
        List<Filme> filmes = listar();

        if (filmes != null) {
            for (Filme filme : filmes) {
                if (filme.getDiretores() == null) {
                    continue;
                } else if (filme.getDiretores().contains(diretor)) {
                    filme.desassociarDiretor(diretor);
                }
            }
        }
    }
}
