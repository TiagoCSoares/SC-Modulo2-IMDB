package org.example.view.artista;

import org.example.services.ArtistaService;
import org.example.view.AbstractMenuView;

public class AtualizarArtistaMenuView extends AbstractMenuView {

    private ArtistaService artistaService;

    public AtualizarArtistaMenuView(ArtistaService artistaService) {
        super(new String[]{
            "1 - Atualizar Nome",
            "2 - Atualizar Data de Nascimento",
            "3 - Atualizar Sexo",
            "4 - Adicionar Filmes",
            "5 - Remover Filmes",
            "0 - Voltar"
        });
        this.artistaService = artistaService;
    }

    @Override
    protected Boolean validOption(Integer option) {
        return option >= 0 && option <= 5;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            /*case 1 -> new AtualizarNomeView(artistaService).execute();
            case 2 -> new AtualizarDataNascimentoView(artistaService).execute();
            case 3 -> new AtualizarSexoView(artistaService).execute();
            case 4 -> new AdicionarFilmesView(artistaService).execute();
            case 5 -> new RemoverFilmesView(artistaService).execute();
            case 0 -> {return;}*/
            default -> System.out.println("Opcao não disponível");
        }
        execute();
    }
}
