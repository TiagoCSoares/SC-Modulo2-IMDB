package org.example.repositories;

import org.example.banco.BancoDeDados;
import org.example.entites.Artista;

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

}
