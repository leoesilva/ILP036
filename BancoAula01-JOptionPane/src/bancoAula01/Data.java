package bancoAula01;

public class Data {
    public int dia;
    public int mes;
    public int ano;

    public Data() {

    }

    public Data(int d, int m, int a) {
        this.dia = d;
        this.mes = m;
        this.ano = a;
    }

    @Override
    public String toString() {
        return this.dia + "/" + this.mes + "/" + this.ano;
    }
}
