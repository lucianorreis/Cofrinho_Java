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
        Cofrinho cofrinho = new Cofrinho();
        cofrinho.adicionar(new Dolar(10.0));
        cofrinho.adicionar(new Euro(8.0));
        cofrinho.adicionar(new Real(20.0));

        cofrinho.listarMoedas();
        double Dolar = 5.10;
        double Euro = 5.55;
        double Real = cofrinho.calcularValorTotalEmReal();
        double valorTotalEmReal = Dolar * Real + Euro * Real;

        System.out.println("Valor total em Real: R$" + valorTotalEmReal);
    }
}
