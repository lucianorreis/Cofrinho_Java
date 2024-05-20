import java.util.ArrayList;
import java.util.List;

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

    public void removerNaPosicao(int posicao) {
        moedas.remove(posicao);
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
        double CotacaoDolar = 5.0;
        double CotacaoEuro = 5.50;
        double CotacaoReal = 1;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe a quantidade em dolar:");
        double valorDolar = scanner.nextDouble();
        System.out.println("Informe a quantidade em euro:");
        double valorEuro = scanner.nextDouble();
        System.out.println("Informe a quantidade em real:");
        double valorReal = scanner.nextDouble();


        Cofrinho cofrinho = new Cofrinho();
        cofrinho.adicionar(new Dolar(CotacaoDolar * valorDolar));
        cofrinho.adicionar(new Euro(CotacaoEuro * valorEuro));
        cofrinho.adicionar(new Real(CotacaoReal * valorReal));

        cofrinho.listarMoedas();

        System.out.println(cofrinho.calcularValorTotalEmReal());
        
        scanner.close();
    }
}
