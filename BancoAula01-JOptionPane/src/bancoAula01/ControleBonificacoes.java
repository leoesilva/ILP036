package bancoAula01;

class ControleBonificacoes {
    private double totalBonificacoes = 0;

    public void registra(Funcionario funcionario) {
        this.totalBonificacoes += funcionario.getBonificacao();
    }

    public double getTotalDeBonificacoes() {
        return this.totalBonificacoes;
    }
}
