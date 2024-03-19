package bancoAula01;

public class ContaLimite extends Conta {
    private double limite;

    public ContaLimite(Cliente titular, double limite) {
        super(titular);
        this.limite = limite;
    }

    public double getLimite() {
        return this.limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public double getSaldo() {
        return this.saldo + this.limite;
    }

    @Override
    public boolean realizarSaque(double valorSaque) {
        if (valorSaque > (this.saldo + this.limite)) {
            return false;
        } else {
            this.saldo -= valorSaque;
            return true;
        }
    }

    @Override
    public boolean realizarTransferencia(Conta contaDestino, double valorTransferencia) {
        if (valorTransferencia > (this.saldo + this.limite)) {            
            return false;
        } else {
            this.realizarSaque(valorTransferencia);
            contaDestino.realizarDeposito(valorTransferencia);
            return true;
        }
    }

    @Override
    public String toString() {
        return this.titular + "\nNúm. conta: " + this.numConta + "\nSaldo: R$ " + String.format("%.2f", this.saldo)
                + "\nLimite: R$ " + String.format("%.2f", this.limite) + "\nTotal: R$ "
                + String.format("%.2f", (this.saldo + this.limite));
    }
}
