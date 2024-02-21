package org.example.services;

import org.example.repositories.ArtistaRepositorio;

public class ArtistaService {

    private ArtistaRepositorio artistaRepositorio;

    public ArtistaService(ArtistaRepositorio artistaRepositorio) {
        this.artistaRepositorio = artistaRepositorio;
    }
}
