package org.example.view.artista;

import org.example.entites.Artista;
import org.example.entites.Filme;
import org.example.services.ArtistaService;

import java.util.List;

public class ListarArtistaView {

    private ArtistaService artistaService;

    public ListarArtistaView(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }

    public void execute() {
        List<Artista> artistas = artistaService.listar();
        if (!artistas.isEmpty()) {
            System.out.printf("%-8s | %-25s | %-5s | %-4s | %-25s - %-15s\n",
                    "ID", "Nome", "Idade", "Sexo", "Nome Filme", "Genero");
            for (Artista artista : artistas) {
                System.out.printf("%-8d | %-25s | %-5d | %-4c ", artista.getId(), artista.getNome(),
                        artista.calcularIdade(), artista.getSexo());

                if(artista.getFilmes() != null) {
                    for (Filme filmes : artista.getFilmes()) {
                        if (filmes != null) {
                            System.out.printf("| %-25s - %-15s",
                                    filmes.getNome(), filmes.getGenero());
                        }
                    }
                    System.out.println();
                }
            }
        } else {
            System.out.println("Nenhum artista cadastrado");
        }
    }
}
