package br.com.neoway.library;

import java.util.Date;
public class Usuario {


    private int idUser;
    private String nome;
    private double telefone;
    private String perfil;
    private String data_nascimento;
    private String email;
    private String password;

    public Usuario() {  }

    public String getPerfil() {
        return perfil;
    }

    public int getIdUser() {
        return idUser;
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public String getData_nascimento() {
        return data_nascimento;
    }
    public String getPassword() {
        return password;
    }

    public double getTelefone() {
        return telefone;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTelefone(double telefone) {
        this.telefone = telefone;
    }
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
    public void setPassword(String edicao) {
        this.password = edicao;
    }
}
