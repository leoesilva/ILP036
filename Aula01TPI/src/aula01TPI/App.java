package aula01TPI;

public class App {
    public static void main(String[] args) {
        Produto p = new Produto();
        p.codigo = 1;
        // System.out.println(p.codigo);
        p.nome = "Caderno";
        // System.out.println(p.nome);
        p.valor = 32.78;
        // System.out.println(p.valor);
        System.out.println(p.mostrarDados());
    }
}
