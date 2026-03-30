package com.aep;


import com.aep.enums.Categoria;
import com.aep.enums.Status;

import java.util.ArrayList;
import java.util.List;

public class Solicitacao {
    private int id;
    private Categoria categoria;
    private Status status;
    private Usuario usuario;
    private String comentarios;

    public Solicitacao(int id, Categoria categoria, Status status, Usuario usuario, String comentarios) {
        this.id = id;
        this.categoria = categoria;
        this.status = status;
        this.usuario = usuario;
        this.comentarios = comentarios;
    }

    public void alterarStatus(Status NovoStatus){
        this.status = NovoStatus;
    }

    public int getId() {
        return id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Status getStatus() {
        return status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getComentarios(){
        return comentarios;
    }
}
