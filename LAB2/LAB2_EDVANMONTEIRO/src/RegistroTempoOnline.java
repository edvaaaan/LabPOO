/**
 * Classe que registra o tempo online que o aluno
 * tem se dedicado a disciplina remotamente.
 * 
 * @author Edvan Monteiro
 */
public class RegistroTempoOnline {
    /**
     * Nome da disciplina
     */
    private String nomeDisciplina;
    /**
     * Tempo online que é esperado
     * para a dedicação do aluno na disciplina.
     */
    private int tempoOnlineEsperado;
    /**
     * Tempo online que o aluno se dedicou a disciplina.
     */
    private int tempoOnlineRegistrado;

    /**
     * Constrói a disciplina com seu nome e os atributos
     * tempo esperado inicia em 120 que é o padrão que esperamos
     * que o aluno se dedique e o registrado inicia em 0.
     * 
     * @param nomeDisciplina Nome da disciplina.
     */
    public RegistroTempoOnline(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = 120;
        this.tempoOnlineRegistrado = 0;
    }

    /**
     * Constrói a disciplina com o seu nome e o atributo
     * tempo esperado agora vai receber um valor personalizado
     * e o registrado inicia em 0
     * 
     * @param nomeDisciplina      Nome da disciplina.
     * @param tempoOnlineEsperado Tempo que esperamos
     *                            de dedicação para disciplina.
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
        this.tempoOnlineRegistrado = 0;
    }

    /**
     * Adiciona o tempo que foi dedicado a estudo
     * da disciplina.
     * 
     * @param tempo Tempo que foi dedicado
     *              a o estudo na disciplina.
     */
    public void adicionaTempoOnline(int tempo) {
        this.tempoOnlineRegistrado += tempo;
    }

    /**
     * Retorna se o aluno atingiu ou não a meta de
     * dedicação para disciplina.
     * 
     * @return Booleana que é retornada como true se
     *         o aluno atingiu a meta de dedicação e como false
     *         se ele não conseguiu atingir a meta.
     */
    public boolean atingiuMetaTempoOnline() {
        if (this.tempoOnlineRegistrado >= this.tempoOnlineEsperado) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Retorna um String mostrando o nome da disciplina
     * e o progresso com as horas que ele se dedicou e a meta.
     * 
     * @return String com o nome da disciplina, horas de dedicação
     *         e horas esperadas de dedicação do aluno.
     */
    public String toString() {
        return this.nomeDisciplina + " " + this.tempoOnlineRegistrado + "/" + this.tempoOnlineEsperado;
    }
}
