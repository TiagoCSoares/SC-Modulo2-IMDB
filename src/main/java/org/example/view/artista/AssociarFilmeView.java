package org.example.view.artista;

import org.example.entites.Artista;
import org.example.entites.Filme;
import org.example.services.ArtistaService;
import org.example.services.FilmeService;
import org.example.view.verificacoes.VerificarArtista;
import org.example.view.verificacoes.VerificarFilme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AssociarFilmeView {

    private ArtistaService artistaService;
    private FilmeService filmeService;

    public AssociarFilmeView(ArtistaService artistaService, FilmeService filmeService) {
        this.artistaService = artistaService;
        this.filmeService = filmeService;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do artista:");
        String nome = scanner.nextLine();

        List<Artista> artistas = artistaService.pesquisarPorNome(nome);
        Artista artistaEncontrado = new VerificarArtista().verificarArtista(artistas);
        if (artistaEncontrado == null){
            System.out.println("Artista não encontrado, cadastre o artista antes de associar ao filme");
            return;
        }

        System.out.println("Informe o nome do filme:");
        String nomeFilme = scanner.nextLine();

        List<Filme> filmes = filmeService.pesquisarPorNome(nomeFilme);
        Filme filmeEncontrado =  new VerificarFilme().verificarFilme(filmes);
        if (filmeEncontrado == null){
            System.out.println("Filme não encontrado, cadastre o filme antes de associar ao artista");
            return;
        }


        filmeEncontrado.setArtistas(new ArrayList<>());
        artistaService.associarFilme(artistaEncontrado, filmeEncontrado);
        filmeService.associarArtista(artistaEncontrado, filmeEncontrado);
    }
}
