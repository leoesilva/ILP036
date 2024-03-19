package bancoAula01;

public class Gerente extends Funcionario {
    private int senha;
    private int numeroFuncionariosGerenciados;

    public Gerente(String nomeGerente, String cpfGerente, int senhaGerente) {
        this.nome = nomeGerente;
        this.cpf = cpfGerente;
        this.senha = senhaGerente;
    }

    public Gerente(String nomeGerente, String cpfGerente, double salarioGerente, int senhaGerente) {
        this.nome = nomeGerente;
        this.cpf = cpfGerente;
        this.salario = salarioGerente;
        this.senha = senhaGerente;
    }

    public int getNumeroFuncionariosGerenciados() {
        return this.numeroFuncionariosGerenciados;
    }

    public void setNumeroFuncionariosGerenciados(int numeroFuncionariosGerenciados) {
        this.numeroFuncionariosGerenciados = numeroFuncionariosGerenciados;
    }

    public double getBonificacao() {
        return super.getBonificacao() + 1000;
    }

    public boolean autentica(int senhaGerente) {
        if (this.senha == senhaGerente) {
            return true;
        } else {
            return false;
        }
    }

    public boolean alterarSenha(int senhaAtual, int senhaNova) {
        if (autentica(senhaAtual)) {
            this.senha = senhaNova;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "\nNome: " + this.nome + "\nCPF: " + this.cpf + "\nSalário: R$ " + String.format("%.2f", this.salario)
                + "\nNº de func. gerenciados: " + this.numeroFuncionariosGerenciados;
    }

}
