import java.util.Objects;

/**
 * A classe campeonato deve ter um nome, quantidade de times no mesmo
 * e uma coleção de times.
 * 
 * @author Edvan Monteiro - 121210590
 */
public class Campeonato {
    private String nome;
    private int indice;
    private Time[] times;

    /**
     * Construtor da classe
     * 
     * @param nome     nome do campeonato
     * @param qtdTimes quantidade de times que podem participar
     */
    public Campeonato(String nome, int qtdTimes) {
        this.nome = nome;
        this.indice = 0;
        this.times = new Time[qtdTimes];
    }

    /**
     * Adiciona um time a o campeonato
     * 
     * @param time Um objeto time é adicionado
     */
    public void adicionaTime(Time time) {
        if (times[times.length - 1] != null) {
            throw new IllegalStateException("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!");
        }

        if (!timeRegistrado(time)) {
            times[indice] = time;
            indice++;
            time.adicionaCampeonato(this);
        }
    }

    /**
     * Checa se o time foi registrado ou não
     * 
     * @param time Objeto time
     * @return retorna true se tiver sido registrado com sucesso
     *         e false se não tiver sido registrado
     */
    public boolean timeRegistrado(Time time) {
        for (Time i : times) {
            if (i != null && i.equals(time)) {
                return true;
            }
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public int getTamanho() {
        return times.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Campeonato that = (Campeonato) o;
        return nome.equalsIgnoreCase(that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome.toLowerCase());
    }

    /**
     * Formata o texto
     */
    public String toString() {
        return "\n* " + nome + " - " + indice + "/" + times.length;
    }
}
