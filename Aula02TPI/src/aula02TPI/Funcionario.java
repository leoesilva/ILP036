package aula02TPI;

public class Funcionario {
    public String nome;
    public String departamento;
    public double salario;
    public Data admissao = new Data();
    public String rg;

    public void recebeAumento(double percAumento) {
        this.salario += (this.salario * (percAumento/100));
    }

    public double calculaGanhoAnual() {
        return this.salario * 12;
    }
}
