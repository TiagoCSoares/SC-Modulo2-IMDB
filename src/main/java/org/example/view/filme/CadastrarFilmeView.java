package org.example.view.filme;

import org.example.entites.Artista;
import org.example.entites.Filme;
import org.example.services.ArtistaService;
import org.example.services.FilmeService;
import org.example.view.verificacoes.VerificarDataNascimento;

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

        System.out.println("Digite a data de lançamento do filme:");
        Integer dataLancamento = scanner.nextInt();

        System.out.println("Digite a duração do filme:");
        Integer duracao = scanner.nextInt();

        Filme filme = new Filme(nome, genero, descricao, dataLancamento, duracao, null, null);
        filmeService.criar(filme);
    }
}
