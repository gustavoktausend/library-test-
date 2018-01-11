package br.com.neoway.library.dao;

import br.com.neoway.library.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    private static List<Livro> livros;

    static {
        livros = new ArrayList<>();
    }

    public static void add(Livro livro){
        livros.add(livro);
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

    public static void update(Livro livro){
                livros.set(livros.indexOf(findById(livro.getIdLivro())),findById(livro.getIdLivro()));
    }
}
