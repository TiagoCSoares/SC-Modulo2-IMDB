package org.example.view.diretor;


import org.example.entites.Diretor;
import org.example.entites.Filme;
import org.example.services.DiretorService;

import java.util.List;

public class ListarDiretorView {

    private DiretorService diretorService;

    public ListarDiretorView(DiretorService diretorService) {
        this.diretorService = diretorService;
    }

    public void execute() {
        List<Diretor> diretores = diretorService.listar();
        if (!diretores.isEmpty()) {
            System.out.printf("%-8s | %-25s | %-5s | %-4s | %-25s - %-15s\n",
                    "ID", "Nome", "Idade", "Sexo", "Nome Filme", "Genero");

            for (Diretor diretor : diretores) {
                System.out.printf("%-8d | %-25s | %-5d | %-4c ",
                        diretor.getId(), diretor.getNome(),
                        diretor.calcularIdade(), diretor.getSexo());

                if (diretor.getFilmes() != null) {
                    for (Filme filmes : diretor.getFilmes()) {
                        if (filmes != null) {
                            System.out.printf("| %-25s - %-15s", filmes.getNome(), filmes.getGenero());
                        }
                    }
                    System.out.println();
                }
            }
        } else {
            System.out.println("Nenhum diretor cadastrado");
        }
    }
}
