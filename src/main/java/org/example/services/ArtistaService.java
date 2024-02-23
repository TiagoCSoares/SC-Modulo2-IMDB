package org.example.services;

import org.example.entites.Artista;
import org.example.entites.Filme;
import org.example.repositories.ArtistaRepositorio;
import org.example.resources.EscreverArquivos;

import java.util.List;
import java.util.Set;

public class ArtistaService {


    private ArtistaRepositorio artistaRepositorio;


    public ArtistaService(ArtistaRepositorio artistaRepositorio) {
        this.artistaRepositorio = artistaRepositorio;
    }

    public void criar(Artista artista) {
        if(artista == null) {
            throw new IllegalArgumentException("Artista não pode ser nulo");
        }
        if (artista.getNome() == null || artista.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do artista não pode ser nulo ou vazio");
        }
        artistaRepositorio.gravar(artista);
    }



    public void excluir(Artista artista) {
        if(artista == null) {
            throw new IllegalArgumentException("Artista não pode ser nulo");
        }
        if(artista.getId() == null) {
            throw new IllegalArgumentException("Id do artista não pode ser nulo");
        }
        Artista artistaSalvo = (Artista) artistaRepositorio.buscarPorId(artista.getId());
        if(artistaSalvo == null) {
            throw new IllegalArgumentException("Artista não encontrado");
        }
        artistaRepositorio.excluir(artista);
    }


    public void escreverArquivo() {
        List<Artista> artistas = listar();
        EscreverArquivos escrever = new EscreverArquivos();
        escrever.escreverArtistas(artistas);
    }


    public List listar() {
        return artistaRepositorio.listar();
    }

    public List<Artista> pesquisarPorNome(String nome) {
        List<Artista> artistas = null;
        if(nome != null) {
            artistas = artistaRepositorio.buscarPorNome(nome);
        }
        return artistas;
    }

    public void associarFilme(Artista artista, Filme filme) {
        artistaRepositorio.associarFilme(artista, filme);
    }

    public void excluirFilme(Filme filme) {
        artistaRepositorio.excluirFilme(filme);
    }
}
