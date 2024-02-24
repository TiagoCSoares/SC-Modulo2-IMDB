package org.example.view.filme;

import org.example.entites.Diretor;
import org.example.entites.Filme;
import org.example.services.FilmeService;
import org.example.view.verificacoes.VerificarFilme;

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
        Filme achouFilme = new VerificarFilme().verificarFilme(filmes);

        if (achouFilme == null) {
                System.out.println("O filme não foi encontrado!");
            } else if (achouFilme.getDiretores() == null || achouFilme.getDiretores().isEmpty()) {
                System.out.println("O filme não possui diretores cadastrados!");
            } else {
                System.out.printf("| %-8s | %-25s | %-5s | %-4s\n",
                        "ID", "Nome", "Idade", "Sexo");

                for (Diretor diretor : achouFilme.getDiretores()) {
                    System.out.printf("| %-8d | %-25s | %-5d | %-4c\n",
                           diretor.getId(), diretor.getNome(), diretor.calcularIdade(), diretor.getSexo());
                }
                System.out.println();
            }
        }
    }
