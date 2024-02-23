package org.example.view.filme;

import org.example.entites.Artista;
import org.example.entites.Filme;
import org.example.services.FilmeService;

import java.util.List;
import java.util.Scanner;

public class ListarArtistasView {

    private FilmeService filmeService;

    public ListarArtistasView(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual o nome do filme?");
        String nome = scanner.nextLine();

        List<Filme> filmes = filmeService.pesquisarPorNome(nome);
        Filme achouFilme = null;

        if (filmes != null) {
            for (Filme filme : filmes) {
                System.out.println(filme.getNome() + " | " + filme.getGenero());
                System.out.println("Esse é o filme desejado?(S/N)");
                char resposta = scanner.nextLine().charAt(0);
                resposta = Character.toUpperCase(resposta);

                if (resposta == 'S') {
                    achouFilme = filme;
                    break;
                }
            }
            if(achouFilme == null) {
                System.out.println("O Filme não foi encontrado!");
            } else if (achouFilme.getArtistas() == null || achouFilme.getArtistas().isEmpty()) {
                System.out.println("Esse filme não tem artistas cadastrados!");
            } else {
                System.out.printf("%-25s | %-5s | %-4s\n",
                        "Nome", "Idade", "Sexo");

                for (Artista artista : achouFilme.getArtistas()) {
                    System.out.printf("%-25s | %-5d | %-4c\n",
                            artista.getNome(), artista.calcularIdade(), artista.getSexo());
                }
                System.out.println();
            }
        } else {
            System.out.println("Não há filmes cadastrados!");
        }
    }
}
