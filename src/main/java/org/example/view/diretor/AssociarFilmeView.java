package org.example.view.diretor;

import org.example.entites.Artista;
import org.example.entites.Diretor;
import org.example.entites.Filme;
import org.example.services.ArtistaService;
import org.example.services.DiretorService;
import org.example.services.FilmeService;

import java.util.List;
import java.util.Scanner;

public class AssociarFilmeView {

    private DiretorService diretorService;
    private FilmeService filmeService;

    public AssociarFilmeView(DiretorService diretorService, FilmeService filmeService) {
        this.diretorService = diretorService;
        this.filmeService = filmeService;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do diretor:");
        String nome = scanner.nextLine();

        List diretores = diretorService.pesquisarPorNome(nome);
        if(diretores == null) {
            System.out.println("Diretor não encontrado, cadastre o diretor antes de associar ao filme");
            return;
        }

        System.out.println("Informe o nome do filme:");
        String nomeFilme = scanner.nextLine();

        List filmes = filmeService.pesquisarPorNome(nomeFilme);
        if(filmes == null) {
            System.out.println("Filme não encontrado, cadastre o filme antes de associar ao diretor");
            return;
        }

        Diretor diretor = (Diretor) diretores.get(0);
        Filme filme = (Filme) filmes.get(0);
        // O artista não precisa  receber a lista dos outros artistas, evitar loop infinito
        filme.setArtistas(null);
        filme.setDiretores(null);
        diretorService.associarFilme(diretor, filme);
        filmeService.associarDiretor(diretor, filme);
    }
}
