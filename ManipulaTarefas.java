package br.senac.listaDeTarefa;

public class ManipulaTarefas {

    static class Tarefa {
        String descricao;
        String horaEntrada;
        String horaTermino;

        Tarefa(String descricao, String horaEntrada, String horaTermino) {
            this.descricao = descricao;
            this.horaEntrada = horaEntrada;
            this.horaTermino = horaTermino;
        }

        int duracaoEmHoras() {
            int horaEntradaInt = Integer.parseInt(horaEntrada.split(":")[0]);
            int horaTerminoInt = Integer.parseInt(horaTermino.split(":")[0]);
            return horaTerminoInt - horaEntradaInt;
        }
    }

    static Tarefa criarTarefa(String descricao, String horaEntrada, String horaTermino) {
        return new Tarefa(descricao, horaEntrada, horaTermino);
    }

    static int calcularTempoLivre(Tarefa tarefa) {
        int tempoTotal = 8; // Jornada de 8 horas
        int tempoOcupado = tarefa.duracaoEmHoras();
        return tempoTotal - tempoOcupado;
    }

    static void imprimirDetalhesTarefa(Tarefa tarefa) {
        System.out.println("Detalhes da Tarefa:");
        System.out.println("Descrição: " + tarefa.descricao);
        System.out.println("Hora de entrada: " + tarefa.horaEntrada);
        System.out.println("Hora de término: " + tarefa.horaTermino);
    }

    static void imprimirTempoLivre(int tempoLivre) {
        System.out.println("Tempo livre: " + tempoLivre + " horas");
        boolean temTempoLivre = tempoLivre > 0;
        System.out.println("Tem tempo livre? " + temTempoLivre);
    }

    public static void main(String[] args) {
        // Criando uma tarefa
        Tarefa tarefa = criarTarefa("Limpar casa", "15:00", "17:00");

        // Imprimindo os detalhes da tarefa
        imprimirDetalhesTarefa(tarefa);

        // Calculando o tempo livre e imprimindo-o
        int tempoLivre = calcularTempoLivre(tarefa);
        imprimirTempoLivre(tempoLivre);
    }
}
