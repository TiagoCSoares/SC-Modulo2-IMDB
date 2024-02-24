package org.example.entites;

import java.util.ArrayList;
import java.util.List;

public class Filme {

    private  Long id;
    private final String nome;
    private final String descricao;
    private final String genero;
    private final Integer anoLancamento;
    private final Integer duracao;
    private  List<Artista> artistas;
    private  List<Diretor> diretores;

    public Filme(String nome, String genero, String descricao ,Integer anoLancamento, Integer duracao, List<Artista> artistas, List<Diretor> diretores) {
        this.nome = nome;
        this.genero = genero;
        this.descricao = descricao;
        this.anoLancamento = anoLancamento;
        this.duracao = duracao;
        this.artistas = artistas != null ? new ArrayList<>(artistas) : new ArrayList<>(); // Inicialize a lista de artistas
        this.diretores = diretores != null ? new ArrayList<>(diretores) : new ArrayList<>(); // Inicialize a lista de diretores
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }


    public String getGenero() {
        return genero;
    }


    public Integer getDataLancamento() {
        return anoLancamento;
    }


    public Integer getDuracao() {
        return duracao;
    }


    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }

    public List<Diretor> getDiretores() {
        return diretores;
    }

    public void setDiretores(List<Diretor> diretores) {
        this.diretores = diretores;
    }

    public String getDescricao() {
        return descricao;
    }


    public void associarArtista(Artista artista) {
        artistas.add(artista);
    }

    public void desassociarArtista(Artista artista) {
        artistas.remove(artista);
    }

    public void associarDiretor(Diretor diretor) {
        diretores.add(diretor);
    }

    public void desassociarDiretor(Diretor diretor) {
        diretores.remove(diretor);
    }
}
