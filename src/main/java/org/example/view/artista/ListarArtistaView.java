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
        if (artistas != null) {
            System.out.printf("%-8s | %-30s | %-10s | %-4s | %-8s - %-45s - %-10s\n",
                    "ID", "Nome", "Data Nascimento", "Sexo", "ID Filme", "Nome Filme", "Genero");
            for (Object obj : artistas) {
                Artista artista = (Artista) obj;
                System.out.printf("%-8d | %-30s | %-10s | %-4c", artista.getId(), artista.getNome(),
                        artista.getDataNascimento(), artista.getSexo());
                for (Filme filmes : artista.getFilmes()) {
                    System.out.printf(" | %-8d - %-45s - %-10s", filmes.getId(), filmes.getNome(), filmes.getGenero());
                }
            }
        } else {
            System.out.println("Nenhum artista cadastrado");
        }
    }
}
