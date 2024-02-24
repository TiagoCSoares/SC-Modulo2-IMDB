package org.example.view.filme;


import org.example.entites.Filme;
import org.example.services.ArtistaService;
import org.example.services.DiretorService;
import org.example.services.FilmeService;
import org.example.view.verificacoes.VerificarFilme;

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
        Filme achouFilme = new VerificarFilme().verificarFilme(listaFilmes);

        if(achouFilme == null) {
            System.out.println("Filme não encontrado");
        } else {
            filmeService.excluir(achouFilme);
            artistaService.excluirFilme(achouFilme);
            diretorService.excluirFilme(achouFilme);
        }
    }
}
