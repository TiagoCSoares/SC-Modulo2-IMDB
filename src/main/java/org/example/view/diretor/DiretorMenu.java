package org.example.view.diretor;

import org.example.entites.Diretor;
import org.example.services.ArtistaService;
import org.example.services.DiretorService;
import org.example.services.FilmeService;
import org.example.view.AbstractMenuView;
import org.example.view.artista.*;

public class DiretorMenu extends AbstractMenuView {

    private DiretorService diretorService;
    private FilmeService filmeService;

    public DiretorMenu(DiretorService diretorService, FilmeService filmeService) {
        super(new String[]{
            "1 - Cadastrar Diretor",
            "2 - Excluir Diretor",
            "3 - Listar Diretores",
            "4 - Associar Filme ao Diretor",
            "5 - Listar Filmes do Diretor",
            "0 - Voltar\n"
        });
        this.diretorService = diretorService;
        this.filmeService = filmeService;
    }

    @Override
    protected Boolean validOption(Integer option) {
        return option >= 0 && option <= 5;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 1 -> new CadastrarDiretorView(diretorService).execute();
            case 2 -> new ExcluirDiretorView(diretorService, filmeService).execute();
            case 3 -> new ListarDiretorView(diretorService).execute();
            case 4 -> new AssociarFilmeView(diretorService, filmeService).execute();
            case 5 -> new ListarFilmesView(diretorService, filmeService).execute();

            case 0 -> {return;}
            default -> System.out.println("Opcao não disponível");
        }
        execute();
    }
}
