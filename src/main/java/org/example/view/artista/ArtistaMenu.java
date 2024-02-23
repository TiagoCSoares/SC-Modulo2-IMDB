package org.example.view.artista;

import org.example.entites.Artista;
import org.example.entites.Filme;
import org.example.services.ArtistaService;
import org.example.services.FilmeService;
import org.example.view.AbstractMenuView;

public class ArtistaMenu extends AbstractMenuView {

    private ArtistaService artistaService;
    private FilmeService filmeService;

    public ArtistaMenu(ArtistaService artistaService, FilmeService filmeService) {
        super(new String[]{
            "1 - Cadastrar Artista",
            "2 - Atualizar Artista",
            "3 - Excluir Artista",
            "4 - Listar Artistas",
            "5 - Associar Filme ao Artista",
            //"6 - Listar Filmes do Artista",
            "0 - Voltar"
        });
        this.artistaService = artistaService;
        this.filmeService = filmeService;
    }

    @Override
    protected Boolean validOption(Integer option) {
        return option >= 0 && option <= 5;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 1 -> new CadastrarArtistaView(artistaService).execute();
            case 3 -> new ExcluirArtistaView(artistaService, filmeService).execute();
            case 4 -> new ListarArtistaView(artistaService/*, filmeService*/).execute();
            case 5 -> new AssociarFilmeView(artistaService, filmeService).execute();
            // TODO: Opção de listar filmes do artista, para isso o listar artistas deixaria de mostrar os filmes
            case 0 -> {return;}
            default -> System.out.println("Opcao não disponível");
        }
        execute();
    }
}
