package bancoAula01;

public class Conta {
    public int numConta;
    public Cliente titular = new Cliente();
    public double saldo;
    
    public Conta() {

    }

    public Conta(int numConta, String nomeCliente, String cpfCliente) {
        this.numConta = numConta;
        this.titular = new Cliente(nomeCliente, cpfCliente);
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
