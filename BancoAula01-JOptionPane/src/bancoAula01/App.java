package bancoAula01;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class App {
    public static ArrayList<Conta> contas = new ArrayList<Conta>();

    public static void main(String[] args) {
        selecionarOpcao();
    }

    private static void criarConta() {
        int numConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta:"));
        String nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente:");
        String cpfCliente = JOptionPane.showInputDialog("Digite o CPF do cliente:");
        Conta c = new Conta(numConta, nomeCliente, cpfCliente);
        contas.add(c);
        JOptionPane.showMessageDialog(null, c);
    }

    private static void consultarConta() {
        int numConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta:"));
        Conta c = null;
        for (Conta conta : contas) {
            if (conta.numConta == numConta) {
                c = conta;
                break;
            }
        }
        if (c == null) {
            JOptionPane.showMessageDialog(null, "Conta não encontrada.");
            return;
        }
        JOptionPane.showMessageDialog(null, c);
    }

    private static void realizarDeposito() {
        int numConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta:"));
        Conta c = null;
        for (Conta conta : contas) {
            if (conta.numConta == numConta) {
                c = conta;
                break;
            }
        }
        if (c == null) {
            JOptionPane.showMessageDialog(null, "Conta não encontrada.");
            return;
        }
        double valorOperacao = Double.parseDouble(JOptionPane.showInputDialog("Digite um valor para depositar:"));
        c.realizarDeposito(valorOperacao);
        JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!");
    }

    private static void realizarSaque() {
        int numConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta:"));
        Conta c = null;
        for (Conta conta : contas) {
            if (conta.numConta == numConta) {
                c = conta;
                break;
            }
        }
        if (c == null) {
            JOptionPane.showMessageDialog(null, "Conta não encontrada.");
            return;
        }
        double valorOperacao = Double.parseDouble(JOptionPane.showInputDialog("Digite um valor para sacar:"));
        if (c.realizarSaque(valorOperacao)) {
            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "ERRO! Saldo insuficiente para realizar essa operação.");
        }
        JOptionPane.showMessageDialog(null, "Saldo atual: R$ " + String.format("%.2f", c.exibirSaldo()));
    }

    private static void realizarTransferencia() {
        int numContaOrigem = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta de origem:"));
        Conta cOrigem = null;
        for (Conta conta : contas) {
            if (conta.numConta == numContaOrigem) {
                cOrigem = conta;
                break;
            }
        }
        if (cOrigem == null) {
            JOptionPane.showMessageDialog(null, "Conta de origem não encontrada.");
            return;
        }
        int numContaDestino = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta de destino:"));
        Conta cDestino = null;
        for (Conta conta : contas) {
            if (conta.numConta == numContaDestino) {
                cDestino = conta;
                break;
            }
        }
        if (cDestino == null) {
            JOptionPane.showMessageDialog(null, "Conta de destino não encontrada.");
            return;
        }

        if (cOrigem == cDestino) {
            JOptionPane.showMessageDialog(null,
                    "ERRO! A conta de origem e destino são iguais. Transferência não permitida.");
            return;
        }
        double valorOperacao = Double.parseDouble(JOptionPane.showInputDialog("Digite um valor para transferir:"));
        if (cOrigem.realizarTransferencia(cDestino, valorOperacao)) {
            JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "ERRO! Saldo insuficiente para realizar essa operação.");
        }
        JOptionPane.showMessageDialog(null, "Saldo atual: R$ " + String.format("%.2f", cOrigem.exibirSaldo()));
    }

    private static void encerraPrograma() {
        JOptionPane.showMessageDialog(null, "Até logo!");
        System.exit(0);
    }

    private static void selecionarOpcao() {
        StringBuilder sb = new StringBuilder();
        sb.append("CAIXA ELETRÔNICO\n\n");
        sb.append("Selecione uma das opções abaixo:\n");
        sb.append("\t1 - Consultar conta\n");
        sb.append("\t2 - Realizar depósito\n");
        sb.append("\t3 - Realizar saque\n");
        sb.append("\t4 - Realizar transferência\n");
        sb.append("\t5 - Criar nova conta\n");
        sb.append("\t0 - Sair\n\n");
        sb.append("Digite a opção selecionada:");
        do {
            int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, sb));
            switch (opcao) {
                case 1:
                    consultarConta();
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
                case 5:
                    criarConta();
                    break;
                case 0:
                    encerraPrograma();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "ERRO! Opção inválida");
                    break;
            }
        } while (true);
    }
}
