package org.example.view.artista;

import org.example.entites.Artista;
import org.example.services.ArtistaService;
import org.example.view.AbstractMenuView;

public class ArtistaMenu extends AbstractMenuView {

    private ArtistaService artistaService;

    public ArtistaMenu(ArtistaService artistaService) {
        super(new String[]{
            "1 - Cadastrar Artista",
            "2 - Listar Artistas",
            "3 - Excluir Artista",
            "0 - Voltar"
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
            case 1 -> new CadastrarArtistaView(this.artistaService).execute();
            case 2 -> new ListarArtistaView(this.artistaService).execute();
            case 0 -> {return;}
            default -> System.out.println("Opcao não disponível");
        }
        execute();
    }
}
