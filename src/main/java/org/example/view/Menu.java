package org.example.view;

import org.example.entites.Diretor;
import org.example.services.ArtistaService;

import java.nio.file.DirectoryStream;

public class Menu extends AbstractMenuView{

    private ArtistaService artistaService;
    //private DiretorService diretorService;
    //private FilmeService filmeService;

    public Menu(ArtistaService artistaService) {
        super(new String[]{
                "1 - Filmes",
                "2 - Artistas",
                "3 - Diretores",
                "0 - Sair"
        });
        this.artistaService = artistaService;
    }

    @Override
    protected Boolean validOption(Integer option) {
        return option >= 0 && option <= 3;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            //case 2 -> new ArtistaMenu(obj).execute();
            case 0 -> System.exit(1);
            default -> System.out.println("Opcao não disponível");
        }
        execute();
    }
}
