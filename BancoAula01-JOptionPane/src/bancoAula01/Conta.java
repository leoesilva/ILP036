package bancoAula01;

public class Conta {
    private static int numeradorConta = 1;
    private int numConta;
    private Cliente titular;
    private double saldo;
    
    public Conta() {
        this.numConta = numeradorConta++;
    }

    public Conta(Cliente titular) {
        this.numConta = numeradorConta++;
        this.titular = titular;
    }

    static int getNumeradorConta() {
        return numeradorConta - 1;
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
        StringBuilder sb = new StringBuilder();
        sb.append(this.titular).append("\n");
        sb.append("Núm. conta: ").append(this.numConta).append("\n");
        sb.append("Saldo: R$ ").append(String.format("%.2f", saldo));
        return sb.toString();
    }
}
