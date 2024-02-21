package org.example.services;

import org.example.entites.Artista;
import org.example.repositories.ArtistaRepositorio;
import org.example.resources.EscreverArquivos;

import java.util.List;

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

    public void atualizar(Artista artista) {
        if(artista == null) {
            throw new IllegalArgumentException("Artista não pode ser nulo");
        }
        if (artista.getNome() == null || artista.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do artista não pode ser nulo ou vazio");
        }
        Artista artistaSalvo = (Artista) artistaRepositorio.buscarPorId(artista.getId());
        if(artistaSalvo == null) {
            throw new IllegalArgumentException("Artista não encontrado");
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
        artistaRepositorio.escreverArquivo();
    }

    public List listar() {
        return artistaRepositorio.listar();
    }
}
