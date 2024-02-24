package org.example.view.verificacoes;

import org.example.entites.Diretor;

import java.util.List;
import java.util.Scanner;

public class VerificarDiretor {

    public Diretor verificarDiretor(List<Diretor> diretores) {
        Scanner scanner = new Scanner(System.in);
        Diretor diretorEncontrado;

        if (diretores != null && !diretores.isEmpty()) {
            for (Diretor diretor : diretores) {
                System.out.println(diretor.getId() + " | " + diretor.getNome() + " | " + diretor.getDataNascimento());
                System.out.println("Esse é o artista desejado?(S/N)");
                char resposta = scanner.nextLine().charAt(0);
                resposta = Character.toUpperCase(resposta);
                if (resposta == 'S') {
                    diretorEncontrado = diretor;
                    return diretorEncontrado;
                }
            }
        }
        return null;
    }
}
