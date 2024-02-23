package org.example.view.verificacoes;

import java.util.Scanner;

public class VerificarDataNascimento {

    public String verificarDataNascimento(String dataNascimento) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String[] elementos = dataNascimento.split("/");
            if (elementos.length == 3) { // Verifica se a entrada contém três partes (dia, mês, ano)
                try {
                    int dia = Integer.parseInt(elementos[0]);
                    int mes = Integer.parseInt(elementos[1]);
                    int ano = Integer.parseInt(elementos[2]);

                    // Validar se a data é válida
                    if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && ano >= 1900) {
                        break; // Sai do loop se a data for válida
                    } else {
                        System.out.println("Data de nascimento inválida. Por favor, digite novamente:");
                        dataNascimento = scanner.nextLine();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Formato inválido. Certifique-se de digitar a data no formato DD/MM/YYYY:");
                    dataNascimento = scanner.nextLine();
                }
            } else {
                System.out.println("Formato inválido. Certifique-se de digitar a data no formato DD/MM/YYYY:");
                dataNascimento = scanner.nextLine();
            }
        }
        return dataNascimento;
    }
}
