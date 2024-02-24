package org.example.view.artista;

import org.example.entites.Artista;
import org.example.services.ArtistaService;
import org.example.view.verificacoes.VerificarDataNascimento;

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

        System.out.println("Digite a data de nascimento do artista (DD/MM/YYYY):");
        String dataNascimento = scanner.nextLine();
        dataNascimento =  new VerificarDataNascimento().verificarDataNascimento(dataNascimento);

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
