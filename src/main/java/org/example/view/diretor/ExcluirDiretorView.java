package org.example.view.diretor;

import org.example.entites.Diretor;
import org.example.services.DiretorService;
import org.example.services.FilmeService;

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
        Diretor achouDiretor = null;

        if(listaDiretores != null) {
            for (Diretor diretor : listaDiretores) {
                System.out.println(diretor.getNome() + "|" + diretor.getDataNascimento());
                System.out.println("Esse é o diretor desejado?(S/N)");
                char resposta = scanner.nextLine().charAt(0);
                resposta = Character.toUpperCase(resposta);
                if (resposta == 'S') {
                    achouDiretor = diretor;
                    diretorService.excluir(achouDiretor);
                    filmeService.excluirDiretor(achouDiretor);
                    break;
                }
            }
        }else {
                System.out.println("Não há diretores cadastrados!");
            }
        if(achouDiretor == null) {
            System.out.println("Diretor não encontrado");
        }
    }
}
