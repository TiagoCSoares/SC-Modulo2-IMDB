package org.example.repositories;

import org.example.banco.BancoDeDados;
import org.example.entites.Artista;
import org.example.entites.Diretor;
import org.example.entites.Filme;

import java.util.ArrayList;
import java.util.List;

public class DiretorRepositorio extends AbstractRepositorio {

    public DiretorRepositorio(BancoDeDados bancoDeDados) {
        super(bancoDeDados);
    }

    @Override
    protected Class classeModelo() {
        return Diretor.class;
    }

    @Override
    public void gravar(Object objeto) {
        Diretor diretor = (Diretor) objeto;
        if (diretor.getId() == null) {
            diretor.setId(bancoDeDados.proximoId());
        }
        super.gravar(objeto);
    }

    @Override
    protected Boolean filtraPorId(Object objeto, Long id) {
        Diretor diretor = (Diretor) objeto;
        return diretor.getId().equals(id);
    }

    @Override
    public List<Diretor> buscarPorNome(String nome) {
        nome = nome.toUpperCase();
        List<Diretor> diretores = listar();
        List<Diretor> diretoresEncontrados = new ArrayList<>();

        if (diretores != null) {
            for (Diretor diretor : diretores) {
                if (diretor.getNome().toUpperCase().contains(nome)) {
                    diretoresEncontrados.add(diretor);
                }
            }
        }
        if (diretoresEncontrados.isEmpty()) {
            return null;
        }
        return diretoresEncontrados;
    }

    @Override
    public void associarFilme(Object objeto, Filme filme) {
        Diretor diretor = (Diretor) objeto;
        diretor.associarFilme(filme);
    }


    @Override
    public void excluirFilme(Filme filme) {
        List<Diretor> diretores = listar();

        if (diretores != null) {
            for (Diretor diretor : diretores) {
                if ((diretor.getFilmes() == null) && (diretor.getFilmes().contains(filme))) {
                    diretor.desassociarFilme(filme);
                }
            }
        }
    }
}
