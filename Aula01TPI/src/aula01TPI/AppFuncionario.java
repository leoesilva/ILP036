package aula01TPI;

public class AppFuncionario {
    public static void main(String[] args) {
        Funcionario f = new Funcionario();
        double aliquotaInss = 12;
        f.codigoFunc = 1;
        f.nome = "Toninho";
        f.cargo = "Zelador";
        f.salarioBruto = 2824.00;

        System.out.println(f.mostrarDados());
        
        System.out.println("Salário líquido: R$ " + f.calculaSalarioLiquido(aliquotaInss));
    }
}
