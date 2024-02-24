package org.example.view;

import org.example.services.ArtistaService;
import org.example.services.DiretorService;
import org.example.services.FilmeService;
import org.example.view.artista.ArtistaMenu;
import org.example.view.diretor.DiretorMenu;
import org.example.view.filme.FilmeMenu;

import java.util.Scanner;

public class Menu extends AbstractMenuView{

    private ArtistaService artistaService;
    private DiretorService diretorService;
    private FilmeService filmeService;

    public Menu(ArtistaService artistaService, DiretorService diretorService ,FilmeService filmeService) {
        super(new String[]{
                "1 - Filmes",
                "2 - Artistas",
                "3 - Diretores",
                "0 - Sair\n"
        });
        this.artistaService = artistaService;
        this.diretorService = diretorService;
        this.filmeService = filmeService;
    }

    @Override
    protected Boolean validOption(Integer option) {
        return option >= 0 && option <= 3;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 1 -> new FilmeMenu(filmeService, artistaService, diretorService).execute();
            case 2 -> new ArtistaMenu(artistaService, filmeService).execute();
            case 3 -> new DiretorMenu(diretorService, filmeService).execute();
            case 0 -> {
                //Set<Object> artistas = new HashSet<>(artistaService.listar());
                artistaService.escreverArquivo();
                filmeService.escreverArquivo();
                diretorService.escreverArquivo();
                System.exit(1);

                // Instanciando um scanner para garantir que o System.in será encerrado
                Scanner scanner = new Scanner(System.in);
                scanner.close();
                }

            default -> System.out.println("Opcao não disponível");
        }
        execute();
    }
}
