package br.com.neoway.library;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@ManagedBean
public class LoginBean implements Serializable{

    private Usuario usuario;

    private int filtroId;

    private String filtroPassword;

    private static List<Usuario> usuarios;

    @PostConstruct
    public void init(){

        usuario = new Usuario();
    }

    public int getFiltroId() {

        return filtroId;
    }

    public void setFiltroId(int filtroId) {

        this.filtroId = filtroId;
    }

    public String getFiltroPassword() {
        return filtroPassword;
    }

    public void setFiltroPassword(String filtroPassword) {
        this.filtroPassword = filtroPassword;
    }

    public void setUsuario(Usuario usuario) {

        this.usuario = usuario;
    }

    public Usuario getUsuario() {

        return usuario;
    }

    public void loginUsuario(){
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUser() == this.getFiltroId() && usuario.getPassword().equals(this.getFiltroPassword()) ){
                this.setUsuario(usuario);
                System.out.println(this.usuario.getNome() + "Bem vindo" + this.usuario.getPerfil() );
            } else { throw new RuntimeException("Usuario incorreto");

            }
        }
    }

}