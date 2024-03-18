package aula04TPIAtividade;

import java.util.ArrayList;

public class Disciplina {
    private String nome;
    private int cargaHoraria;
    private Professor professor;
    private static ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();

    public Disciplina(String nome, int cargaHoraria, Professor professor) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
        disciplinas.add(this);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return this.cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public static Professor pesquisaProfessorPorDisciplina(String nomeDisciplina) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getNome().equalsIgnoreCase(nomeDisciplina)) {
                return disciplina.professor;
            }
        }
        return null;
    }

    public static ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    @Override
    public String toString() {
        return "\nNome: " + this.nome + "\nCarga horária: " + cargaHoraria + "\nProfessor: " + professor;
    }
}
