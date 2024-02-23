package org.example.view.filme;

import org.example.entites.Artista;
import org.example.entites.Diretor;
import org.example.entites.Filme;
import org.example.services.FilmeService;

import java.util.List;
import java.util.Scanner;

public class ListarDiretoresView {

    private FilmeService filmeService;

    public ListarDiretoresView(FilmeService filmeService) {
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
                System.out.printf("%-25s | %-15s\n",
                        "Nome do Filme", "Gênero");
                System.out.printf("%-25s | %-15s\n",
                        filme.getNome(), filme.getGenero());

                char resposta = scanner.nextLine().charAt(0);
                resposta = Character.toUpperCase(resposta);

                if (resposta == 'S') {
                    achouFilme = filme;
                    break;
                }
            }

            if (achouFilme == null) {
                System.out.println("O filme não foi encontrado!");
            } else if (achouFilme.getDiretores().isEmpty() || achouFilme.getDiretores().isEmpty()) {
                System.out.println("O filme não possui diretores cadastrados!");
            } else {
                System.out.printf("| %-25s | %-5s | %-4s\n",
                        "Nome", "Idade", "Sexo");

                for (Diretor diretor : achouFilme.getDiretores()) {
                    System.out.printf("| %-25s | %-5d | %-4c\n",
                            diretor.getNome(), diretor.calcularIdade(), diretor.getSexo());
                }
                System.out.println();
            }
        } else {
            System.out.println("Não há filmes cadastrados!");
        }
    }
}
