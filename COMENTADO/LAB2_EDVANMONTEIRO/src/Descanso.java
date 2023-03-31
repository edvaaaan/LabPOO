/**
 * A classe descanso controla e contabiliza
 * as horas de descanso de um aluno por semana.
 * 
 * @author Edvan Monteiro
 */

public class Descanso {
    /**
     * Quantidade de horas de descanso do aluno.
     */
    private int horasDescanso;
    /**
     * Número de semanas.
     */
    private int numerosSemana;

    /**
     * Constrói um aluno que começa cansado
     * sem descanso por isso os atributos estão
     * definidos como 0.
     */
    public Descanso() {
        this.horasDescanso = 0;
        this.numerosSemana = 0;
    }

    /**
     * Define a quantidade de horas que o aluno
     * descansou.
     * 
     * @param valor Quantidade de horas de descanso.
     */
    public void defineHorasDescanso(int valor) {
        this.horasDescanso = valor;
    }

    /**
     * Define a quantidade de semanas.
     * 
     * @param valor Quantidade de semanas.
     */
    public void defineNumeroSemanas(int valor) {
        this.numerosSemana = valor;
    }

    /**
     * Retorna uma String que diz o status do aluno
     * sendo cansado ou descansado.
     * Se ele descansar mais de 26 horas por semana
     * ele vai esta descansado caso contrario ele
     * vai esta cansado.
     * 
     * @return O status que o aluno se encontra
     *         que é cansado ou descansado.
     */
    public String getStatusGeral() {
        if (this.numerosSemana == 0 || (this.horasDescanso / this.numerosSemana) < 26) {
            return "cansado";
        } else {
            return "descansado";
        }
    }
}
