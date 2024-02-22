package org.example.view.artista;

import org.example.entites.Artista;
import org.example.entites.Filme;
import org.example.services.ArtistaService;
import org.example.services.FilmeService;
import org.example.view.verificacoes.VerificacoesArtistaDiretor;
import org.example.view.verificacoes.VerificacoesFilme;

import java.util.List;
import java.util.Scanner;

public class CadastrarArtistaView {

    private ArtistaService artistaService;
    private FilmeService filmeService;

    public CadastrarArtistaView(ArtistaService artistaService, FilmeService filmeService) {
        this.artistaService = artistaService;
        this.filmeService = filmeService;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome do artista:");
        String nome = scanner.nextLine();
        VerificacoesArtistaDiretor verificacoes = new VerificacoesArtistaDiretor(artistaService);

        List artistasCadastrados = verificacoes.verficarArtistaCadastrado(nome);
        if(artistasCadastrados != null) {
            System.out.println("Artista já cadastrado");
            return;
        }

        System.out.println("Digite a data de nascimento do artista (DD/MM/YYYY):");
        String dataNascimento = scanner.nextLine();
        dataNascimento = verificacoes.verificarDataNascimento(dataNascimento);

        System.out.println("Digite o sexo do artista(M/F):");
        char sexo = scanner.nextLine().charAt(0);
        sexo = Character.toUpperCase(sexo);
        while(sexo != 'M' && sexo != 'F') {
            System.out.println("Sexo inválido, digite novamente(M/F):");
            sexo = scanner.nextLine().charAt(0);
            sexo = Character.toUpperCase(sexo);
        }

        List<Filme> filmes = new VerificacoesFilme(filmeService).cadastrarFilmes();

        Artista artista = new Artista(nome, dataNascimento, sexo, filmes);
        artistaService.criar(artista);
    }



}
