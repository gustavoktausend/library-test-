package br.com.neoway.library;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class BasicBean implements Serializable {

    private static final long serialVersionUID = -596090132389708717L;

    private String msg = "Bem Vindo!";


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String preencheString() {
        if (msg.equals("Bem Vindo!")){
          this.setMsg("Neoway UPE - 2018");
        }
        else{
          this.setMsg("Bem Vindo!");
        }
        return "index.xhtml";
    }
}