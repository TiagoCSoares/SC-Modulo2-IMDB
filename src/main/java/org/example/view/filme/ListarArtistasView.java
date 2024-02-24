package org.example.view.filme;

import org.example.entites.Artista;
import org.example.entites.Filme;
import org.example.services.FilmeService;
import org.example.view.verificacoes.VerificarFilme;

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
        Filme achouFilme = new VerificarFilme().verificarFilme(filmes);

        if (achouFilme == null) {
            System.out.println("O Filme não foi encontrado!");
        } else if (achouFilme.getArtistas() == null || achouFilme.getArtistas().isEmpty()) {
            System.out.println("Esse filme não tem artistas cadastrados!");
        } else {
            System.out.printf("%-8s | %-25s | %-5s | %-4s\n", "ID", "Nome", "Idade", "Sexo");

            for (Artista artista : achouFilme.getArtistas()) {
                System.out.printf("%-8d | %-25s | %-5d | %-4c\n",artista.getId(), artista.getNome(), artista.calcularIdade(), artista.getSexo());
            }
            System.out.println();
        }
    }
}
