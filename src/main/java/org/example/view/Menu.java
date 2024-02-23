package org.example.view;

import org.example.entites.Diretor;
import org.example.resources.EscreverArquivos;
import org.example.services.ArtistaService;
import org.example.services.FilmeService;
import org.example.view.artista.ArtistaMenu;
import org.example.view.artista.ListarArtistaView;

import java.nio.file.DirectoryStream;
import java.util.HashSet;
import java.util.Set;

public class Menu extends AbstractMenuView{

    private ArtistaService artistaService;
    //private DiretorService diretorService;
    private FilmeService filmeService;

    public Menu(ArtistaService artistaService, FilmeService filmeService) {
        super(new String[]{
                "1 - Filmes",
                "2 - Artistas",
                "3 - Diretores",
                "0 - Sair\n"
        });
        this.artistaService = artistaService;
        this.filmeService = filmeService;
    }

    @Override
    protected Boolean validOption(Integer option) {
        return option >= 0 && option <= 3;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 2 -> new ArtistaMenu(artistaService, filmeService).execute();
            case 0 -> {
                //Set<Object> artistas = new HashSet<>(artistaService.listar());
                artistaService.escreverArquivo();
                System.exit(1);
                }

            default -> System.out.println("Opcao não disponível");
        }
        execute();
    }
}
