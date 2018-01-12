package br.com.neoway.library.dao;

import br.com.neoway.library.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    public static int IdCount;

    private static List<Livro> livros;

    static {
        livros = new ArrayList<>();
    }

    public static void add(Livro livro){
        livro.setIdLivro(IdCount++);
        if (existeLivro(livro.getIdLivro())){
            System.out.println("livro já existe");

        }else{
            livros.add(livro);

        }

    }

    public static void remove(Livro livro){

        livros.remove(livro);
    }

    public static List<Livro> list(){

        return livros;
    }

    public static Livro findById (int idLivro){

        for (Livro localLivro: livros){

            if (idLivro == localLivro.getIdLivro()){

                return localLivro;
            }
        }
        return null;
    }

    public static boolean existeLivro (int idLivro){

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
                livroEditado.setTitulo(livro.getTitulo());
                livroEditado.setIdLivro(livro.getIdLivro());
                livroEditado.setEdicao(livro.getEdicao());
                livroEditado.setEditora(livro.getEditora());
                livroEditado.setAutor(livro.getAutor());
                livroEditado.setData_publicacao(livro.getData_publicacao());

                //referencia // obj // ponteiro e etc

    }
}
