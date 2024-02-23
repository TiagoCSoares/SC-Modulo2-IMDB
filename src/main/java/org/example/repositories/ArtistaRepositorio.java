package org.example.repositories;

import org.example.banco.BancoDeDados;
import org.example.entites.Artista;
import org.example.entites.Filme;
import org.example.resources.EscreverArquivos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ArtistaRepositorio extends AbstractRepositorio {

    public ArtistaRepositorio(BancoDeDados bancoDeDados) {
        super(bancoDeDados);
    }

    @Override
    protected Class classeModelo() {
        return Artista.class;
    }

    @Override
    public void gravar(Object objeto) {
        Artista artista = (Artista) objeto;
        if (artista.getId() == null) {
            artista.setId(bancoDeDados.proximoId());
        }
        super.gravar(objeto);
    }

    @Override
    protected Boolean filtraPorId(Object objeto, Long id) {
        Artista artista = (Artista) objeto;
        return artista.getId().equals(id);
    }

    @Override
    public List<Artista> buscarPorNome(String nome) {
        nome = nome.toUpperCase();
        List<Artista> artistas = listar();
        List<Artista> artistasEncontrados = new ArrayList<>();

        if (artistas != null) {
            for (Artista artista : artistas) {
                if (artista.getNome().toUpperCase().contains(nome)) {
                    artistasEncontrados.add(artista);
                }
            }
        }
        if (artistasEncontrados.isEmpty()) {
            return null;
        }
        return artistasEncontrados;
    }

    @Override
    public void associarFilme(Object objeto, Filme filme) {
        Artista artista = (Artista) objeto;
        artista.associarFilme(filme);
    }

    @Override
    public void excluirFilme(Filme filme) {
        List<Artista> artistas = listar();

        // Se artistas for null não há filmes para serem excluídos, exclui a chance de ter erro
        if (artistas != null) {
            for (Artista artista : artistas) {
                if (artista.getFilmes().contains(filme) && (artista.getFilmes() != null)) {
                    artista.desassociarFilme(filme);
                }
            }
        }
    }
}
