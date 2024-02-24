package org.example.view.verificacoes;

import org.example.entites.Filme;

import java.util.List;
import java.util.Scanner;

public class VerificarFilme {

    public Filme verificarFilme(List<Filme> filmes) {
        Filme filmeEncontrado;
        Scanner scanner = new Scanner(System.in);
        if (filmes != null && !filmes.isEmpty()){
            for (Filme filme : filmes) {
                System.out.println(filme.getId() + " | "  + filme.getNome() + " | " + filme.getGenero());
                System.out.println("Esse é o filme desejado?(S/N)");
                char resposta = scanner.nextLine().charAt(0);
                resposta = Character.toUpperCase(resposta);
                if (resposta == 'S') {
                    filmeEncontrado = filme;
                    return filmeEncontrado;
                }
            }
        }
        return null;
    }
}
