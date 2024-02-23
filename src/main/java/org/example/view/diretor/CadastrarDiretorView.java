package org.example.view.diretor;

import org.example.entites.Diretor;
import org.example.services.DiretorService;
import org.example.services.FilmeService;
import org.example.view.verificacoes.VerificarDataNascimento;

import java.util.List;
import java.util.Scanner;

public class CadastrarDiretorView {

    private DiretorService diretorService;
    private FilmeService filmeService;

    public CadastrarDiretorView(DiretorService diretorService) {
        this.diretorService = diretorService;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome do diretor:");
        String nome = scanner.nextLine();

        List diretoresCadastrados = diretorService.pesquisarPorNome(nome);
        if(diretoresCadastrados != null) {
            System.out.println("Diretor já cadastrado");
            return;
        }

        System.out.println("Digite a data de nascimento do diretor (DD/MM/YYYY):");
        String dataNascimento = scanner.nextLine();
        dataNascimento =  new VerificarDataNascimento().verificarDataNascimento(dataNascimento);

        System.out.println("Digite o sexo do diretor(M/F):");
        char sexo = scanner.nextLine().charAt(0);
        sexo = Character.toUpperCase(sexo);
        while(sexo != 'M' && sexo != 'F') {
            System.out.println("Sexo inválido, digite novamente(M/F):");
            sexo = scanner.nextLine().charAt(0);
            sexo = Character.toUpperCase(sexo);
        }

        Diretor diretor = new Diretor(nome, dataNascimento, sexo, null);
        diretorService.criar(diretor);
    }
}
