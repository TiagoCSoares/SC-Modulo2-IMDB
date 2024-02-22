package org.example.view.artista;

import org.example.entites.Artista;
import org.example.services.ArtistaService;
import org.example.view.AbstractMenuView;

public class ArtistaMenu extends AbstractMenuView {

    private ArtistaService artistaService;

    public ArtistaMenu(ArtistaService artistaService) {
        super(new String[]{
            "1 - Cadastrar Artista",
            "2 - Atualizar Artista",
            "3 - Excluir Artista",
            "4 - Listar Artistas",
            "0 - Voltar"
        });
        this.artistaService = artistaService;
    }

    @Override
    protected Boolean validOption(Integer option) {
        return option >= 0 && option <= 4;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 1 -> new CadastrarArtistaView(artistaService).execute();
            case 3 -> new ExcluirArtistaView(artistaService).execute();
            case 4 -> new ListarArtistaView(artistaService).execute();
            case 0 -> {return;}
            default -> System.out.println("Opcao não disponível");
        }
        execute();
    }
}
