import java.util.ArrayList;

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
    private ArrayList<Moeda> moedas = new ArrayList<>();

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
        double total = 0;
        for (Moeda moeda : moedas) {
            total += moeda.getValor();
        }
        return total;
    }
}

public class main {
    public static void main(String[] args) {
        Cofrinho cofrinho = new Cofrinho();
        cofrinho.adicionar(new Dolar(10.0));
        cofrinho.adicionar(new Euro(8.0));
        cofrinho.adicionar(new Real(20.0));

        cofrinho.listarMoedas();
        System.out.println("Valor total em Real: R$" + cofrinho.calcularValorTotalEmReal());
    }
}
