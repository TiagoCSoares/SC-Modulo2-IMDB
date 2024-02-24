package org.example.services;


import org.example.entites.Diretor;
import org.example.entites.Filme;
import org.example.repositories.DiretorRepositorio;
import org.example.resources.EscreverArquivos;

import java.util.List;

public class DiretorService {

    private DiretorRepositorio diretorRepositorio;


    public DiretorService(DiretorRepositorio diretorRepositorio) {
        this.diretorRepositorio = diretorRepositorio;
    }

    public void criar(Diretor diretor) {
        if(diretor == null) {
            throw new IllegalArgumentException("Diretor não pode ser nulo");
        }
        if (diretor.getNome() == null || diretor.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do diretor não pode ser nulo ou vazio");
        }
        diretorRepositorio.gravar(diretor);
    }



    public void excluir(Diretor diretor) {
        if(diretor == null) {
            throw new IllegalArgumentException("Diretor não pode ser nulo");
        }
        if(diretor.getId() == null) {
            throw new IllegalArgumentException("Id do diretor não pode ser nulo");
        }
        Diretor artistaSalvo = (Diretor) diretorRepositorio.buscarPorId(diretor.getId());
        if(artistaSalvo == null) {
            throw new IllegalArgumentException("Diretor não encontrado");
        }
        diretorRepositorio.excluir(diretor);
    }


    public void escreverArquivo() {
        List<Diretor> diretores = listar();
        EscreverArquivos escrever = new EscreverArquivos();
        escrever.escreverDiretores(diretores);
    }


    public List listar() {
        return diretorRepositorio.listar();
    }

    public List<Diretor> pesquisarPorNome(String nome) {
        List<Diretor> diretores = null;
        if(nome != null) {
            diretores = diretorRepositorio.buscarPorNome(nome);
        }
        return diretores;
    }

    public void associarFilme(Diretor diretor, Filme filme) {
        diretorRepositorio.associarFilme(diretor, filme);
    }

    public void excluirFilme(Filme filme) {
        diretorRepositorio.excluirFilme(filme);
    }
}
