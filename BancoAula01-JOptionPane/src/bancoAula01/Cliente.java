package bancoAula01;

public class Cliente {
    private static int numeradorCliente = 1;
    private int id;
    private String nome;
    private String cpf;

    public Cliente() {
        this.id = numeradorCliente++;
    }

    public Cliente(String nome) {
        this.id = numeradorCliente++;
        this.nome = nome;
    }

    public Cliente(String nome, String cpf) {
        this.id = numeradorCliente++;
        this.nome = nome;
        this.cpf = cpf;
    }

    static int getNumeradorCliente() {
        return numeradorCliente - 1;
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
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.nome).append("\n");
        sb.append("CPF: ").append(this.cpf);
        return sb.toString();
    }
}
