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

    public  List<Livro> listaBusca;

    @PostConstruct
    public void init(){
        livro = new Livro();
        listaBusca = new ArrayList<>();
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

//    public List<Livro> getLivrosAlugados() {
//        return LivroDAO.listarAlugados(livro.isAlugado());
//    }
    public List<Livro> getListaBusca() {
        return listaBusca;
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
        LivroDAO.add(livro);
        livro = new Livro();

    }

    public void buscarLivro(){
        for (Livro livro : LivroDAO.list()) {
            if (livro.getIdLivro() == this.livro.getIdLivro()){
                this.setLivro(livro);
                System.out.println(this.livro.getTitulo());
            }
        }
    }

    public void buscarLivrosPorAutor(){
        for (Livro livro :LivroDAO.list()) {
            if (livro.getAutor().equals(this.livro.getAutor())){
                listaBusca.add(livro);
            }

        }
    }

    public List<Livro> listarBusca(){
        return listaBusca;
    }


    public void removerLivro(Livro livro){
        this.setLivro(livro);
        System.out.println("Removendo Livro:" + this.livro.getTitulo()) ;
        LivroDAO.remove(this.livro);
        this.livro = new Livro();
    }


    public void alterarLivro(Livro livro) {
        this.setLivro(livro);
    }

    public String detalhesLivro(Livro livro) {

        this.setLivro(livro);
        return "detalhes_livro.xhtml";
    }

    public void confirmarAlteracaoLivro(){
        LivroDAO.update(livro);
    }

    public void alugarLivro (Livro livro) {
        this.setLivro(livro);
        this.livro.setAlugado(true);
        this.livro = new Livro();
    }


}