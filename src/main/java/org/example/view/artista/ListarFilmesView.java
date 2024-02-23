package org.example.view.artista;

import org.example.entites.Artista;
import org.example.entites.Filme;
import org.example.services.ArtistaService;
import org.example.services.FilmeService;

import java.util.List;
import java.util.Scanner;

public class ListarFilmesView {

    private ArtistaService artistaService;
    private FilmeService filmeService;

    public ListarFilmesView(ArtistaService artistaService, FilmeService filmeService) {
        this.artistaService = artistaService;
        this.filmeService = filmeService;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual o nome do artista?");
        String nome = scanner.nextLine();

        List<Artista> artistas = artistaService.pesquisarPorNome(nome);
        Artista achouArtista = null;

        if (artistas != null) {
            for (Artista artista : artistas) {
                System.out.print(artista.getNome() + "|" + artista.getDataNascimento());
                System.out.println("Esse é o artista desejado?(S/N)");
                char resposta = scanner.nextLine().charAt(0);
                resposta = Character.toUpperCase(resposta);
                if (resposta == 'S') {
                    achouArtista = artista;
                    break;
                }
            }
        }

        if (achouArtista == null) {
            System.out.println("Artista não encontrado");
        } else if (achouArtista.getFilmes().isEmpty() || achouArtista.getFilmes() == null) {
            System.out.println("Artista não participou de nenhum filme");
        } else {
            System.out.printf("%-8s | %-30s | %-5s | %-4s\n",
                    "ID", "Nome", "Idade", "Sexo");
            System.out.printf("%-8d | %-30s | %-5d | %-4c\n",
                    achouArtista.getId(), achouArtista.getNome(),
                    achouArtista.calcularIdade(), achouArtista.getSexo());

            System.out.printf("%-25s | %-15s | %-10s | %-7s | %-100s\n",
                    "Nome Filme", "Genero", "Lancamento", "Duração", "Descrição");

            for (Filme filmes : achouArtista.getFilmes()) {
                System.out.printf("%-25s | %-15s | %-10s | %-7d | %-100s\n",
                        filmes.getNome(), filmes.getGenero(), filmes.getDataLancamento(),
                        filmes.getDuracao(), filmes.getDescricao());
            }
            System.out.println();
        }
    }
}


