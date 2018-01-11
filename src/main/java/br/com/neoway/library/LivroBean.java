package br.com.neoway.library;
import br.com.neoway.library.dao.LivroDAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@RequestScoped
@ManagedBean
public class LivroBean implements Serializable{

    private Livro livro;

    @PostConstruct
    public void init(){

        livro = new Livro();
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro){
        this.livro = livro;
    }

    public List<Livro> getLivros() {
        return LivroDAO.list();
    }

    public void cadastrarLivro(){
        System.out.println("Cadastrando Livro: " + this.livro.getTitulo());

        if(livro.getAutor().isEmpty()){
            throw new RuntimeException("É necessário um autor");
        }
        if(livro.getTitulo().isEmpty()){
            throw new RuntimeException("É necessário Titulo");
        }
        if(livro.getData_publicacao().isEmpty()){
            throw new RuntimeException("É necessário a Data de Publicação");
        }
        if(livro.getEdicao().isEmpty()){
            livro.setEdicao("Primeira Edição");
        }
        if(livro.getEditora().isEmpty()){
            throw  new RuntimeException("É necessário informar a Editora");
        }

        System.out.println("Titulo:"+this.livro.getTitulo()+"ID:"+this.livro.getIdLivro()+"Autor:"+this.livro.getAutor());
        LivroDAO.add(livro);

    }

    public void buscarLivro(){
        for (Livro livro : LivroDAO.list()) {
            if (livro.getIdLivro() == this.livro.getIdLivro()){
                this.setLivro(livro);
                System.out.println(this.livro.getTitulo());
            }
        }
    }

    public void removerLivro(Livro livro){
        this.setLivro(livro);
        System.out.println("Removendo Livro:" + this.livro.getTitulo()) ;
        LivroDAO.remove(this.livro);
    }

//    public void carregarLivro (Livro livro) {
//
//        System.out.println("Carregando Livro:" + this.livro.getTitulo());
//        this.livro = livro;
//        System.out.println("Indice do book" +;
//    }

    public void alterarLivro (Livro livro) {
        LivroDAO.update(this.livro);

    }
}