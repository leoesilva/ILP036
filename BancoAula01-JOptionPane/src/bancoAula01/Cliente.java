package bancoAula01;

public class Cliente {
    private static int numeradorCliente = 0;
    private int id;
    private String nome;
    private String cpf;

    public Cliente() {
        this.id = ++numeradorCliente;
    }

    public Cliente(String nome) {
        this.id = ++numeradorCliente;
        this.nome = nome;
    }

    public Cliente(String nome, String cpf) {
        this.id = ++numeradorCliente;
        this.nome = nome;
        this.cpf = cpf;
    }

    static int getNumeradorCliente() {
        return numeradorCliente;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "\nNome: " + this.nome + "\nCPF: " + this.cpf;
    }
}
