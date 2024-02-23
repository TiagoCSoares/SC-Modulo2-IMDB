package org.example.resources.lerArquivos;

import java.io.*;

public abstract class LerArquivoAbstract {

    protected abstract String getNomeArquivo();
    protected abstract void preencherBanco(Object service);

    public void lerArquivo(Object service) {
        File arquivo = new File(getNomeArquivo());

        try {
            // Se o arquivo não existir cria o arquivo
            if(!arquivo.exists()) {
                arquivo.createNewFile();
            } else if(arquivo.length() > 0) { // Se o arquivo tiver conteúdo preenche o banco de dados
                preencherBanco(service);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
