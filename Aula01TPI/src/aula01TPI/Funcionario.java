package aula01TPI;

public class Funcionario {
    public int codigoFunc;
    public String nome;
    public String cargo;
    public double salarioBruto;

    public String mostrarDados() {
        return ("\nCódigo: " + this.codigoFunc + "\tNome: " + this.nome + "\tCargo: " + this.cargo
                + "\tSalário bruto: R$ " + this.salarioBruto);
    }

    public double calculaSalarioLiquido(double percentualDescontoInss) {
        return this.salarioBruto - (this.salarioBruto * (percentualDescontoInss / 100));
    }
}
