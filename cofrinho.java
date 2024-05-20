import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Moeda {
    protected double valor;
    protected String pais;

    public Moeda(double valor, String pais) {
        this.valor = valor;
        this.pais = pais;
    }
    // Métodos getters para valor e país
    public double getValor() {
        return valor;
    }

    public String getPais() {
        return pais;
    }
}
// Subclasses específicas de moedas (mostrando sua nacinalidade)
class Dolar extends Moeda {
    public Dolar(double valor) {
        super(valor, "Estados Unidos");
    }
}

class Euro extends Moeda {
    public Euro(double valor) {
        super(valor, "Europa");
    }
}

class Real extends Moeda {
    public Real(double valor) {
        super(valor, "Brasil");
    }
}
// Classe Cofrinho: adicionar, remover e listar as moedas
class Cofrinho {
    private List<Moeda> moedas = new ArrayList<>();

    public void adicionar(Moeda moeda) {
        moedas.add(moeda);
    }

    public void remover(Moeda moeda) {
        moedas.remove(moeda);
    }

    public void listarMoedas() {
        for (Moeda moeda : moedas) {
            System.out.println(moeda.getPais() + " - " + moeda.getValor());
        }
    }

    public double calcularValorTotalEmReal() {
        return moedas.stream().mapToDouble(Moeda::getValor).sum();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 4) {
            System.out.println("##-- Menu --##\n");
            System.out.println("|-----------------------------|");
            System.out.println("| Opção 1 - Adicionar dinehiro|");
            System.out.println("| Opção 2 - Listar dinheiro   |");
            System.out.println("| Opção 3 - Tirar dinheiro    |");
            System.out.println("| Opção 4 - Sair              |");
            System.out.println("|-----------------------------|");
            System.out.print("Digite uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\nOpção Adicionar dinheiro ");
                    double CotacaoDolar = 5.0;
                    double CotacaoEuro = 5.50;
                    double CotacaoReal = 1;
            
                    System.out.println("Informe a quantidade em dolar:");
                    double valorDolar = scanner.nextDouble();
                    System.out.println("Informe a quantidade em euro:");
                    double valorEuro = scanner.nextDouble();
                    System.out.println("Informe a quantidade em real:");
                    double valorReal = scanner.nextDouble();
            
            
                    Cofrinho cofrinho = new Cofrinho();
                    cofrinho.remover(new Dolar(CotacaoDolar * valorDolar));
                    cofrinho.remover(new Euro(CotacaoEuro * valorEuro));
                    cofrinho.remover(new Real(CotacaoReal * valorReal));
            
                    cofrinho.listarMoedas();
            
                    System.out.println(cofrinho.calcularValorTotalEmReal());
                    
            break;
                case 2:
            break;
                case 3:
                    System.out.println("\nOpção Tirar dinheiro ");
                        
                    System.out.println("Informe a quantidade em dolar:");
                    double valorDolar = scanner.nextDouble();
                    System.out.println("Informe a quantidade em euro:");
                    double valorEuro = scanner.nextDouble();
                    System.out.println("Informe a quantidade em real:");
                    double valorReal = scanner.nextDouble();

                    Cofrinho cofrinho = new Cofrinho();
                    cofrinho.tirar(new Dolar(CotacaoDolar * valorDolar));
                    cofrinho.tirar(new Euro(CotacaoEuro * valorEuro));
                    cofrinho.tirar(new Real(CotacaoReal * valorReal));
                
                    System.out.println(cofrinho.calcularValorTotalEmReal());
            break;
                case 4:
                    System.out.println("\nAté logo!");
            break;
                default:
                    System.out.println("\nOpção Inválida!");
            }
        }

        scanner.close();
    }
    
}
