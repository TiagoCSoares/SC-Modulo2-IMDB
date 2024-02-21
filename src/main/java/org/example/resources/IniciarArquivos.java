package org.example.resources;

import java.io.File;
import java.io.IOException;

public class IniciarArquivos {

    public static void iniciarArquivos() {
        File pastaArquivos = new File("src/main/java/org/example/arquivos");

        // Verifica se a pasta 'arquivos' existe, se não, cria a pasta
        if (!pastaArquivos.exists()) {
            pastaArquivos.mkdirs(); // Cria a pasta 'arquivos' e qualquer diretório pai necessário
        }

        File arquivoArtistas = new File("src/main/java/org/example/arquivos/artistas.txt");
        File arquivoDiretores = new File("src/main/java/org/example/arquivos/diretores.txt");
        File arquivoFilmes = new File("src/main/java/org/example/arquivos/filmes.txt");

        try {
            if (!arquivoArtistas.exists()) {
                if (arquivoArtistas.createNewFile()) {
                    //escreverCabecalho(arquivoArtistas);
                }
            } else if (arquivoArtistas.length() == 0) {
                //escreverCabecalho(arquivoArtistas);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (!arquivoDiretores.exists()) {
                if (arquivoDiretores.createNewFile()) {
                    //escreverCabecalho(arquivoDiretores);
                }
            } else if (arquivoDiretores.length() == 0) {
                //escreverCabecalho(arquivoDiretores);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (!arquivoFilmes.exists()) {
                if (arquivoFilmes.createNewFile()) {
                    //escreverCabecalho(arquivoFilmes);
                }
            } else if (arquivoFilmes.length() == 0) {
                //escreverCabecalho(arquivoFilmes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public static void escreverCabecalho(File arquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            // Escreve o cabeçalho no arquivo
            writer.write(String.format("%-8s | %-45s | %-10s", "Id", "Nome", "Telefone(s): Id   (DDD)   Numero"));
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao escrever o cabeçalho: " + e.getMessage());
        }
    }*/
}
