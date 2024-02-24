package org.example.view.artista;

import org.example.services.ArtistaService;
import org.example.services.FilmeService;
import org.example.view.AbstractMenuView;

public class ArtistaMenu extends AbstractMenuView {

    private ArtistaService artistaService;
    private FilmeService filmeService;

    public ArtistaMenu(ArtistaService artistaService, FilmeService filmeService) {
        super(new String[]{
            "1 - Cadastrar Artista",
            "2 - Excluir Artista",
            "3 - Listar Artistas",
            "4 - Associar Filme ao Artista",
            "5 - Listar Filmes do Artista",
            "0 - Voltar\n"
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
            case 2 -> new ExcluirArtistaView(artistaService, filmeService).execute();
            case 3 -> new ListarArtistaView(artistaService).execute();
            case 4 -> new AssociarFilmeView(artistaService, filmeService).execute();
            case 5 -> new ListarFilmesView(artistaService).execute();
            //case 6 -> new AtualizarArtistaView(artistaService).execute();
            // TODO: Opção de listar filmes do artista, para isso o listar artistas deixaria de mostrar os filmes
            case 0 -> {return;}
            default -> System.out.println("Opcao não disponível");
        }
        execute();
    }
}
