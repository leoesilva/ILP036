package bancoAula01;

public class Cliente {
    public static int numeradorCliente = 1;    
    public int id;
    public String nome;
    public String cpf;

    public Cliente() {

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.nome).append("\n");
        sb.append("CPF: ").append(this.cpf);
        return sb.toString();
    }
}
