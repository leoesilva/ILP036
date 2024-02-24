package bancoAula01;

public class Conta {
    public String nomeTitular;
    public int numConta;
    public double saldo;

    public String exibirDados() {
        return ("\nTitular: " + this.nomeTitular + "\tConta: " + this.numConta
                + "\tSaldo: R$ " + this.saldo);
    }

    public String exibirSaldo() {
        return ("\nSaldo atual: R$ " + this.saldo);
    }

    public boolean realizarSaque(double valorSaque) {
        if (valorSaque > this.saldo) {
            return false;
        } else {
            this.saldo -= valorSaque;
            return true;
        }
    }

    public void realizarDeposito(double valorDeposito) {
        this.saldo += valorDeposito;
    }
}
