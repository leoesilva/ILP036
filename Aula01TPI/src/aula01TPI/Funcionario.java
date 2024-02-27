package aula01TPI;

public class Funcionario {
    public int codigoFunc;
    public String nome;
    public String cargo;
    public double salarioBruto;

    public int geraCodigo() {
        int max = 100;
        int min = 1;
        int range = max - min + 1;
        int cod = (int)(Math.random() * range) + min;
        return cod;
    }

    public String mostrarDados() {
        return ("\nCódigo: " + this.codigoFunc + "\tNome: " + this.nome + "\tCargo: " + this.cargo
                + "\tSalário bruto: R$ " + String.format("%.2f", this.salarioBruto));
    }

    public double calculaSalarioLiquido(double percentualDescontoInss) {
        double salarioLiquido = this.salarioBruto - (this.salarioBruto * (percentualDescontoInss / 100));
        return salarioLiquido;
    }
}
