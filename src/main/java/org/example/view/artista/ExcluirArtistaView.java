package org.example.view.artista;

import org.example.entites.Artista;
import org.example.services.ArtistaService;
import org.example.services.FilmeService;

import java.util.List;
import java.util.Scanner;

public class ExcluirArtistaView {

    private ArtistaService artistaService;
    private FilmeService filmeService;

    public ExcluirArtistaView(ArtistaService artistaService, FilmeService filmeService) {
        this.artistaService = artistaService;
        this.filmeService = filmeService;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do artista que deseja excluir:");
        String nome = scanner.nextLine();

        List<Artista> listaArtistas = artistaService.pesquisarPorNome(nome);
        Artista achouArtista = null;
        if (listaArtistas != null) {
            for (Artista artista : listaArtistas) {
                System.out.print(artista.getNome() + "|" + artista.getDataNascimento());
                System.out.println("Esse é o artista desejado?(S/N)");
                char resposta = scanner.nextLine().charAt(0);
                resposta = Character.toUpperCase(resposta);
                if (resposta == 'S') {
                    achouArtista = artista;
                    artistaService.excluir(achouArtista);
                    break;
                }
            }
        } else {
            System.out.println("Não há artistas cadastrados!");
        }

        if (achouArtista == null) {
            System.out.println("Artista não encontrado");
        } else {
            System.out.println("Artista excluído com sucesso");
            // Excluir o artista de todos os filmes que ele participou
            filmeService.excluirArtista(achouArtista);
        }
    }
}
