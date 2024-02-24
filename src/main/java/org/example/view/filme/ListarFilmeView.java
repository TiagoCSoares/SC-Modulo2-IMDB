package org.example.view.filme;

import org.example.entites.Filme;
import org.example.services.FilmeService;

import java.util.List;

public class ListarFilmeView {

    private FilmeService filmeService;

    public ListarFilmeView(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    public void execute() {
        List<Filme> filmes = filmeService.listar();
        if (!filmes.isEmpty()) {
            System.out.printf("%-8s | %-25s | %-15s | %-18s | %-7s | %-100s\n",
                    "ID", "Nome", "Genero", "Ano de Lançamento", "Duração", "Descrição");
            for (Object obj : filmes) {
                Filme filme = (Filme) obj;
                System.out.printf("%-8d | %-25s | %-15s | %-18d | %-7d | %-100s\n",
                        filme.getId(), filme.getNome(), filme.getGenero(), filme.getDataLancamento(),
                        filme.getDuracao(), filme.getDescricao());
                System.out.println();
            }
        } else {
            System.out.println("Nenhum filme cadastrado");
        }
    }
}
