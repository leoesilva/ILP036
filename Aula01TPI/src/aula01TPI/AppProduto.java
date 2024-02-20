package aula01TPI;

public class AppProduto {
    public static void main(String[] args) {
        Produto p = new Produto();
        double qtd = 2;
        p.codigo = 1;
        p.nome = "Caderno";
        p.valor = 32.78;
        System.out.println(p.mostrarDados());
        System.out.println("Quantidade: " + qtd + "\tValor total: R$ " + p.calcularTotal(qtd));
    }
}
