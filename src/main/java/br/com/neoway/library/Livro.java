package br.com.neoway.library;
import java.util.Date;
import java.util.Objects;

public class Livro {


    private int idLivro;

    private String titulo;
    private String editora;
    private String autor;
    private String data_publicacao;
    private String edicao;
    private boolean reservado;
    private boolean alugado;
    private Date data_reserva;
    private Date data_cancelamento_reserva;
    private Date data_retirada;
    private Date data_devolucao;
    private String status;
    private String reservado_para;
    private String alugado_para;





    public Livro() {
    }
    public int getIdLivro() {
        return idLivro;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getEditora() {
        return editora;
    }
    public String getAutor() {
        return autor;
    }
    public String getData_publicacao() {
        return data_publicacao;
    }
    public String getEdicao() {
        return edicao;
    }
    public boolean isAlugado() {
        return alugado;
    }
    public boolean isReservado() {
        return reservado;
    }
    public Date getData_reserva() {
        return data_reserva;
    }
    public Date getData_cancelamento_reserva() {
        return data_cancelamento_reserva;
    }
    public Date getData_retirada() {
        return data_retirada;
    }
    public String getStatus() {
        return status;
    }
    public Date getData_devolucao() {
        return data_devolucao;
    }
    public String getReservado_para() {
        return reservado_para;
    }
    public String getAlugado_para() {
        return alugado_para;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }
    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setData_publicacao(String data_publicacao) {
        this.data_publicacao = data_publicacao;
    }
    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }
    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }
    public void setData_reserva(Date data_reserva) {
        this.data_reserva = data_reserva;
    }
    public void setData_cancelamento_reserva(Date data_cancelamento_reserva) {
        this.data_cancelamento_reserva = data_cancelamento_reserva;
    }
    public void setData_retirada(Date data_retirada) {
        this.data_retirada = data_retirada;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
    public void setReservado_para(String reservado_para) {
        this.reservado_para = reservado_para;
    }
    public void setAlugado_para(String alugado_para) {
        this.alugado_para = alugado_para;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return idLivro == livro.idLivro;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idLivro);
    }
}
