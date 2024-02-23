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

        for(Diretor diretor : listaDiretores) {
            System.out.print(diretor.getNome() + "|" + diretor.getDataNascimento());
            System.out.println("Esse é o diretor desejado?(S/N)");
            char resposta = scanner.nextLine().charAt(0);
            resposta = Character.toUpperCase(resposta);
            if (resposta == 'S') {
                achouDiretor = diretor;
                diretorService.excluir(achouDiretor);
                break;
            }
        }
        if(achouDiretor == null) {
            System.out.println("Diretor não encontrado");
        } else {
            System.out.println("Diretor excluído com sucesso");
            // Excluir o diretor de todos os filmes que ele participou
            filmeService.excluirDiretor(achouDiretor);
        }
    }
}
