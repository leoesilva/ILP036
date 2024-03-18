package aula04TPIAtividade;

import java.util.Locale;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {

        String menu = "Controle de Disciplinas"
                + "\n\nEscolha a opção desejada:"
                + "\n\n1 - Cadastrar professor"
                + "\n2 - Cadastrar disciplina"
                + "\n3 - Pesquisar professor por disciplina"
                + "\n4 - Pesquisar professores por titulação"
                + "\n5 - Listar professores"
                + "\n6 - Listar disciplinas"
                + "\n\n0 - Sair";

        do {
            int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Sistema de Controle de Disciplinas",
                    JOptionPane.PLAIN_MESSAGE));

            switch (opcao) {
                case 1:
                    cadastrarProfessor();
                    break;
                case 2:
                    cadastrarDisciplina();
                    break;
                case 3:
                    pesquisarProfessorPorDisciplina();
                    break;
                case 4:
                    pesquisarProfessoresPorTitulacao();
                    break;
                case 5:
                    listarProfessores();
                    break;
                case 6:
                    listarDisciplinas();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Até logo!", "Sistema de Controle de Disciplinas",
                            JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!", "Sistema de Controle de Disciplinas",
                            JOptionPane.WARNING_MESSAGE);
                    break;
            }
        } while (true);
    }

    private static void cadastrarProfessor() {
        String nomeProfessor = JOptionPane.showInputDialog(null, "Digite o nome do professor:", "Cadastrar Professor",
                JOptionPane.PLAIN_MESSAGE);
        String titulacao = JOptionPane.showInputDialog(null, "Digite a titulação do professor:", "Cadastrar Professor",
                JOptionPane.PLAIN_MESSAGE);
        int cargaHorariaProfessor = Integer
                .parseInt(JOptionPane.showInputDialog(null, "Digite a carga horária do professor:",
                        "Cadastrar Professor",
                        JOptionPane.PLAIN_MESSAGE));
        new Professor(nomeProfessor, titulacao, cargaHorariaProfessor);
        JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso", "Cadastrar Professor",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private static void cadastrarDisciplina() {
        String nomeDisciplina = JOptionPane.showInputDialog(null, "Digite o nome da disciplina:",
                "Cadastrar Disciplina",
                JOptionPane.PLAIN_MESSAGE);
        int cargaHorariaDisciplina = Integer
                .parseInt(JOptionPane.showInputDialog(null, "Digite a carga horária da disciplina:",
                        "Cadastrar Disciplina",
                        JOptionPane.PLAIN_MESSAGE));
        int opcao = JOptionPane.showConfirmDialog(null, "A disciplina é ministrada por um professor já cadastrado?",
                "Cadastrar Disciplina", JOptionPane.YES_NO_OPTION);
        if (opcao == 0) {
            String nomeProfessor = JOptionPane.showInputDialog(null, "Digite o nome do professor:",
                    "Cadastrar Disciplina", JOptionPane.PLAIN_MESSAGE);
            Professor resultado = Professor.pesquisaPorNome(nomeProfessor);
            new Disciplina(nomeDisciplina, cargaHorariaDisciplina, resultado);
        } else {
            JOptionPane.showMessageDialog(null, "Será necessário cadastrar o professor.", "Cadastrar Disciplina",
                    JOptionPane.INFORMATION_MESSAGE);
            cadastrarProfessor();
            new Disciplina(nomeDisciplina, cargaHorariaDisciplina,
                    Professor.getProfessores().get(Professor.getProfessores().size() - 1));
        }
        JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso", "Cadastrar Disciplina",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private static void pesquisarProfessorPorDisciplina() {
        String nomeDisciplina = JOptionPane.showInputDialog(null, "Digite o nome da disciplina:",
                "Pesquisa de Professor por Disciplina",
                JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, Disciplina.pesquisaProfessorPorDisciplina(nomeDisciplina),
                "Pesquisar Professor por Disciplina", JOptionPane.PLAIN_MESSAGE);
    }

    private static void pesquisarProfessoresPorTitulacao() {
        String titulacao = JOptionPane.showInputDialog(null, "Digite a titulação:",
                "Pesquisa de Professores por Titulação",
                JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, Professor.pesquisaPorTitulacao(titulacao),
                "Pesquisa de Professores por Titulação",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private static void listarProfessores() {
        JOptionPane.showMessageDialog(null, Professor.getProfessores(), "Listar Professores", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void listarDisciplinas() {
        JOptionPane.showMessageDialog(null, Disciplina.getDisciplinas(), "Listar Disciplinas", JOptionPane.INFORMATION_MESSAGE);
    }
}
