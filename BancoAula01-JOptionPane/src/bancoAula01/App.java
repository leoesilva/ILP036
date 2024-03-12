package bancoAula01;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class App {
    public static ArrayList<Conta> contas = new ArrayList<Conta>();

    public static void main(String[] args) {
        menuBanco();
    }

    private static void consultarConta() {
        int numConta = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da conta:",
                "CONSULTAR CONTA", JOptionPane.QUESTION_MESSAGE));
        Conta c = null;
        for (Conta conta : contas) {
            if (conta.numConta == numConta) {
                c = conta;
                break;
            }
        }
        if (c == null) {
            JOptionPane.showMessageDialog(null, "Conta não encontrada.", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, c, "CONSULTAR CONTA", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void realizarDeposito() {
        int numConta = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da conta:",
                "REALIZAR DEPÓSITO", JOptionPane.QUESTION_MESSAGE));
        Conta c = null;
        for (Conta conta : contas) {
            if (conta.numConta == numConta) {
                c = conta;
                break;
            }
        }
        if (c == null) {
            JOptionPane.showMessageDialog(null, "Conta não encontrada.", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            return;
        }
        double valorOperacao = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite um valor para depositar:",
                "REALIZAR DEPÓSITO", JOptionPane.QUESTION_MESSAGE));
        c.realizarDeposito(valorOperacao);
        JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!", "REALIZAR DEPÓSITO",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private static void realizarSaque() {
        int numConta = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da conta:", "REALIZAR SAQUE",
                JOptionPane.QUESTION_MESSAGE));
        Conta c = null;
        for (Conta conta : contas) {
            if (conta.numConta == numConta) {
                c = conta;
                break;
            }
        }
        if (c == null) {
            JOptionPane.showMessageDialog(null, "Conta não encontrada.", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            return;
        }
        double valorOperacao = Double.parseDouble(JOptionPane.showInputDialog("Digite um valor para sacar:"));
        if (c.realizarSaque(valorOperacao)) {
            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!", "REALIZAR SAQUE",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar essa operação.", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, "Saldo atual: R$ " + String.format("%.2f", c.exibirSaldo()),
                "REALIZAR SAQUE", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void realizarTransferencia() {
        int numContaOrigem = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da conta de origem:",
                "REALIZAR TRANSFERÊNCIA", JOptionPane.QUESTION_MESSAGE));
        Conta cOrigem = null;
        for (Conta conta : contas) {
            if (conta.numConta == numContaOrigem) {
                cOrigem = conta;
                break;
            }
        }
        if (cOrigem == null) {
            JOptionPane.showMessageDialog(null, "Conta de origem não encontrada.", "ATENÇÃO",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        int numContaDestino = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da conta de destino:",
                "REALIZAR TRANSFERÊNCIA", JOptionPane.QUESTION_MESSAGE));
        Conta cDestino = null;
        for (Conta conta : contas) {
            if (conta.numConta == numContaDestino) {
                cDestino = conta;
                break;
            }
        }
        if (cDestino == null) {
            JOptionPane.showMessageDialog(null, "Conta de destino não encontrada.", "ATENÇÃO",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (cOrigem == cDestino) {
            JOptionPane.showMessageDialog(null,
                    "A conta de origem e destino são iguais. Transferência não permitida.", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        double valorOperacao = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite um valor para transferir:",
                "REALIZAR TRANSFERÊNCIA", JOptionPane.QUESTION_MESSAGE));
        if (cOrigem.realizarTransferencia(cDestino, valorOperacao)) {
            JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso!", "REALIZAR TRANSFERÊNCIA",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar essa operação.", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, "Saldo atual: R$ " + String.format("%.2f", cOrigem.exibirSaldo()),
                "REALIZAR TRANSFERÊNCIA", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void criarConta() {
        String nomeCliente = JOptionPane.showInputDialog(null, "Digite o nome do cliente:", "CRIAR NOVA CONTA",
                JOptionPane.QUESTION_MESSAGE);
        String cpfCliente = JOptionPane.showInputDialog(null, "Digite o CPF do cliente:", "CRIAR NOVA CONTA",
                JOptionPane.QUESTION_MESSAGE);
        Conta c = new Conta(nomeCliente, cpfCliente);
        contas.add(c);
        JOptionPane.showMessageDialog(null, c, "CONTA CRIADA", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void listarContas() {
        StringBuilder sb = new StringBuilder();
        for (Conta conta : contas) {
            sb.append("Número da conta: ").append(conta.getNumConta()).append(". ");
            sb.append("Nome do cliente: ").append(conta.getTitular().getNome()).append(". ");
            sb.append("CPF: ").append(conta.getTitular().getCpf()).append(". \n");
        }
        if (sb.length() == 0) {
            JOptionPane.showMessageDialog(null, "Não há nenhuma conta cadastrada.", "LISTA DE CONTAS",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, sb, "LISTA DE CONTAS", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private static void encerrarPrograma() {
        JOptionPane.showMessageDialog(null, "Até logo!", "CAIXA ELETRÔNICO", JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
    }

    private static void menuBanco() {
        StringBuilder sb = new StringBuilder();
        sb.append("Selecione uma das opções abaixo:").append("\n");
        sb.append("1 - Consultar conta").append("\n");
        sb.append("2 - Realizar depósito").append("\n");
        sb.append("3 - Realizar saque").append("\n");
        sb.append("4 - Realizar transferência").append("\n");
        sb.append("5 - Criar nova conta").append("\n");
        sb.append("6 - Listar todas as contas").append("\n");
        sb.append("0 - Sair").append("\n");
        sb.append("Digite a opção selecionada:");
        do {
            int opcao = Integer
                    .parseInt(JOptionPane.showInputDialog(null, sb, "CAIXA ELETRÔNICO", JOptionPane.PLAIN_MESSAGE));
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
                case 6:
                    listarContas();
                    break;
                case 0:
                    encerrarPrograma();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida", "ERRO", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (true);
    }
}
