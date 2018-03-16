package br.com.neoway.library;

import br.com.neoway.library.dao.LivroDAO;
import br.com.neoway.library.dao.UsuarioDAO;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
@ManagedBean
public class UsuarioBean implements Serializable{

    private Usuario usuario;
    private List<Usuario> listaBuscaUser;

    @PostConstruct
    public void init(){
        String idUser = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idUser");

        if(idUser != null){
            usuario = UsuarioDAO.findById(Integer.parseInt(idUser));
        }else{
            usuario = new Usuario();

        }



        listaBuscaUser = new ArrayList<>();

        Usuario usuario1 = new Usuario();
        usuario1.setIdUser(1);
        usuario1.setPerfil("Administrador");
        usuario1.setNome("Teste Usuario");
        usuario1.setData_nascimento("21/12/1994");
        usuario1.setEmail("teste@.com.br");
        UsuarioDAO.add(usuario1);



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

    public List<Usuario> getListaBuscaUser () {
        return listaBuscaUser;
    }

    public Usuario getUsuarioLogado() {
        return UsuarioDAO.usuarioLogado;
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
        usuario = new Usuario();
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
                UsuarioDAO.setUsuarioLogado(usuario);
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

    public  void listarUsuariosPorPerfil (String perfil){
        if(perfil.equals("Administrador")){
            listarUsuariosAdmin();
        }
        if(perfil.equals("Comum")) {
            listarUsuariosComuns();
        }
    }

    private void listarUsuariosAdmin (){
        for (Usuario usuarioBusca: UsuarioDAO.list()){
            if(usuarioBusca.getPerfil().equals("Administrador")){
                listaBuscaUser.add(usuarioBusca);
            }
        }
    }

    private void listarUsuariosComuns (){
        for (Usuario usuarioBusca: UsuarioDAO.list()){
            if(usuarioBusca.getPerfil().equals("Comum")){
                listaBuscaUser.add(usuarioBusca);
            }
        }
    }

    public void listarUsuariosPorNome (){
        for (Usuario usuarioBusca: UsuarioDAO.list()){
            if(usuarioBusca.getNome().equals(this.usuario.getNome())){
                listaBuscaUser.add(usuarioBusca);
                this.usuario = new Usuario();
            }
        }
    }



    public String retornoLogin(){
        return "login.xhtml";
    }

    }
