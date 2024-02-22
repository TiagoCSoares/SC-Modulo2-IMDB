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
            System.out.print(artista.getId());
            System.out.print(artista.getNome());
            System.out.print(artista.getDataNascimento());
            System.out.print(artista.getSexo());
            for(Object filme: artista.getFilmes()) {
                System.out.println(filme);
            }
        }
    }
}
