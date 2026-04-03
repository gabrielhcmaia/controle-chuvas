package com.aep;

import com.aep.enums.Categoria;
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
        SolicitacaoService service = new SolicitacaoService();
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

                    if(categoriaOption >= 1 && categoriaOption <= categorias.length){
                        categoriaSelecionada = categorias[categoriaOption - 1];

                    } else {
                        System.out.println("Categoria inválida\n");
                    }
                    }



            }


        } while (opcao != 5);
        scanner.close();

    }
}
