package org.example.view.diretor;

import org.example.entites.Diretor;
import org.example.services.DiretorService;
import org.example.services.FilmeService;
import org.example.view.verificacoes.VerificarDiretor;

import java.util.List;
import java.util.Scanner;

public class ExcluirDiretorView {

    private DiretorService diretorService;
    private FilmeService filmeService;

    public ExcluirDiretorView(DiretorService diretorService, FilmeService filmeService) {
        this.diretorService = diretorService;
        this.filmeService = filmeService;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do diretor que deseja excluir:");
        String nome = scanner.nextLine();

        List<Diretor> listaDiretores = diretorService.pesquisarPorNome(nome);
        Diretor achouDiretor = new VerificarDiretor().verificarDiretor(listaDiretores);

        if(achouDiretor == null) {
            System.out.println("Diretor não encontrado");
        } else {
            diretorService.excluir(achouDiretor);
            filmeService.excluirDiretor(achouDiretor);
        }
    }
}
