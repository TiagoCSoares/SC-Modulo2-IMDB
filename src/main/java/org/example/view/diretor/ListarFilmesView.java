package org.example.view.diretor;


import org.example.entites.Diretor;
import org.example.entites.Filme;
import org.example.services.DiretorService;
import org.example.services.FilmeService;

import java.util.List;
import java.util.Scanner;

public class ListarFilmesView {

    private DiretorService diretorService;

    public ListarFilmesView(DiretorService diretorService) {
        this.diretorService = diretorService;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual o nome do diretor?");
        String nome = scanner.nextLine();

        List<Diretor> diretores = diretorService.pesquisarPorNome(nome);
        Diretor achouDiretor = null;

        if (diretores != null) {
            for (Diretor diretor : diretores) {
                System.out.print(diretor.getNome() + "|" + diretor.getDataNascimento());
                System.out.println("Esse é o diretor desejado?(S/N)");
                char resposta = scanner.nextLine().charAt(0);
                resposta = Character.toUpperCase(resposta);
                if (resposta == 'S') {
                    achouDiretor = diretor;
                    break;
                }
            }
        }

        if (achouDiretor == null) {
            System.out.println("Diretor não encontrado");
        } else if (achouDiretor.getFilmes().isEmpty() || achouDiretor.getFilmes().isEmpty()) {
            System.out.println("Diretor não participou de nenhum filme");
        } else {
            System.out.printf("%-8s | %-30s | %-5s | %-4s \n",
                    "ID", "Nome", "Idade", "Sexo");
            System.out.printf("%-8d | %-30s | %-5d | %-4c\n",
                    achouDiretor.getId(), achouDiretor.getNome(),
                    achouDiretor.calcularIdade(), achouDiretor.getSexo());

            System.out.printf("%-25s | %-15s | %-10s | %-7s | %-100s\n",
                    "Nome Filme", "Genero", "Lancamento", "Duração, Descrição");

            for (Filme filmes : achouDiretor.getFilmes()) {
                System.out.printf("%-25s | %-15s | %-10s | %-7d | %-100s \n",
                        filmes.getNome(), filmes.getGenero(), filmes.getDataLancamento(),
                        filmes.getDuracao(), filmes.getDescricao());
            }
            System.out.println();
        }
    }
}

