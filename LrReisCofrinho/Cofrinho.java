package LrReisCofrinho;

import java.util.Scanner;

public class Cofrinho {

    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        //* Menu */
        while (true) {
            System.out.println("\n##-- Menu --##");
            System.out.println("1 - Adicionar dinheiro");
            System.out.println("2 - Listar dinheiro");
            System.out.println("3 - Tirar dinheiro");
            System.out.println("4 - Sair");
            System.out.print("Digite sua opção: ");
            int opt = scan.nextInt();

            
            switch (opt) {
                case 1 -> {}
                case 2 -> {}
                case 3 -> {}
                case 4 -> {
                    System.out.println("\nAté logo!");
                    scan.close();
                    System.exit(0);
                }
                default -> {System.out.println("\nOpção Inválida!");}
                
            }
        }
    }
}
