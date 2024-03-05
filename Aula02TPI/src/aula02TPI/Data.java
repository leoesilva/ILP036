package aula02TPI;

public class Data {
    public int dia;
    public int mes;
    public int ano;

    public void defineDia(int d) {
        this.dia = d;
    }

    public void defineMes(int m) {
        this.mes = m;
    }

    public void defineAno(int a) {
        this.ano = a;
    }

    public String exibeData() {
        return this.dia + "/" + this.mes + "/" + this.ano;
    }
}
