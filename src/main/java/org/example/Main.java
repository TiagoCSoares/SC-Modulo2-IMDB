package org.example;

import org.example.banco.BancoDeDados;
import org.example.view.Menu;

public class Main {
    public static void main(String[] args) {

        BancoDeDados bancoDeDados = new BancoDeDados();
        //MusicoRepositorio musicoRepositorio = new MusicoRepositorio(bancoDeDados);
        //MusicoService musicoService = new MusicoService(musicoRepositorio);

        Menu principal = new Menu(null);
        principal.execute();
    }
}