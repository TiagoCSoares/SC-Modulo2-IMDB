package org.example.view.verificacoes;

import org.example.entites.Filme;
import org.example.services.FilmeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VerificacoesFilme {

    private FilmeService filmeService;

    public VerificacoesFilme(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    public List<Filme> cadastrarFilmes() {
        List<Filme> filmes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Deseja cadastrar novo filme? (S/N)");
        char resposta = scanner.nextLine().charAt(0);
        resposta = Character.toUpperCase(resposta);

        while(resposta == 'S') {
            System.out.println("Informe o nome do filme:");
            String nome = scanner.nextLine();
            List filmesCadastrados = filmeService.pesquisarPorNome(nome);
            if(filmesCadastrados != null) {
                System.out.println("Filme já cadastrado");
                System.out.println("Deseja cadastrar um novo filme?");
                resposta = scanner.nextLine().charAt(0);
                resposta = Character.toUpperCase(resposta);
                continue;
            }

            System.out.println("Informe o gênero do filme:");
            String genero = scanner.nextLine();

            System.out.println("Informe o ano de lançamento do filme:");
            while (!scanner.hasNextInt()) {
                System.out.print("Digite um valor válido para o ano de lançamento: ");
                scanner.next(); // Consome a entrada inválida
            }
            Integer anoLancamento = scanner.nextInt();


            System.out.println("Informe a duração do filme (em minutos):");
            while (!scanner.hasNextInt()) {
                System.out.print("Digite um valor válido para a duração do filme: ");
                scanner.next(); // Consome a entrada inválida
            }
            Integer duracao = scanner.nextInt();
            scanner.nextLine();


            Filme filme = new Filme(nome, genero, null, anoLancamento, duracao, null, null);
            filmes.add(filme);

            System.out.println("Deseja cadastrar um novo filme? (S/N)");
            resposta = scanner.nextLine().charAt(0);
            resposta = Character.toUpperCase(resposta);
        }
        return filmes;
    }
}
