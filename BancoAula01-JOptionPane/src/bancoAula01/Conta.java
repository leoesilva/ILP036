package bancoAula01;

public class Conta {
    protected static int numeradorConta = 0;
    protected int numConta;
    protected Cliente titular;
    protected double saldo;

    public Conta() {
        this.numConta = ++numeradorConta;
    }

    public Conta(Cliente titular) {
        this.numConta = ++numeradorConta;
        this.titular = titular;
    }

    static int getNumeradorConta() {
        return numeradorConta;
    }

    public int getNumConta() {
        return this.numConta;
    }

    public Cliente getTitular() {
        return this.titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return this.saldo;
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

    @Override
    public String toString() {
        return this.titular + "\nNúm. conta: " + this.numConta + "\nSaldo: R$ " + String.format("%.2f", this.saldo);
    }
}
