package aula01TPI;

import java.util.Scanner;

public class AppFuncionario {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Funcionario f = new Funcionario();
        
        f.codigoFunc = f.geraCodigo();
        System.out.print("Digite o nome do funcionário: ");
        f.nome = entrada.next();
        System.out.print("Digite o cargo do funcionário: ");
        f.cargo = entrada.next();
        System.out.print("Digite o salário do funcionário: ");
        f.salarioBruto = entrada.nextDouble();
        System.out.print("Digite a alíquota de INSS em %: ");
        double aliquotaInss = entrada.nextDouble();

        System.out.println(f.mostrarDados());
        
        System.out.println("Salário líquido: R$ " + f.calculaSalarioLiquido(aliquotaInss));
    }
}
