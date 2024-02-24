package org.example.view.diretor;


import org.example.entites.Diretor;
import org.example.entites.Filme;
import org.example.services.DiretorService;
import org.example.services.FilmeService;
import org.example.view.verificacoes.VerificarDiretor;
import org.example.view.verificacoes.VerificarFilme;

import java.util.ArrayList;
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

        List<Diretor> diretores = diretorService.pesquisarPorNome(nome);
        Diretor diretorEncontrado = new VerificarDiretor().verificarDiretor(diretores);
        if(diretores == null) {
            System.out.println("Diretor não encontrado, cadastre o diretor antes de associar ao filme");
            return;
        }

        System.out.println("Informe o nome do filme:");
        String nomeFilme = scanner.nextLine();

        List<Filme> filmes = filmeService.pesquisarPorNome(nomeFilme);
        Filme filmeEncontrado =  new VerificarFilme().verificarFilme(filmes);
        if(filmes == null) {
            System.out.println("Filme não encontrado, cadastre o filme antes de associar ao diretor");
            return;
        }


        filmeEncontrado.setDiretores(new ArrayList<>());
        diretorService.associarFilme(diretorEncontrado, filmeEncontrado);
        filmeService.associarDiretor(diretorEncontrado, filmeEncontrado);
    }
}
