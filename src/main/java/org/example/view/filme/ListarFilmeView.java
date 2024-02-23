package org.example.view.filme;

import org.example.entites.Artista;
import org.example.entites.Filme;
import org.example.services.ArtistaService;
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
            System.out.printf("%-8s | %-25s | %-15s | %-50s | %-18s - %-7s\n",
                    "ID", "Nome", "Genero", "Descrição", "Ano de Lançamento", "Duração");
            for (Object obj : filmes) {
                Filme filme = (Filme) obj;
                System.out.printf("%-8d | %-25s | %-15s | %-50s | %-18d - %-7d\n",
                        filme.getId(), filme.getNome(), filme.getGenero(),
                        filme.getDescricao(), filme.getDataLancamento(), filme.getDuracao());
                System.out.println();
            }
        } else {
            System.out.println("Nenhum filme cadastrado");
        }
    }
}
