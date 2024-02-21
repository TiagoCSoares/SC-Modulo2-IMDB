package org.example.view.artista;

import org.example.entites.Artista;
import org.example.services.ArtistaService;

import java.util.List;

public class ListarArtistaView {

    private ArtistaService artistaService;

    public ListarArtistaView(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }

    public void execute() {
        List<Artista> artistas = artistaService.listar();
        for (Object obj: artistas) {
            Artista artista = (Artista) obj;
            System.out.println(artista.getId());
            System.out.println(artista.getNome());
            System.out.println(artista.getDataNascimento());
            System.out.println(artista.getSexo());
            for(Object filme: artista.getFilmes()) {
                System.out.println(filme);
            }
        }
    }
}
