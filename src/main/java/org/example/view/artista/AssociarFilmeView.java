package org.example.view.artista;

import org.example.entites.Artista;
import org.example.entites.Filme;
import org.example.services.ArtistaService;
import org.example.services.FilmeService;

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
        Artista artistaEncontrado = null;
        if (artistas != null && !artistas.isEmpty()) {
            for (Artista artista : artistas) {
                System.out.print(artista.getNome() + "|" + artista.getDataNascimento());
                System.out.println("Esse é o artista desejado?(S/N)");
                char resposta = scanner.nextLine().charAt(0);
                resposta = Character.toUpperCase(resposta);
                if (resposta == 'S') {
                    artistaEncontrado = artista;
                    break;
                }
            }
        } else {
            System.out.println("Artista não encontrado, cadastre o artista antes de associar ao filme");
            return;
        }

        System.out.println("Informe o nome do filme:");
        String nomeFilme = scanner.nextLine();

        List<Filme> filmes = filmeService.pesquisarPorNome(nomeFilme);
        Filme filmeEncontrado = null;
        if (filmes != null && !filmes.isEmpty()){
            for (Filme filme : filmes) {
                System.out.print(filme.getNome() + "|" + filme.getGenero());
                System.out.println("Esse é o artista desejado?(S/N)");
                char resposta = scanner.nextLine().charAt(0);
                resposta = Character.toUpperCase(resposta);
                if (resposta == 'S') {
                    filmeEncontrado = filme;
                    break;
                }
            }
        } else  {
            System.out.println("Filme não encontrado, cadastre o filme antes de associar ao artista");
            return;
        }


        // O artista não precisa  receber a lista dos outros artistas, evitar loop infinito
        filmeEncontrado.setArtistas(new ArrayList<>());
        filmeEncontrado.setDiretores(new ArrayList<>());
        artistaService.associarFilme(artistaEncontrado, filmeEncontrado);
        filmeService.associarArtista(artistaEncontrado, filmeEncontrado);
    }
}
