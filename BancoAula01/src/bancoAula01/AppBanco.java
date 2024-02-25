package bancoAula01;

import java.util.Scanner;

public class AppBanco {
    public static Scanner entrada = new Scanner(System.in);
    public static Conta[] contas = new Conta[2];

    public static void main(String[] args) {
        criarContas();
        selecionarOpcoes();
    }

    private static void criarContas() {
        Conta conta1 = new Conta();
        conta1.nomeTitular = "José";
        conta1.numConta = 1;
        contas[0] = conta1;

        Conta conta2 = new Conta();
        conta2.nomeTitular = "Maria";
        conta2.numConta = 2;
        contas[1] = conta2;
    }

    private static void consultarSaldo() {
        System.out.print("Digite o número da conta: ");
        int numConta = entrada.nextInt();
        Conta c = null;
        for (Conta conta : contas) {
            if (conta.numConta == numConta) {
                c = conta;
                break;
            }
        }
        if (c == null) {
            System.out.println("Conta não encontrada.");
            return;
        }
        System.out.println(c.exibirDados());
    }

    private static void realizarDeposito() {
        System.out.print("Digite o número da conta: ");
        int numConta = entrada.nextInt();
        Conta c = null;
        for (Conta conta : contas) {
            if (conta.numConta == numConta) {
                c = conta;
                break;
            }
        }
        if (c == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        System.out.print("Digite um valor para depositar: ");
        double valorOperacao = entrada.nextDouble();
        c.realizarDeposito(valorOperacao);
        System.out.println("Depósito realizado com sucesso!");
    }

    private static void realizarSaque() {
        System.out.print("Digite o número da conta: ");
        int numConta = entrada.nextInt();
        Conta c = null;
        for (Conta conta : contas) {
            if (conta.numConta == numConta) {
                c = conta;
                break;
            }
        }
        if (c == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        System.out.print("Digite um valor para sacar: ");
        double valorOperacao = entrada.nextDouble();
        if (c.realizarSaque(valorOperacao)) {
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("ERRO! Saldo insuficiente para realizar essa operação.");
        }
        System.out.println(c.exibirSaldo());
    }

    private static void realizarTransferencia() {
        System.out.print("Digite o número da conta de origem: ");
        int numContaOrigem = entrada.nextInt();
        Conta cOrigem = null;
        for (Conta conta : contas) {
            if (conta.numConta == numContaOrigem) {
                cOrigem = conta;
                break;
            }
        }
        if (cOrigem == null) {
            System.out.println("Conta de origem não encontrada.");
            return;
        }

        System.out.print("Digite o número da conta de destino: ");
        int numContaDestino = entrada.nextInt();
        Conta cDestino = null;
        for (Conta conta : contas) {
            if (conta.numConta == numContaDestino) {
                cDestino = conta;
                break;
            }
        }
        if (cDestino == null) {
            System.out.println("Conta de destino não encontrada.");
            return;
        }

        if (cOrigem == cDestino) {
            System.out.println("ERRO! A conta de origem e destino são iguais. Transferência não permitida.");
            return;
        }

        System.out.print("Digite o valor a ser transferido: ");
        double valorOperacao = entrada.nextDouble();

        if (cOrigem.realizarTransferencia(cDestino, valorOperacao)) {
            System.out.println("Transferência realizada com sucesso!");
            System.out.println(cOrigem.exibirSaldo());
        } else {
            System.out.println("ERRO! Saldo insuficiente para realizar essa operação.");
        }
    }

    private static void encerraPrograma() {
        System.out.println("Até logo!");
        System.exit(0);
    }

    private static void selecionarOpcoes() {
        do {
            System.out.println("**\tCaixa eletrônico\t**");
            System.out.println("Selecione uma das opções abaixo:");
            System.out.println("\t1 - Consultar saldo");
            System.out.println("\t2 - Realizar depósito");
            System.out.println("\t3 - Realizar saque");
            System.out.println("\t4 - Realizar transferência");
            System.out.println("\t0 - Sair");
            int opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    realizarDeposito();
                    break;
                case 3:
                    realizarSaque();
                    break;
                case 4:
                    realizarTransferencia();
                    break;
                case 0:
                    encerraPrograma();
                    break;
                default:
                    System.out.println("ERRO! Opção inválida");
                    break;
            }
        } while (true);
    }
}
