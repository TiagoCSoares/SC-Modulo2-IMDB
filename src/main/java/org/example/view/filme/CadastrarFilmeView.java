package org.example.view.filme;

import org.example.entites.Artista;
import org.example.entites.Filme;
import org.example.services.ArtistaService;
import org.example.services.FilmeService;
import org.example.view.verificacoes.VerificarDataNascimento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastrarFilmeView {

    private FilmeService filmeService;

    public CadastrarFilmeView(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome do filme:");
        String nome = scanner.nextLine();

        List filmesCadastrados = filmeService.pesquisarPorNome(nome);
        if(filmesCadastrados != null) {
            System.out.println("Filme já cadastrado");
            return;

        }

        System.out.println("Digite o genêro do filme:");
        String genero = scanner.nextLine();

        System.out.println("Digite a descrição do filme:");
        String descricao = scanner.nextLine();

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

        Filme filme = new Filme(nome, genero, descricao, anoLancamento, duracao, new ArrayList<>(), new ArrayList<>());
        filmeService.criar(filme);
    }
}
