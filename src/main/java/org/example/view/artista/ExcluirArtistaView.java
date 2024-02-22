package org.example.view.artista;

import org.example.entites.Artista;
import org.example.services.ArtistaService;

import java.util.List;
import java.util.Scanner;

public class ExcluirArtistaView {

    private ArtistaService artistaService;

    public ExcluirArtistaView(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do arquivo que deseja excluir:");
        String nome = scanner.nextLine();

        List<Artista> listaArtistas = artistaService.pesquisarPorNome(nome);
        Artista achouArtista = null;

        for(Artista artista : listaArtistas) {
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
        if(achouArtista == null) {
            System.out.println("Artista não encontrado");
        }
    }
}
