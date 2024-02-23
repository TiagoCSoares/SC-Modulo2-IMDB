package org.example;

import org.example.banco.BancoDeDados;
import org.example.repositories.ArtistaRepositorio;
import org.example.repositories.FilmeRepositorio;
import org.example.resources.IniciarArquivos;
import org.example.resources.LerArquivos;
import org.example.resources.LimparArquivos;
import org.example.services.ArtistaService;
import org.example.services.FilmeService;
import org.example.view.Menu;
import org.example.view.artista.ListarArtistaView;

public class Main {
    public static void main(String[] args) {

        BancoDeDados bancoDeDados = new BancoDeDados();
        new IniciarArquivos().iniciarArquivos();

        ArtistaRepositorio artistaRepositorio = new ArtistaRepositorio(bancoDeDados);
        ArtistaService artistaService = new ArtistaService(artistaRepositorio);
        //DiretorRepositorio diretorRepositorio = new DiretorRepositorio(bancoDeDados);
        //DiretorService diretorService = new DiretorService(diretorRepositorio);
        FilmeRepositorio filmeRepositorio = new FilmeRepositorio(bancoDeDados);
        FilmeService filmeService = new FilmeService(filmeRepositorio);

        // Preencher os bancos com os arquivos já criados
        LerArquivos.preencherBancoArtistas(artistaService);
        new LimparArquivos().limparArquivos();

        Menu principal = new Menu(artistaService, filmeService);
        principal.execute();
    }
}