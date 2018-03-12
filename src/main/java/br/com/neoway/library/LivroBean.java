package br.com.neoway.library;
import br.com.neoway.library.dao.LivroDAO;
import br.com.neoway.library.dao.UsuarioDAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@RequestScoped
@ManagedBean
public class LivroBean implements Serializable{

    private Integer idLivro;
    private Livro livro;
    private Date dataAtual = Calendar.getInstance().getTime();
    private List<Livro> listaBusca;

    @PostConstruct
    public void init(){
        String idLivro = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idLivro");


        if(idLivro != null){
            livro = LivroDAO.findById(Integer.parseInt(idLivro));
        }else{
            livro = new Livro();
        }

        listaBusca = new ArrayList<>();


        Livro livro1 = new Livro();

        livro1.setTitulo("titulo");
        livro1.setAutor("autor");
        livro1.setEditora("editora");
        livro1.setData_publicacao("21/12/2000");
        LivroDAO.add(livro1);
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro){
        this.livro = livro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
    }

    public List<Livro> getLivros() {
        return LivroDAO.list();
    }

    public List<Livro> getListaBusca() {
        return listaBusca;
    }

    public Integer getIdLivro() {
        return idLivro;
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
        for (Livro livro :LivroDAO.list()){
            if (livro.getAutor().equals(this.livro.getAutor())){
                listaBusca.add(livro);
                this.livro = new Livro();
            }

        }
    }

    public void buscarLivrosPorTitulo(){
        for (Livro livro :LivroDAO.list()){
            if(livro.getTitulo().equals(this.livro.getTitulo())){
                listaBusca.add(livro);
                this.livro = new Livro();
            }
        }
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

    public void confirmarAlteracaoLivro(){
        LivroDAO.update(livro);
    }

    public void alugarLivro (Livro livro){
        if(!livro.isReservado()){
            if(!livro.isAlugado()){
                if(LivroDAO.listarAlugadosPorUsuario().size() < 3) {
                    this.setLivro(livro);
                    this.livro.setAlugado(true);
                    this.livro = new Livro();
                    LivroDAO.addLivrosAlugar(livro);
                }else{throw new RuntimeException("Limite de livros alugados alcançado");}
            }else{throw new RuntimeException("Livro Já alugado");}
        }else{throw new RuntimeException("Livro Reservado");}
    }

//    public void reservarLivro(Livro livro){
//        if (!livro.isReservado()){
//            if(!livro.isAlugado()){
//                this.livro.setReservado(true);
//                this.livro.setData_reserva(dataAtual);
//                LivroDAO.addListaReservas(livro);
//                this.livro.setReservado_para(UsuarioDAO.retornaNomeUsuarioLogado());
//                this.livro = new Livro();
//            }
//        }
//    }

    public void cancelarReservaLivro(Livro livro){
        if(livro.isReservado()){
            this.livro.setReservado(false);
            this.livro.setData_cancelamento_reserva(dataAtual);
            this.livro.setReservado_para("");
            this.livro = new Livro();
        }
    }

    public void devoluçãoLivroAlugado(Livro livro){
        if(livro.isReservado()){
            this.setLivro(livro);
            this.livro.setAlugado(false);
            LivroDAO.remmoverLivroAlugar(livro);
            this.livro.setData_devolucao(dataAtual);
            this.livro = new Livro();
        }
    }

    public void carregarLivro(){
        this.livro = LivroDAO.findById(idLivro);
    }



}