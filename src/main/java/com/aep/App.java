package com.aep;

import com.aep.services.SolicitacaoService;

import java.util.Scanner;

public class App
{
    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            System.out.printf("Erro ao limpar terminal: %s%n", e.getMessage());
        }
    }

    public static void main( String[] args )
    {
        SolicitacaoService solicitacaoService = new SolicitacaoService();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("\n===CONTROLE DE CHUVAS MARINGAENSE===");
            System.out.println("1 - Criar solicitação");
            System.out.println("2 - Buscar solicitação por ID");
            System.out.println("3 - Listar todas");
            System.out.println("4 - Alterar status");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    solicitacaoService.criarSolicitacaoFlow(scanner);
                    break;

                case 2:
                    clearConsole();
                    solicitacaoService.buscarSolicitacaoFlow(scanner);
                    break;

                case 3:
                    clearConsole();
                    solicitacaoService.listarSolicitacoesFlow();
                    break;

                case 4:
                    clearConsole();
                    solicitacaoService.alterarStatusFlow(scanner);
                    break;

                case 5:
                    clearConsole();
                    System.out.println("Saindo ...\n");
                    break;
            }

        } while (opcao != 5);
        scanner.close();
    }
}