package org.example.entites;

public abstract class Pessoa {

        private Long id;
        private String nome;
        private String dataNascimento;
        private char sexo;

        public Pessoa(String nome, String dataNascimento, char sexo) {
            this.nome = nome;
            this.dataNascimento = dataNascimento;
            this.sexo = sexo;
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
}
