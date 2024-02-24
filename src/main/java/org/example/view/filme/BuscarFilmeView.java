package org.example.view.filme;

import org.example.entites.Filme;
import org.example.services.FilmeService;
import org.example.view.verificacoes.VerificarFilme;

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
        Filme filmeEncontrado = new VerificarFilme().verificarFilme(listaFilmes);

        if(filmeEncontrado == null) {
            System.out.println("Filme não encontrado");
        } else {
            System.out.printf("%-8s | %-25s | %-15s | %-18s | %-7s | %-100s\n",
                    "ID", "Nome", "Genero", "Ano de Lançamento", "Duração", "Descrição");
            System.out.printf("%-8d | %-25s | %-15s | %-18d | %-7d | %-100s\n",
                    filmeEncontrado.getId(), filmeEncontrado.getNome(), filmeEncontrado.getGenero(),
                    filmeEncontrado.getDataLancamento(), filmeEncontrado.getDuracao(), filmeEncontrado.getDescricao());
            System.out.println();
        }
    }
}
