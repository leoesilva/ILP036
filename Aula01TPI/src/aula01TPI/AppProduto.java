package aula01TPI;

import java.util.Scanner;

public class AppProduto {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Produto p = new Produto();
        p.codigo = p.geraCodigo();
        System.out.print("Digite o nome do produto: ");
        p.nome = entrada.next();
        System.out.print("Digite o valor do produto: ");
        p.valor = entrada.nextDouble();
        System.out.print("Digite a quantidade do produto: ");
        double qtd = entrada.nextDouble();
        entrada.close();
        System.out.println(p.mostrarDados());
        System.out.println("Quantidade: " + qtd + "\tValor total: R$ " + p.calcularTotal(qtd));
    }
}
