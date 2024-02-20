package aula01TPI;

public class Produto {
    public int codigo;
    public String nome;
    public double valor;

    public String mostrarDados() {
        return ("\nCódigo: " + this.codigo + ". Nome: " + this.nome + ". Valor: R$ " + this.valor);
    };
    public double calcularTotal(double quantidade) {
        return this.valor * quantidade;
    }
}
