package org.example.entites;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {

        private Long id;
        private String nome;
        private String dataNascimento;
        private char sexo;

        private List<Filme> filmes;

        public Pessoa(String nome, String dataNascimento, char sexo, List<Filme> filmes) {
            this.nome = nome;
            this.dataNascimento = dataNascimento;
            this.sexo = sexo;
            this.filmes = filmes != null ? filmes : new ArrayList<>();
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getDataNascimento() {
                return dataNascimento;
        }

        public void setDataNascimento(String dataNascimento) {
                this.dataNascimento = dataNascimento;
        }

        public char getSexo() {
                return sexo;
        }

        public void setSexo(char sexo) {
                this.sexo = sexo;
        }

        public List<Filme> getFilmes() {
                return filmes;
        }

        public void setFilmes(List<Filme> filmes) {
                this.filmes = filmes;
        }



        public int calcularIdade() {

                // A data de nascimento está no formato dd/mm/yyyy é preciso trocar '/' por '-' para utilizar o LocalDate
                String dataNascimentoFormatada = dataNascimento.replace("/", "-");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                // Converter a string da data de nascimento para um objeto LocalDate
                LocalDate dataNascimentoLocalDate = LocalDate.parse(dataNascimentoFormatada, formatter);

                // Calcular a diferença entre a data atual e a data de nascimento para obter a idade
                LocalDate dataAtual = LocalDate.now();
                Period periodo = Period.between(dataNascimentoLocalDate, dataAtual);

                // Retornar a idade em anos
                return periodo.getYears();
        }

        public void associarFilme(Filme filme) {
                filmes.add(filme);
        }

        public void desassociarFilme(Filme filme) {
                filmes.remove(filme);
        }
}
