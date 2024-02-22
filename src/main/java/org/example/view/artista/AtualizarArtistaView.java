package org.example.view.artista;

import org.example.entites.Artista;
import org.example.services.ArtistaService;
import org.example.view.verificacoes.VerificacoesArtistaDiretor;

import java.util.List;
import java.util.Scanner;

public class AtualizarArtistaView {

    private ArtistaService artistaService;

    public AtualizarArtistaView(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome do artista:");
        String nome = scanner.nextLine();

        List<Artista> artistas = artistaService.pesquisarPorNome(nome);
        if(artistas != null) {
            for (Artista artista : artistas) {
                System.out.printf("%-30s - %-10s", artista.getNome(),artista.getDataNascimento());
                System.out.println("Esse é o artista que você deseja atualizar? (S/N)");
                Character opcao = scanner.nextLine().charAt(0);
                opcao = Character.toLowerCase(opcao);

                if(opcao == 'S') {
                    System.out.println("Digite o novo nome do artista:");
                    nome = scanner.nextLine();
                    VerificacoesArtistaDiretor verificacoes = new VerificacoesArtistaDiretor(artistaService);

                    System.out.println("Digite a nova data de nascimento do artista (DD/MM/YYYY):");
                    String dataNascimento = scanner.nextLine();
                    dataNascimento = verificacoes.verificarDataNascimento(dataNascimento);

                    System.out.println("Digite o novo sexo do artista(M/F):");
                    char sexo = scanner.nextLine().charAt(0);
                    sexo = Character.toUpperCase(sexo);
                    while(sexo != 'M' && sexo != 'F') {
                        System.out.println("Sexo inválido, digite novamente(M/F):");
                        sexo = scanner.nextLine().charAt(0);
                        sexo = Character.toUpperCase(sexo);
                    }

                    artista.setDataNascimento(dataNascimento);
                    artista.setSexo(sexo);
                    artistaService.atualizar(artista);
                    return;

                    // TODO: Atualizar a lista de filmes do artista
                    // TODO: Atualizar o artista em todos os filmes que ele participou
                }
            }
        } else {
            System.out.println("Artista não encontrado");
    }
    }
}
