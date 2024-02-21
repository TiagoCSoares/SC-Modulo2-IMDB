package org.example;

import org.example.banco.BancoDeDados;
import org.example.repositories.ArtistaRepositorio;
import org.example.services.ArtistaService;
import org.example.view.Menu;

public class Main {
    public static void main(String[] args) {

        BancoDeDados bancoDeDados = new BancoDeDados();
        //MusicoRepositorio musicoRepositorio = new MusicoRepositorio(bancoDeDados);
        //MusicoService musicoService = new MusicoService(musicoRepositorio);
        ArtistaRepositorio artistaRepositorio = new ArtistaRepositorio(bancoDeDados);
        ArtistaService artistaService = new ArtistaService(artistaRepositorio);
        //DiretorRepositorio diretorRepositorio = new DiretorRepositorio(bancoDeDados);
        //DiretorService diretorService = new DiretorService(diretorRepositorio);
        //FilmeRepositorio filmeRepositorio = new FilmeRepositorio(bancoDeDados);
        //FilmeService filmeService = new FilmeService(filmeRepositorio, musicoService, artistaService, diretorService);


        Menu principal = new Menu(artistaService/*, diretorService, filmeService*/);
        principal.execute();
    }
}