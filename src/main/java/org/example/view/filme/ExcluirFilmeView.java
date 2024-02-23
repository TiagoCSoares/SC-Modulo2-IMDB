package org.example.view.filme;

import org.example.entites.Artista;
import org.example.entites.Filme;
import org.example.services.ArtistaService;
import org.example.services.DiretorService;
import org.example.services.FilmeService;

import java.util.List;
import java.util.Scanner;

public class ExcluirFilmeView {

    private ArtistaService artistaService;
    private DiretorService diretorService;
    private FilmeService filmeService;

    public ExcluirFilmeView(ArtistaService artistaService, DiretorService diretorService ,FilmeService filmeService) {
        this.artistaService = artistaService;
        this.diretorService = diretorService;
        this.filmeService = filmeService;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do filme que deseja excluir:");
        String nome = scanner.nextLine();

        List<Filme> listaFilmes = filmeService.pesquisarPorNome(nome);
        Filme achouFilme = null;

        if(listaFilmes != null) {
            for (Filme filme : listaFilmes) {
                System.out.print(filme.getNome() + "|" + filme.getGenero());
                System.out.println("Esse é o filme desejado?(S/N)");
                char resposta = scanner.nextLine().charAt(0);
                resposta = Character.toUpperCase(resposta);
                if (resposta == 'S') {
                    achouFilme = filme;
                    filmeService.excluir(achouFilme);
                    artistaService.excluirFilme(achouFilme);
                    diretorService.excluirFilme(achouFilme);
                    break;
                }
            }
        }
        if(achouFilme == null) {
            System.out.println("Filme não encontrado");
        }
    }
}
