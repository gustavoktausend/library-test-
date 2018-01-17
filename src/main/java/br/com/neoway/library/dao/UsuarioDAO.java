package br.com.neoway.library.dao;

import br.com.neoway.library.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public static int IdCountUser;

    public static Usuario usuarioLogado;

    private static List<Usuario> usuarios;

    static {
        usuarios = new ArrayList<>();
        usuarioLogado = new Usuario();
    }

    public static void add(Usuario usuario){
        if (existeUsuario(usuario.getEmail())){
            System.out.println("Usuário já existente");

        }else{
            usuario.setIdUser(IdCountUser++);
            usuarios.add(usuario);
        }

    }

    public static void remove(Usuario usuario){

        usuarios.remove(usuario);
    }

    public static List<Usuario> list(){

        return usuarios;
    }

    public static Usuario findById (int idUser){

        for (Usuario usuarioBusca: usuarios){

            if (idUser == usuarioBusca.getIdUser()){

                return usuarioBusca;
            }
        }
        return null;
    }

    public static boolean existeUsuario (String email){

        for(Usuario usuarioExiste: usuarios){

            if (email.equals(usuarioExiste.getEmail())){

                return true;
            }

            if (!email.equals(usuarioExiste.getEmail())){
                return false;
            }
        }
        return false;
    }

    public static void update(Usuario usuario){

                Usuario usuarioEditado = findById(usuario.getIdUser());
                if (usuarioEditado !=null) {
                    usuarioEditado.setNome(usuario.getNome());
                    usuarioEditado.setPassword(usuario.getPassword());
                    usuarioEditado.setEmail(usuario.getEmail());
                    usuarioEditado.setTelefone(usuario.getTelefone());
                    usuarioEditado.setPerfil(usuario.getPerfil());
                    usuarioEditado.setData_nascimento(usuario.getData_nascimento());
                }
                //referencia // obj // ponteiro e etc

    }

    public static void setUsuarioLogado(Usuario usuario){
        usuarioLogado = usuario;
    }

}
