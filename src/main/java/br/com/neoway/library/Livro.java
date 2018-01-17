package br.com.neoway.library;
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
    private String data_reserva;
    private String data_cancelamento_reserva;
    private String data_retirada;



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
    public String getData_reserva() {
        return data_reserva;
    }
    public String getData_cancelamento_reserva() {
        return data_cancelamento_reserva;
    }
    public String getData_retirada() {
        return data_retirada;
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
    public void setData_reserva(String data_reserva) {
        this.data_reserva = data_reserva;
    }
    public void setData_cancelamento_reserva(String data_cancelamento_reserva) {
        this.data_cancelamento_reserva = data_cancelamento_reserva;
    }
    public void setData_retirada(String data_retirada) {
        this.data_retirada = data_retirada;
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
