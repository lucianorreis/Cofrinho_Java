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

    public double getValor() {
        return valor;
    }

    public String getPais() {
        return pais;
    }

    public String getNome() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNome'");
    }
}

class Dolar extends Moeda {
    private int quantidade;

    public Dolar(double valor) {
        super(valor, "Estados Unidos");
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }
}

class Euro extends Moeda {
    private int quantidade;

    public Euro(double valor) {
        super(valor, "Europa");
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }
}

class Real extends Moeda {
    private int quantidade;

    public Real(double valor) {
        super(valor, "Brasil");
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }
}

class Cofrinho {
    private List<Moeda> moedas = new ArrayList<>();

    public void adicionar(Moeda moeda) {
        moedas.add(moeda);
    }

    public void tirar(Moeda moeda) {
        moedas.remove(moeda);
    }
    public List<Moeda> getMoedas() {
        return moedas;
    }

    public void listarMoedas() {
        int quantidadeDolar = 0;
        int quantidadeEuro = 0;
        int quantidadeReal = 0;
        
        for (Moeda moeda : moedas) {
            if (moeda instanceof Dolar) {
                quantidadeDolar++;
            } else if (moeda instanceof Euro) {
                quantidadeEuro++;
            } else if (moeda instanceof Real) {
                quantidadeReal++;
            }
        }
        
        System.out.println("Quantidade de moedas:");
        System.out.println("Dólar: " + quantidadeDolar);
        System.out.println("Euro: " + quantidadeEuro);
        System.out.println("Real: " + quantidadeReal);
    }

    public double calcularValorTotalEmReal() {
        return moedas.stream().mapToDouble(Moeda::getValor).sum();
    }
    
}

public class main {
    private static final double COTACAO_DOLAR = 5.10;
    private static final double COTACAO_EURO = 5.55;
    private static final double COTACAO_REAL = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Cofrinho cofrinho = new Cofrinho();

        while (true) {
            System.out.println("\n##-- Menu --##");
            System.out.println("1 - Adicionar dinheiro");
            System.out.println("2 - Listar dinheiro");
            System.out.println("3 - Tirar dinheiro");
            System.out.println("4 - Sair");
            System.out.print("Digite sua opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarDinheiro(scanner, cofrinho);
                    break;
                case 2:
                    cofrinho.listarMoedas();
                    break;
                case 3:
                    tirarDinheiro(scanner, cofrinho);
                    break;
                case 4:
                    System.out.println("\nAté logo!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("\nOpção Inválida!");
                    break;
            }
        }
    }

    private static void adicionarDinheiro(Scanner scanner, Cofrinho cofrinho) {
        System.out.println("\nAdicionar dinheiro:");
        System.out.print("> Quantidade em dólar: ");
        double valorDolar = scanner.nextDouble();
        System.out.print("> Quantidade em euro: ");
        double valorEuro = scanner.nextDouble();
        System.out.print("> Quantidade em real: ");
        double valorReal = scanner.nextDouble();

        cofrinho.adicionar(new Dolar(COTACAO_DOLAR * valorDolar));
        cofrinho.adicionar(new Euro(COTACAO_EURO * valorEuro));
        cofrinho.adicionar(new Real(COTACAO_REAL * valorReal));

        System.out.println("Valor total em reais: " + cofrinho.calcularValorTotalEmReal());
    }
    
    private static void listaDinehrio(Scanner scanner, Cofrinho cofrinho) {
    	List<Moeda> moedas = new ArrayList<>();
    	moedas.add(new Dolar(100)); // Adiciona 100 dólares à lista
    	moedas.add(new Euro(50));   // Adiciona 50 euros à lista
    	moedas.add(new Real(500));  // Adiciona 500 reais à lista

    	// Mostra a quantidade de cada tipo de moeda que você possui
    	for (Moeda moeda : moedas) {
    	    System.out.println("Você possui " + moeda.getQuantidade() + " " + moeda.getNome());
    	}
    }

    private static void tirarDinheiro(Scanner scanner, Cofrinho cofrinho) {
        System.out.println("\nTirar dinheiro:");
        System.out.print("> Quantidade em dólar: ");
        int quantidadeDolar = scanner.nextInt();
        System.out.print("> Quantidade em euro: ");
        int quantidadeEuro = scanner.nextInt();
        System.out.print("> Quantidade em real: ");
        int quantidadeReal = scanner.nextInt();

        List<Moeda> moedasARemover = new ArrayList<>();

        for (Moeda moeda : cofrinho.getMoedas()) {
            if (moeda instanceof Dolar && quantidadeDolar > 0) {
                moedasARemover.add(moeda);
                quantidadeDolar--;
            } else if (moeda instanceof Euro && quantidadeEuro > 0) {
                moedasARemover.add(moeda);
                quantidadeEuro--;
            } else if (moeda instanceof Real && quantidadeReal > 0) {
                moedasARemover.add(moeda);
                quantidadeReal--;
            }
        }

        for (Moeda moeda : moedasARemover) {
            cofrinho.tirar(moeda);
        }

        System.out.println("Valor total em reais após retirada: " + cofrinho.calcularValorTotalEmReal());
    }
}
