package br.com.neoway.library;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class LivroBean implements Serializable{

    private Livro livro;
    private int filtroId;
    private List<Livro> livros;

    @PostConstruct
    public void init(){
        livros = new ArrayList<Livro>();
        livro = new Livro();
    }

    public int getFiltroId() {
        return filtroId;
    }

    public void setFiltroId(int filtroId) {
        this.filtroId = filtroId;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro){
        this.livro = livro;
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

        livros.add(livro);

    }

    public void buscarLivro(){
        for (Livro livro : livros) {
            if (livro.getIdLivro() == this.getFiltroId()){
                this.setLivro(livro);
                System.out.println(this.livro.getTitulo());
            }
        }
    }

}