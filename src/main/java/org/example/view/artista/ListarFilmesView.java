package org.example.view.artista;

import org.example.entites.Artista;
import org.example.entites.Filme;
import org.example.services.ArtistaService;
import org.example.view.verificacoes.VerificarArtista;

import java.util.List;
import java.util.Scanner;

public class ListarFilmesView {

    private ArtistaService artistaService;

    public ListarFilmesView(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual o nome do artista?");
        String nome = scanner.nextLine();

        List<Artista> artistas = artistaService.pesquisarPorNome(nome);
        Artista achouArtista = new VerificarArtista().verificarArtista(artistas);

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

            System.out.printf("%-8s | %-25s | %-15s | %-10s | %-7s | %-100s\n",
                   "ID Filme", "Nome Filme", "Genero", "Lancamento", "Duração", "Descrição");

            for (Filme filmes : achouArtista.getFilmes()) {
                System.out.printf("%-8d | %-25s | %-15s | %-10s | %-7d | %-100s\n",
                        filmes.getId(), filmes.getNome(), filmes.getGenero(),
                        filmes.getDataLancamento(), filmes.getDuracao(), filmes.getDescricao());
            }
            System.out.println();
        }
    }
}


