package bancoAula01;

public class Funcionario {
    public String nome;
    public String departamento;
    public double salario;
    public Data admissao = new Data();
    public String rg;

    public Funcionario() {

    }

    public Funcionario(String nomeFuncionario, String rgFuncionario) {
        this.nome = nomeFuncionario;
        this.rg = rgFuncionario;
    }

    public Funcionario(String nomeFuncionario, String deptoFuncionario, double salarioFuncionario, int diaAdmissao,
            int mesAdmissao, int anoAdmissao, String rgFuncionario) {
                this.nome = nomeFuncionario;
                this.departamento = deptoFuncionario;
                this.admissao = new Data(diaAdmissao, mesAdmissao, anoAdmissao);
                this.rg = rgFuncionario;
    }

    public void recebeAumento(double percAumento) {
        this.salario += (this.salario * (percAumento / 100));
    }

    public double calculaGanhoAnual() {
        return this.salario * 12;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.nome).append("\n");
        sb.append("Departamento: ").append(this.departamento).append("\n");
        sb.append("Salário: R$ ").append(String.format("%.2f", this.salario)).append("\n");
        sb.append("Data de admissão: ").append(this.admissao).append("\n");
        sb.append("RG: ").append(this.rg);
        return sb.toString();
    }
}
