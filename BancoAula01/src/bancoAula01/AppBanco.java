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

        System.out.println(c.exibirDados());

        System.out.print("Digite um valor para depositar: ");
        valorOperacao = entrada.nextDouble();  
        c.realizarDeposito(valorOperacao);
        System.out.println("Depósito realizado com sucesso!");
        System.out.println(c.exibirSaldo());

        System.out.print("Digite um valor para sacar: ");
        valorOperacao = entrada.nextDouble();
        if (c.realizarSaque(valorOperacao)) {
            System.out.println("Saque realizado com sucesso!");
        }
        else {
            System.out.println("ERRO! Saldo insuficiente para realizar essa operação.");
        }        
        System.out.println(c.exibirSaldo());        
    }
}
