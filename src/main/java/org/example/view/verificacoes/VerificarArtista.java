package org.example.view.verificacoes;

import org.example.entites.Artista;

import java.util.List;
import java.util.Scanner;

public class VerificarArtista {

    public Artista verificarArtista(List<Artista> artistas) {
        Scanner scanner = new Scanner(System.in);
        Artista artistaEncontrado;

        if (artistas != null && !artistas.isEmpty()) {
            for (Artista artista : artistas) {
                System.out.println(artista.getId() + " | " + artista.getNome() + " | " + artista.getDataNascimento());
                System.out.println("Esse é o artista desejado?(S/N)");
                char resposta = scanner.nextLine().charAt(0);
                resposta = Character.toUpperCase(resposta);
                if (resposta == 'S') {
                    artistaEncontrado = artista;
                    return artistaEncontrado;
                }
            }
        }
        return null;
    }
}
