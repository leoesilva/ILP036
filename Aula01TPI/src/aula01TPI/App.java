package aula01TPI;

import java.util.Scanner;

public class App {

    public static Scanner entrada = new Scanner(System.in);
    public static Produto p = new Produto();
    public static Funcionario f = new Funcionario();

    public static void main(String[] args) {
        cadastraProduto();
        cadastraFuncionario();
        menuOpcoes();
    }

    private static void cadastraProduto() {
        p.codigo = p.geraCodigo();
        p.nome = "Caneta";
        p.valor = 2.50;
    }

    private static void cadastraFuncionario() {
        f.codigoFunc = f.geraCodigo();
        f.nome = "Luis";
        f.cargo = "Vigia";
        f.salarioBruto = 2500.00;
    }

    private static void dadosProduto() {
        System.out.println(p.mostrarDados());
    }

    private static void totalCompra() {
        System.out.print("Digite a quantidade do produto: ");
        int quantidade = entrada.nextInt();
        System.out.println("Valor total: R$ " + String.format("%.2f", p.calcularTotal(quantidade)));
    }

    private static void dadosFuncionario() {
        System.out.println(f.mostrarDados());
    }

    private static void salarioLiquido() {
        System.out.print("Digite o percentual da alíquota de INSS: ");
        double aliquotaInss = entrada.nextDouble();
        System.out.println("Salário líquido: R$ " + String.format("%.2f", f.calculaSalarioLiquido(aliquotaInss)));
    }

    private static void encerraPrograma() {
        entrada.close();
        System.out.println("Programa finalizado");
        System.exit(0);
    }

    private static void menuOpcoes() {
        do {
            System.out.println("**\tMenu principal\t**");
            System.out.println("Selecione uma das opções abaixo:");
            System.out.println("\t\t 1 - Mostrar dados do produto");
            System.out.println("\t\t 2 - Calcular total da compra");
            System.out.println("\t\t 3 - Mostrar dados do funcionário");
            System.out.println("\t\t 4 - Calcular salário líquido do funcionário");
            System.out.println("\t\t 0 - Sair");
            System.out.print("Digite a opção: ");
            int opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    dadosProduto();
                    break;
                case 2:
                    totalCompra();
                    break;
                case 3:
                    dadosFuncionario();
                    break;
                case 4:
                    salarioLiquido();
                    break;
                case 0:
                    encerraPrograma();
                    break;
                default:
                    System.out.println("ERRO! Opção inválida.");
                    break;
            }
        } while (true);
    }
}
