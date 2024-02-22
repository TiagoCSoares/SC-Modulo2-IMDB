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
        // TODO: Validar se o nome já está cadastrado, se sim verificar as outras características do artista

        System.out.println("Digite a data de nascimento do artista (DD/MM/YYYY):");
        String dataNascimento = scanner.nextLine();
        dataNascimento = verificarDataNascimento(dataNascimento);

        System.out.println("Digite o sexo do artista(M/F):");
        char sexo = scanner.nextLine().charAt(0);
        sexo = Character.toUpperCase(sexo);
        while(sexo != 'M' && sexo != 'F') {
            System.out.println("Sexo inválido, digite novamente(M/F):");
            sexo = scanner.nextLine().charAt(0);
            sexo = Character.toUpperCase(sexo);
        }

        List<Filme> filmes = cadastrarFilmes();

        Artista artista = new Artista(nome, dataNascimento, sexo, filmes);
        artistaService.criar(artista);
    }



    public String verificarDataNascimento(String dataNascimento) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String[] elementos = dataNascimento.split("/");
            if (elementos.length == 3) { // Verifica se a entrada contém três partes (dia, mês, ano)
                try {
                    int dia = Integer.parseInt(elementos[0]);
                    int mes = Integer.parseInt(elementos[1]);
                    int ano = Integer.parseInt(elementos[2]);

                    // Validar se a data é válida
                    if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && ano >= 1900) {
                        break; // Sai do loop se a data for válida
                    } else {
                        System.out.println("Data de nascimento inválida. Por favor, digite novamente:");
                        dataNascimento = scanner.nextLine();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Formato inválido. Certifique-se de digitar a data no formato DD/MM/YYYY:");
                    dataNascimento = scanner.nextLine();
                }
            } else {
                System.out.println("Formato inválido. Certifique-se de digitar a data no formato DD/MM/YYYY:");
                dataNascimento = scanner.nextLine();
            }
        }
        return dataNascimento;
    }




    public List<Filme> cadastrarFilmes() {
        List<Filme> filmes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Deseja cadastrar um filme para o artista? (S/N)");
        char resposta = scanner.nextLine().charAt(0);
        resposta = Character.toUpperCase(resposta);

        while(resposta == 'S') {
            System.out.println("Informe o nome do filme:");
            String nome = scanner.nextLine();

            System.out.println("Informe o gênero do filme:");
            String genero = scanner.nextLine();

            System.out.println("Informe o ano de lançamento do filme:");
            while (!scanner.hasNextInt()) {
                System.out.print("Digite um valor válido para o ano de lançamento: ");
                scanner.next(); // Consome a entrada inválida
            }
            Integer anoLancamento = scanner.nextInt();


            System.out.println("Informe a duração do filme:");
            while (!scanner.hasNextFloat()) {
                System.out.print("Digite um valor válido para a duração do filme: ");
                scanner.next(); // Consome a entrada inválida
            }
            float duracao = scanner.nextFloat();

            Filme filme = new Filme(nome, genero, anoLancamento, duracao, null, null);
            filmes.add(filme);

            System.out.println("Deseja cadastrar um filme para o artista? (S/N)");
            resposta = scanner.nextLine().charAt(0);
            resposta = Character.toUpperCase(resposta);
        }
        return filmes;
    }

}
