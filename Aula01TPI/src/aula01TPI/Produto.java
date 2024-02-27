package aula01TPI;

public class Produto {
    public int codigo;
    public String nome;
    public double valor;

    public int geraCodigo() {
        int max = 10;
        int min = 1;
        int range = max - min + 1;
        int cod = (int) (Math.random() * range) + min;
        return cod;
    }

    public String mostrarDados() {
        return ("\nCódigo: " + this.codigo + "\tNome: " + this.nome + "\tValor un.: R$ " + String.format("%.2f", this.valor));
    }

    public double calcularTotal(int quantidade) {
        return this.valor * quantidade;
    }
}
