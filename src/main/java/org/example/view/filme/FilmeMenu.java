package org.example.view.filme;

import org.example.entites.Artista;
import org.example.services.ArtistaService;
import org.example.services.DiretorService;
import org.example.services.FilmeService;
import org.example.view.AbstractMenuView;
import org.example.view.artista.AssociarFilmeView;


public class FilmeMenu extends AbstractMenuView {

    private FilmeService filmeService;
    private ArtistaService artistaService;
    private DiretorService diretorService;



    public FilmeMenu(FilmeService filmeService, ArtistaService artistaService, DiretorService diretorService) {
        super(new String[]{
                "1 - Cadastrar Filme",
                "2 - Excluir Filme",
                "3 - Listar Filmes",
                "4 - Associar Artista ao Filme",
                "5 - Associar Diretor ao Filme",
                "6 - Listar Artistas do Filme",
                "7 - Listar Diretores do Filme",
                "8 - Buscar Filme",
                "0 - Voltar\n"
        });
        this.filmeService = filmeService;
        this.artistaService = artistaService;
        this.diretorService = diretorService;
    }

    @Override
    protected Boolean validOption(Integer option) {
        return option >= 0 && option <= 8;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 1 -> new CadastrarFilmeView(filmeService).execute();
            case 2 -> new ExcluirFilmeView(artistaService, diretorService, filmeService).execute();
            case 3 -> new ListarFilmeView(filmeService).execute();
            case 4 -> new org.example.view.artista.AssociarFilmeView(artistaService, filmeService).execute();
            case 5 -> new org.example.view.diretor.AssociarFilmeView(diretorService, filmeService).execute();
            case 6 -> new ListarArtistasView(filmeService).execute();
            case 7 -> new ListarDiretoresView(filmeService).execute();
            case 8 -> new BuscarFilmeView(filmeService).execute();
            case 0 -> {
                return;
            }
            default -> System.out.println("Opcao não disponível");
        }
        execute();
    }
}
