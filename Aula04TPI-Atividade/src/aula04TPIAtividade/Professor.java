package aula04TPIAtividade;

import java.util.ArrayList;

public class Professor {
    private String nome;
    private String titulacao;
    private int cargaHoraria;
    private static ArrayList<Professor> professores = new ArrayList<Professor>();

    public Professor(String nome, String titulacao, int cargaHoraria) {
        this.nome = nome;
        this.titulacao = titulacao;
        this.cargaHoraria = cargaHoraria;
        professores.add(this);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulacao() {
        return this.titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public int getCargaHoraria() {
        return this.cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public static Professor pesquisaPorNome(String nomeProfessor) {
        for (Professor professor : professores) {
            if (professor.getNome().equalsIgnoreCase(nomeProfessor)) {
                return professor;
            }
        }
        return null;
    }

    public static ArrayList<Professor> pesquisaPorTitulacao(String titulacao) {
        ArrayList<Professor> resultado = new ArrayList<Professor>();
        for (Professor professor : professores) {
            if (professor.titulacao.equalsIgnoreCase(titulacao)) {
                resultado.add(professor);
            }
        }
        return resultado;
    }

    public static ArrayList<Professor> getProfessores() {
        return professores;
    }

    @Override
    public String toString() {
        return "\nNome: " + this.nome + "\nTitulação: " + this.titulacao + "\nCarga Horária: " + this.cargaHoraria;
    }
}
