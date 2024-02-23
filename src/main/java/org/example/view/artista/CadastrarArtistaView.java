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

    public CadastrarArtistaView(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome do artista:");
        String nome = scanner.nextLine();

        List artistasCadastrados = artistaService.pesquisarPorNome(nome);
        if(artistasCadastrados != null) {
            System.out.println("Artista já cadastrado");
            return;

        }

        System.out.println("Digite a data de nascimento do artista (DD/MM/YYYY):");
        String dataNascimento = scanner.nextLine();
        dataNascimento =  new VerificacoesArtistaDiretor(artistaService).verificarDataNascimento(dataNascimento);

        System.out.println("Digite o sexo do artista(M/F):");
        char sexo = scanner.nextLine().charAt(0);
        sexo = Character.toUpperCase(sexo);
        while(sexo != 'M' && sexo != 'F') {
            System.out.println("Sexo inválido, digite novamente(M/F):");
            sexo = scanner.nextLine().charAt(0);
            sexo = Character.toUpperCase(sexo);
        }


        Artista artista = new Artista(nome, dataNascimento, sexo, null);
        artistaService.criar(artista);
    }
}
