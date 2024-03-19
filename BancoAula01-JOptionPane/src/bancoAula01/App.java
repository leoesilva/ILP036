package bancoAula01;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class App {
    public static ArrayList<Conta> contas = new ArrayList<Conta>();

    public static void main(String[] args) {
        String menu = "Selecione uma das opções abaixo:"
        + "\n\n1 - Consultar conta"
        + "\n2 - Realizar depósito"
        + "\n3 - Realizar saque"
        + "\n4 - Realizar transferência"
        + "\n5 - Criar nova conta"
        + "\n6 - Listar todas as contas"
        + "\n7 - Testes Funcionário e Gerente"
        + "\n0 - Sair"
        + "\n\nDigite a opção selecionada:";
        do {
            int opcao = Integer
                    .parseInt(JOptionPane.showInputDialog(null, menu));
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
                case 7:
                    testesFuncionarioGerente();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Até logo!");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    break;
            }
        } while (true);
    }

    private static void consultarConta() {
        int numConta = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da conta:"));
        Conta c = null;
        for (Conta conta : contas) {
            if (conta.getNumConta() == numConta) {
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
        int numConta = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da conta:"));
        Conta c = null;
        for (Conta conta : contas) {
            if (conta.getNumConta() == numConta) {
                c = conta;
                break;
            }
        }
        if (c == null) {
            JOptionPane.showMessageDialog(null, "Conta não encontrada.");
            return;
        }
        double valorOperacao = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite um valor para depositar:"));
        c.realizarDeposito(valorOperacao);
        JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!");
    }

    private static void realizarSaque() {
        int numConta = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da conta:"));
        Conta c = null;
        for (Conta conta : contas) {
            if (conta.getNumConta() == numConta) {
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
            JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar essa operação.");
        }
        JOptionPane.showMessageDialog(null, "Saldo atual: R$ " + String.format("%.2f", c.exibirSaldo()));
    }

    private static void realizarTransferencia() {
        int numContaOrigem = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da conta de origem:"));
        Conta cOrigem = null;
        for (Conta conta : contas) {
            if (conta.getNumConta() == numContaOrigem) {
                cOrigem = conta;
                break;
            }
        }
        if (cOrigem == null) {
            JOptionPane.showMessageDialog(null, "Conta de origem não encontrada.");
            return;
        }
        int numContaDestino = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da conta de destino:"));
        Conta cDestino = null;
        for (Conta conta : contas) {
            if (conta.getNumConta() == numContaDestino) {
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
                    "A conta de origem e destino são iguais. Transferência não permitida.");
            return;
        }
        double valorOperacao = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite um valor para transferir:"));
        if (cOrigem.realizarTransferencia(cDestino, valorOperacao)) {
            JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar essa operação.");
        }
        JOptionPane.showMessageDialog(null, "Saldo atual: R$ " + String.format("%.2f", cOrigem.exibirSaldo()));
    }

    private static void criarConta() {
        String nomeCliente = JOptionPane.showInputDialog(null, "Digite o nome do cliente:");
        String cpfCliente = JOptionPane.showInputDialog(null, "Digite o CPF do cliente:");
        Conta c = null;
        int tipoConta = Integer.parseInt(
                JOptionPane.showInputDialog(null, "Escolha o tipo de conta:\n\n1 - Conta Corrente\n2 - Conta Limite"));
        if (tipoConta == 1) {
            Conta cc = new ContaCorrente(new Cliente(nomeCliente, cpfCliente));
            c = cc;
        } else if (tipoConta == 2) {
            Conta cl = new ContaLimite(new Cliente(nomeCliente, cpfCliente), 200);
            c = cl;
        } else {
            JOptionPane.showMessageDialog(null, "Opção inválida");
            return;
        }
        contas.add(c);
        JOptionPane.showMessageDialog(null, c);
        int depinicial = JOptionPane.showConfirmDialog(null, "Deseja realizar um depósito inicial?");
        if (depinicial == 0) {
            double valorOperacao = Double
                    .parseDouble(JOptionPane.showInputDialog(null, "Digite um valor para depositar:"));
            c.realizarDeposito(valorOperacao);
            JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!");
        } else {
            return;
        }
    }

    private static void listarContas() {
        String lista = "Quantidade de contas cadastradas: " + Conta.getNumeradorConta()+ "\n";
        for (Conta conta : contas) {
            lista += "\nNúmero da conta: " + conta.getNumConta()
            + "\nNome do cliente: " + conta.getTitular().getNome()
            + "\nCPF: " + conta.getTitular().getCpf()
            + "\nTotal: R$ " + String.format("%.2f", conta.getSaldo()) + "\n";
        }
        if (Conta.getNumeradorConta() == 0) {
            JOptionPane.showMessageDialog(null, "Não há nenhuma conta cadastrada.");
        } else {
            JOptionPane.showMessageDialog(null, lista);
        }
    }

    private static void testesFuncionarioGerente() {
        Funcionario f = new Funcionario("Nelson", "11111111111", 1420);
        Gerente g = new Gerente("Croc", "22222222222", 14200, 1234);
        g.setNumeroFuncionariosGerenciados(1);
        JOptionPane.showMessageDialog(null, f + "\n" + g);
    }
}
