package com.aep.services;

import com.aep.Solicitacao;
import com.aep.Usuario;
import com.aep.enums.Categoria;
import com.aep.enums.Status;

import java.util.ArrayList;
import java.util.List;

public class SolicitacaoService {
    private List<Solicitacao> solicitacaos = new ArrayList<>();
    private int contadorId= 1;

    public Solicitacao criarSolicitacao(Categoria categoria, Status status, Usuario usuario, String comentario){
        Solicitacao s = new Solicitacao(contadorId++, categoria, status, usuario, comentario);
        solicitacaos.add(s);
        return s;
    }

    public Solicitacao findSolicitacaoById(int id){
        for (Solicitacao s: solicitacaos){
            if(s.getId() == id)return s;
        }
        return null;
    }

    public List<Solicitacao>listAllSolicitacoes(){
        return  solicitacaos;
    }
}
