package br.com.neoway.library;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@SessionScoped
@ManagedBean
public class LivroBean implements Serializable{

    private Livro livro;

    public  List<Livro> livros;

    @PostConstruct
    public void init(){
        livros = new ArrayList<Livro>();
        livro = new Livro();
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro){
        this.livro = livro;
    }

    public List<Livro> getLivros() {
        return livros;
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
        livros.add(livro);
        this.livro = new Livro();

    }

    public void buscarLivro(){
        for (Livro livro : livros) {
            if (livro.getIdLivro() == this.livro.getIdLivro()){
                this.setLivro(livro);
                System.out.println(this.livro.getTitulo());
            }
        }
    }

    public void removerLivro(Livro livro){
        this.setLivro(livro);
        System.out.println("Removendo Livro:" + this.livro.getTitulo()) ;
        livros.remove(this.livro);
        this.livro = new Livro();




    }

}