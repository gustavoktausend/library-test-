package br.com.neoway.library;

import br.com.neoway.library.dao.UsuarioDAO;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
@ManagedBean
public class UsuarioBean implements Serializable{

    private Usuario usuario;

    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }




    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Usuario> getUsuarios() {
        return UsuarioDAO.list();
    }


    public void cadastrarUsuario(){
        if (usuario.getPerfil().isEmpty()){
            throw new RuntimeException("É necessário escolher um tipo de Perfil");
        }
        if (usuario.getEmail().isEmpty()){
            throw new RuntimeException("É necessário Email");
        }
        if (usuario.getPassword().isEmpty()){
            throw new RuntimeException("É necessário Preencher Campo Senha!"); }
        System.out.println("Usuário" + this.usuario.getPerfil() + "id:" +this.usuario.getIdUser()  );
        UsuarioDAO.add(usuario);
        this.usuario = new Usuario();
        }

    public void buscarUsuario(){
        for (Usuario usuario : UsuarioDAO.list()) {
            if (usuario.getIdUser() == this.usuario.getIdUser()){
                this.setUsuario(usuario);
                System.out.println(this.usuario.getIdUser());
            }
        }
    }

    public void removerUsuario(Usuario usuario){
        this.setUsuario(usuario);
        UsuarioDAO.remove(this.usuario);
        this.usuario = new Usuario();
    }

    public void alterarUsuario(Usuario usuario) {
        this.setUsuario(usuario);
    }

    public void confirmarAlteracaoUsuario(){
        UsuarioDAO.update(usuario);
    }

    public String loginUsuario() {
        for (Usuario usuario : UsuarioDAO.list()) {
            if (usuario.getEmail().equals(this.usuario.getEmail()) && usuario.getPassword().equals(this.usuario.getPassword())){
                System.out.println("Login realizado com sucesso");
                if (usuario.getPerfil().equals("Administrador")){
                    return "crud_livro.xhtml";
                }
                if (usuario.getPerfil().equals("Comum")){
                    return "";
                }

            }else{
                System.out.println("Login inválido");
            }
        }
        return "";
    }

    public String novoUsuarioCadastrar() {
        return "novo_usuario.xhtml";

    }

    public String retornoLogin(){
        return "login.xhtml";
    }


    }
