package org.example.repositories;

import org.example.banco.BancoDeDados;
import org.example.entites.Artista;
import org.example.resources.EscreverArquivos;

import java.util.Set;

public class ArtistaRepositorio extends  AbstractRepositorio {

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

    public void escreverArquivo() {
        Set<Object> artistas = (Set<Object>) bancoDeDados.buscarObjetosPorTipo(Artista.class);
        EscreverArquivos escrever = new EscreverArquivos();
        escrever.escreverArtistas(artistas);
    }
}
