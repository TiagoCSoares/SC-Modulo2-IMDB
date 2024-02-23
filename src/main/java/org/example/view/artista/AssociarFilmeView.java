package org.example.view.artista;

import org.example.entites.Artista;
import org.example.entites.Filme;
import org.example.services.ArtistaService;
import org.example.services.FilmeService;

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

        List artistas = artistaService.pesquisarPorNome(nome);
        if(artistas == null) {
            System.out.println("Artista não encontrado, cadastre o artista antes de associar ao filme");
            return;
        }

        System.out.println("Informe o nome do filme:");
        String nomeFilme = scanner.nextLine();

        List filmes = filmeService.pesquisarPorNome(nomeFilme);
        if(filmes == null) {
            System.out.println("Filme não encontrado, cadastre o filme antes de associar ao artista");
            return;
        }

        Artista artista = (Artista) artistas.get(0);
        Filme filme = (Filme) filmes.get(0);
        // O artista não precisa  receber a lista dos outros artistas, evitar loop infinito
        filme.setArtistas(null);
        filme.setDiretores(null);
        artistaService.associarFilme(artista, filme);
        filmeService.associarArtista(artista, filme);
    }
}
