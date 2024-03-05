package bancoAula01;

public class Cliente {
    public int id;
    public String nome;
    public String cpf;

    public Cliente() {

    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public Cliente(String nome, String cpf) {
        this.nome = nome;
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
