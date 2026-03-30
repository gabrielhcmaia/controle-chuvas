package com.aep;

public class Usuario {
    private String nome;
    private String rg;
    private String endereco;

    public Usuario(String nome, String rg, String endereco) {
        this.nome = nome;
        this.rg = rg;
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getRg() {
        return rg;
    }

    public String getEndereco() {
        return endereco;
    }
}
