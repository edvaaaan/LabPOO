/**
 * A Classe de apostas. A classe tem um time, uma colocação,
 * um valor e um campeonato para ter uma aposta valida.
 * 
 * @author Edvan Monteiro - 121210590
 */

public class Aposta {
    private Time time;
    private Campeonato campeonato;
    private double valorApostado;
    private int colocacao;

    /**
     * Construtor da classe aposta
     * 
     * @param time          nome do time
     * @param campeonato    nome do campeonato
     * @param valorApostado valor que vai ser apostado
     * @param colocacao     colocação do time
     */
    public Aposta(Time time, Campeonato campeonato, double valorApostado, int colocacao) {
        if (time == null && campeonato == null && valorApostado < 0 && colocacao < 0) {
            throw new NullPointerException("APOSTA INVALIDA!");
        } else {
            this.time = time;
            this.campeonato = campeonato;
            this.valorApostado = valorApostado;
            this.colocacao = colocacao;
        }
    }

    /**
     * Formata um texto
     */
    public String toString() {
        return time.toString() + "\n" + campeonato.getNome() + "\n" + colocacao + "/" + campeonato.getTamanho()
                + "\nR$ " + valorApostado;
    }
}
