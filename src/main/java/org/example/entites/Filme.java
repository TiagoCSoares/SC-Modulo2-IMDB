package org.example.entites;

import java.util.List;

public class Filme {

    private Long id;
    private String nome;
    private String genero;
    private String dataLancamento;
    private Float duracao;
    private List<Artista> artistas;
    private List<Diretor> diretores;

    public Filme(String nome, String genero, String dataLancamento, Float duracao, List<Artista> artistas, List<Diretor> diretores) {
        this.nome = nome;
        this.genero = genero;
        this.dataLancamento = dataLancamento;
        this.duracao = duracao;
        this.artistas = artistas;
        this.diretores = diretores;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Float getDuracao() {
        return duracao;
    }

    public void setDuracao(Float duracao) {
        this.duracao = duracao;
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
}
