package com.example.teste;

import android.content.ContentValues;

public class Usuario {

    private String nome;
    private String endereco;
    private String email;
    private String senha;
    private long id;


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco(){return endereco;}
    public void setEndereco(String string){this.endereco = endereco;}

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }


}

