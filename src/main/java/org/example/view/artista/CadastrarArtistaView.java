package org.example.view.artista;

import org.example.entites.Artista;
import org.example.entites.Filme;
import org.example.services.ArtistaService;

import java.io.IOException;
import java.lang.module.ModuleFinder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastrarArtistaView {

    private ArtistaService artistaService;

    public CadastrarArtistaView(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do artista:");
        String nome = scanner.nextLine();
        System.out.println("Digite a data de nascimento do artista:");
        String dataNascimento = scanner.nextLine();
        System.out.println("Digite o sexo do artista(M/F):");
        char sexo = scanner.nextLine().charAt(0);
        List<Filme> filmes = cadastrarFilmes();
        Artista artista = new Artista(nome, dataNascimento, sexo, filmes);
        artistaService.criar(artista);
    }



    public List<Filme> cadastrarFilmes() {
        List<Filme> filmes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Deseja cadastrar um filme para o artista? (S/N)");
        char resposta = scanner.nextLine().charAt(0);
        while(resposta == 'S') {
            System.out.println("Informe o nome do filme:");
            String nome = scanner.nextLine();
            // TODO: Implementar a busca pelo nome, se o filme já existir na base de dados apenas pegar as informações
            System.out.println("Informe o gênero do filme:");
            String genero = scanner.nextLine();
            System.out.println("Informe a data de lançamento do filme:");
            String anoLancamento = scanner.nextLine();
            System.out.println("Informe a duração do filme:");
            float duracao = scanner.nextFloat();
            Filme filme = new Filme(nome, genero, anoLancamento, duracao, null, null);
            filmes.add(filme);

            System.out.println("Deseja cadastrar um filme para o artista? (S/N)");
            resposta = scanner.nextLine().charAt(0);
        }
        return filmes;
    }

}
