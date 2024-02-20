package bancoAula01;

import java.util.Scanner;

public class AppBanco {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Conta c = new Conta();
        double valorOperacao = 0;

        System.out.print("Digite o nome do titular: ");
        c.nomeTitular = entrada.next();
        System.out.print("Digite o número da agência: ");
        c.numAgencia = entrada.nextInt();
        System.out.print("Digite o número da conta: ");
        c.numConta = entrada.nextInt();
        System.out.print("Digite o saldo inicial em R$: ");
        c.saldo = entrada.nextDouble();

        System.out.println(c.exibirSaldo());

        valorOperacao = 2000;
        c.realizarSaque(valorOperacao);
        System.out.println("\nValor do saque: R$ " + valorOperacao);
        System.out.println(c.exibirSaldo());

        valorOperacao = 500;        
        c.realizarDeposito(valorOperacao);
        System.out.println("\nValor do depósito: R$ " + valorOperacao);
        System.out.println(c.exibirSaldo());
    }
}
