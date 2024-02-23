package org.example.services;

import org.example.entites.Artista;
import org.example.entites.Filme;
import org.example.repositories.FilmeRepositorio;
import org.example.resources.EscreverArquivos;

import java.util.List;

public class FilmeService {

    private FilmeRepositorio filmeRepositorio;

    public FilmeService(FilmeRepositorio filmeRepositorio) {
        this.filmeRepositorio = filmeRepositorio;
    }

    public void criar(Filme filme) {
        if(filme == null) {
            throw new IllegalArgumentException("Filme não pode ser nulo");
        }
        if (filme.getNome() == null || filme.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do filme não pode ser nulo ou vazio");
        }
        filmeRepositorio.gravar(filme);
    }

    public void excluir (Filme filme) {
        if(filme == null) {
            throw new IllegalArgumentException("Filme não pode ser nulo");
        }
        if(filme.getId() == null) {
            throw new IllegalArgumentException("Id do filme não pode ser nulo");
        }
        Filme filmeSalvo = (Filme) filmeRepositorio.buscarPorId(filme.getId());
        if(filmeSalvo == null) {
            throw new IllegalArgumentException("Filme não encontrado");
        }
        filmeRepositorio.excluir(filme);
    }


    public void escreverArquivo() {
        List<Filme> filmes = listar();
        EscreverArquivos escrever = new EscreverArquivos();
        escrever.escreverFilmes(filmes);
    }


    public List listar() {
        return filmeRepositorio.listar();
    }

    public List<Filme> pesquisarPorNome(String nome) {
        List<Filme> filmes = null;
        if(nome != null) {
            filmes = filmeRepositorio.buscarPorNome(nome);
        }
        return filmes;
    }


    public void associarArtista(Artista artista, Filme filme) {
        filmeRepositorio.associarFilme(artista, filme);
    }

    public void excluirArtista(Artista artista) {
        filmeRepositorio.excluirArtista(artista);
    }

}
