package org.example.view.filme;

import org.example.entites.Filme;
import org.example.services.FilmeService;

import java.util.List;
import java.util.Scanner;

public class BuscarFilmeView {

    private FilmeService filmeService;

    public BuscarFilmeView(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual filme você deseja buscar?:");
        String nome = scanner.nextLine();

        List<Filme> listaFilmes = filmeService.pesquisarPorNome(nome);
        Boolean achouFilme = false;

        if(listaFilmes != null) {
            for (Filme filme : listaFilmes) {
                System.out.print(filme.getNome() + "|" + filme.getGenero());
                System.out.println("Esse é o filme desejado?(S/N)");
                char resposta = scanner.nextLine().charAt(0);
                resposta = Character.toUpperCase(resposta);
                if (resposta == 'S') {
                    achouFilme = true;
                    System.out.printf("%-8s | %-25s | %-15s | %-18s | %-7s | %-100s\n",
                            "ID", "Nome", "Genero", "Ano de Lançamento", "Duração", "Descrição");
                    System.out.printf("%-8d | %-25s | %-15s | %-18d | %-7d | %-100s\n",
                            filme.getId(), filme.getNome(), filme.getGenero(), filme.getDataLancamento(),
                            filme.getDuracao(), filme.getDescricao());
                    System.out.println();
                    break;
                }
            }
        }
        if(!achouFilme) {
            System.out.println("Filme não encontrado");
        }
    }
}
