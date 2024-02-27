package bancoAula01;

public class Conta {
    public String nomeTitular;
    public int numConta;
    public double saldo;

    public String exibirDados() {
        return ("\nTitular: " + this.nomeTitular + "\tConta: " + this.numConta
                + "\tSaldo: R$ " + String.format("%.2f", this.exibirSaldo()));
    }

    public double exibirSaldo() {
        return this.saldo;
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

    public boolean realizarTransferencia(Conta contaDestino, double valorTransferencia) {
        if (valorTransferencia > this.saldo) {            
            return false;
        } else {
            this.realizarSaque(valorTransferencia);
            contaDestino.realizarDeposito(valorTransferencia);
            return true;
        }
    }
}
