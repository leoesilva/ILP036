package bancoAula01;

public class Conta {
    public String nomeTitular;
    public int numAgencia;
    public int numConta;
    public double saldo;

    public String exibirSaldo() {
        return ("\nTitular: " + this.nomeTitular + "\tAgência: " + this.numAgencia + "\tConta: " + this.numConta
                + "\tSaldo: R$ " + this.saldo);
    }

    public void realizarSaque(double valorSaque) {
        if (valorSaque > this.saldo) {
            System.out.println("Saldo insuficiente para realizar esta operação!");
        } else {
            this.saldo -= valorSaque;
        }
    }

    public void realizarDeposito(double valorDeposito) {
        this.saldo += valorDeposito;
    }
}
