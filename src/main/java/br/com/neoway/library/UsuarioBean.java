package br.com.neoway.library;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@ManagedBean
public class UsuarioBean implements Serializable{

    private Usuario usuario;



    private int filtroId;

    private  List<Usuario> usuarios;




    @PostConstruct
    public void init(){
        usuarios = new ArrayList<Usuario>();
        usuario = new Usuario();
    }



    public int getFiltroId() {
        return filtroId;
    }

    public void setFiltroId(int filtroId) {
        this.filtroId = filtroId;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void cadastrarUsuario(){
//        if (usuario.getPerfil().isEmpty()){
//            throw new RuntimeException("É necessário escolher um tipo de Perfil");
//        }
//        if (usuario.getEmail().isEmpty()){
//            throw new RuntimeException("É necessário Email");
//        }
//        if (usuario.getPassword().isEmpty()){
//            throw new RuntimeException("É necessário Preencher Campo Senha!"); }
        System.out.println("Usuário" + this.usuario.getPerfil() + "id:" +this.usuario.getIdUser()  );
        usuarios.add(this.usuario);
        System.out.println(this.usuario.getIdUser());
        this.usuario = new Usuario();
        }

    public void buscarUsuario(){
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUser() == this.usuario.getIdUser()){
                this.setUsuario(usuario);
                System.out.println(this.usuario.getIdUser());

            }
        }
        this.usuario = new Usuario();
    }

    public void deletarUsuario(){
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUser() == this.usuario.getIdUser()){
                System.out.println(this.usuario.getIdUser()+" vai ser Obliterado");
                usuarios.remove(this.usuario);
                System.out.println("Usuário Obliterado");
            }

        }
        this.usuario = new Usuario();
    }

    public void editarUsuario(){
        for (Usuario usuario : usuarios ) {
            if (usuario.getIdUser() == this.usuario.getIdUser()){
                usuarios.equals(this.usuario);
                System.out.println("Usuário editado, novo valor de telefone:" + this.usuario.getTelefone()+ "Id:" + this.usuario.getIdUser());


            }
        }
    }
    }
