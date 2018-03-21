package br.com.neoway.library.dao;

import br.com.neoway.library.Livro;
import br.com.neoway.library.Usuario;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LivroDAO {

    private static int IdCount = 1;

    private Date dataAtual = Calendar.getInstance().getTime();

    private static List<Livro> livros;

    private static List<Livro> livrosAlugados;

    private static List<Livro> livrosAlugadosPorUsuario;

    private static List<Livro> listaHistorico;

    static {
        livros = new ArrayList<>();
        livrosAlugados = new ArrayList<>();
        listaHistorico = new ArrayList<>();
        livrosAlugadosPorUsuario = new ArrayList<>();
    }

    public static void add(Livro livro){
        livro.setIdLivro(IdCount++);
        if (existeLivro(livro.getIdLivro())){
                System.out.println("livro já existe");

        }else{
                livros.add(livro);

        }
    }

    public static void addLivrosAlugar(Livro livro){

        livrosAlugados.add(livro);
    }

    public static void remove(Livro livro){

        livros.remove(livro);
    }

    public static void removerLivroAlugar(Livro livro){

        livrosAlugados.remove(livro);
    }

    public static List<Livro> list(){

        return livros;
    }

    public static List<Livro> listarAlugados(){

        return livrosAlugados;
    }

    public static List<Livro> listarLivrosAlugadosPorUsuario(String nomeUsuario){
//        nomeUsuario = UsuarioDAO.retornaNomeUsuarioLogado();
        for (Livro localLivro:livros) {
            if (localLivro.getReservado_para().equals(nomeUsuario)){
                livrosAlugadosPorUsuario.add(localLivro);
            }
        }
        return livrosAlugadosPorUsuario;
    }

    public static List<Livro> listarHistoricoReservas(){

        return listaHistorico;

    }

    public static List<Livro> listarTodosReservados(){

        List<Livro> reservados = new ArrayList<>();
        for (Livro localLivro:livros){

            if (localLivro.isReservado()){
                reservados.add(localLivro);
            }
        }


        return reservados;

    }

    public static Livro findById(int idLivro){

        for (Livro localLivro: livros){

            if (idLivro == localLivro.getIdLivro()){

                return localLivro;
            }
        }
        return null;
    }

    private static boolean existeLivro(int idLivro){

        for(Livro livroexiste: livros){

            if (idLivro == livroexiste.getIdLivro()){

                return true;
            }

            if (idLivro != livroexiste.getIdLivro()){
                return false;
            }
        }
        return false;
    }

    public static void update(Livro livro){


        Livro livroEditado = findById(livro.getIdLivro());
        if (livroEditado != null) {
            livroEditado.setTitulo(livro.getTitulo());
            livroEditado.setEdicao(livro.getEdicao());
            livroEditado.setEditora(livro.getEditora());
            livroEditado.setAutor(livro.getAutor());
            livroEditado.setData_publicacao(livro.getData_publicacao());
        }


                //if verifica nullpointer pra não dar cagada
                //referencia // obj // ponteiro e etc

    }
}
