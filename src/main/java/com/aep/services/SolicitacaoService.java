package com.aep.services;

import com.aep.Solicitacao;
import com.aep.Usuario;
import com.aep.enums.Categoria;
import com.aep.enums.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public void criarSolicitacaoFlow(Scanner scanner){
        System.out.printf("===CRIANDO SOLICITAÇÃO===");

        Categoria[] categorias = Categoria.values();
        Categoria categoriaSelecionada = null;

        while(categoriaSelecionada == null){
            System.out.printf("Categorias: \n");
            for(int index = 0; index<categorias.length; index++){
                System.out.println((index + 1 )+" - " + categorias[index]);
            }
            System.out.println("Seleciona a categoria\n");
            int categoriaOption = scanner.nextInt();
            scanner.nextLine();

            if(categoriaOption >= 1 && categoriaOption <= categorias.length){
                categoriaSelecionada = categorias[categoriaOption - 1];
            } else {
                System.out.println("Categoria inválida\n");
            }
        }

        System.out.println("Nome do usuário: \n");
        String userName = scanner.nextLine();

        System.out.println("RG: \n");
        String userRg = scanner.nextLine();

        System.out.println("Endereço: \n");
        String userAddress = scanner.nextLine();

        Usuario user = new Usuario(userName, userRg, userAddress);

        System.out.println("Comentario(Descreva o problema): \n");
        String comentario = scanner.nextLine();

        Solicitacao solicitacao = criarSolicitacao(
                categoriaSelecionada, Status.ABERTA, user, comentario
        );

        System.out.println("Solicitação criada com o id: " + solicitacao.getId());
    }

    public void buscarSolicitacaoFlow(Scanner scanner){
        System.out.println("Digite o ID da solicitação\n");
        int idBuscaSolicitacao = scanner.nextInt();

        Solicitacao solicitacaoEncontrada = findSolicitacaoById(idBuscaSolicitacao);

        if(solicitacaoEncontrada != null){
            System.out.println("Solicitação econtrada: \n");
            System.out.println("ID: \n"+ solicitacaoEncontrada.getId());
            System.out.println("Categoria: \n"+ solicitacaoEncontrada.getCategoria());
            System.out.println("Status: \n"+ solicitacaoEncontrada.getStatus());
            System.out.println("Usuário da solicitação: \n"+solicitacaoEncontrada.getUsuario().getNome());
            System.out.println("Descrição: \n" +solicitacaoEncontrada.getComentarios());
        }else {
            System.out.println("Solicitação não encontrada");
        }
    }

    public void listarSolicitacoesFlow(){
        List<Solicitacao> solicitacaoList = listAllSolicitacoes();

        if(solicitacaoList.isEmpty()){
            System.out.println("Nenhuma solicitção cadastrada\n");
        }else{
            for (Solicitacao solicitacoes : solicitacaoList){
                System.out.println("-----------\n");
                System.out.println("\nID: " +solicitacoes.getId());
                System.out.println("\nCategoria: "+solicitacoes.getCategoria());
                System.out.println("\nStatus: "+solicitacoes.getStatus());
                System.out.println("\nUsuario: "+solicitacoes.getUsuario().getNome());
                System.out.println("\nDescrição: "+solicitacoes.getComentarios());
            }
        }
    }

    public void alterarStatusFlow(Scanner scanner){
        System.out.println("Alterar status da solicitação\n Digite o ID da solicitação que deseja alterar: ");
        int idSolicitacaoAlterada = scanner.nextInt();
        scanner.nextLine();

        Solicitacao solicitacaoAlterada = findSolicitacaoById(idSolicitacaoAlterada);

        if(solicitacaoAlterada == null){
            System.out.println("Solicitação não encontrada\n");
            return;
        }

        System.out.println("Status atual: \n"+solicitacaoAlterada.getStatus());
        System.out.println("Status disponíveis: \n");

        for(Status status: Status.values()){
            if (solicitacaoAlterada.getStatus() != status){
                System.out.println("- "+status);
            }
        }

        System.out.println("Novo status: ");
        Status novoStatus = Status.valueOf(scanner.nextLine().toUpperCase());

        solicitacaoAlterada.alterarStatus(novoStatus);

        System.out.println("\nStatus atualizado!");
    }
}