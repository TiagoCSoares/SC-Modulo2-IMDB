package org.example.view.artista;

import org.example.entites.Artista;
import org.example.services.ArtistaService;
import org.example.services.FilmeService;
import org.example.view.verificacoes.VerificarArtista;

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
        Artista achouArtista = new VerificarArtista().verificarArtista(listaArtistas);

        if (achouArtista == null) {
            System.out.println("Artista não encontrado");
        } else {
            artistaService.excluir(achouArtista);
            filmeService.excluirArtista(achouArtista);
        }
    }
}
