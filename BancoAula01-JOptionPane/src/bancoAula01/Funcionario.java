package bancoAula01;

public class Funcionario {
    protected String nome;
    protected String cpf;
    protected double salario;

    public Funcionario() {

    }

    public Funcionario(String nomeFuncionario, String cpfFuncionario) {
        this.nome = nomeFuncionario;
        this.cpf = cpfFuncionario;
    }

    public Funcionario(String nomeFuncionario, String cpfFuncionario, double salarioFuncionario) {
        this.nome = nomeFuncionario;
        this.cpf = cpfFuncionario;
        this.salario = salarioFuncionario;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nomeFuncionario) {
        this.nome = nomeFuncionario;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpfFuncionario) {
        this.cpf = cpfFuncionario;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salarioFuncionario) {
        this.salario = salarioFuncionario;
    }

    public double getBonificacao() {
        return this.salario * 0.10;
    }

    @Override
    public String toString() {
        return "\nNome: " + this.nome + "\nCPF: " + this.cpf + "\nSalário: R$ " + String.format("%.2f", this.salario);
    }
}
