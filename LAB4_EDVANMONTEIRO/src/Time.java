import java.util.HashSet;

/**
 * A classe time apresenta um código, um nome, um mascote
 * e os campeonatos que o mesmo foi registrado
 * 
 * @author Edvan Monteiro - 121210590
 */
public class Time {
    private String codigo;
    private String nome;
    private String mascote;
    private final HashSet<Campeonato> campeonatos;

    /**
     * Construtor da classe time
     * 
     * @param codigo  Codigo do time
     * @param nome    Nome do time
     * @param mascote Mascote do time
     */
    public Time(String codigo, String nome, String mascote) {
        if (codigo == null || nome == null || mascote == null) {
            throw new NullPointerException("FALTA ALGO!");
        }
        this.codigo = codigo;
        this.nome = nome;
        this.mascote = mascote;
        this.campeonatos = new HashSet<>();
    }

    /**
     * Adiciona um campeonato a coleção
     * 
     * @param campeonato Objeto campeonato
     */
    public void adicionaCampeonato(Campeonato campeonato) {
        campeonatos.add(campeonato);
    }

    /**
     * Mostra os campeoantos que o time está presente
     * 
     * @return uma saida formatada
     */
    public String retornaCampeonatos() {
        String saida = "Campeonatos do " + nome + ":";
        for (Campeonato campeonato : campeonatos) {
            saida += "\n* " + campeonato;
        }
        return saida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Time time = (Time) o;

        return codigo.equals(time.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }

    /**
     * Formata um texto
     */
    public String toString() {
        return "[" + codigo + "] " + nome + " / " + mascote;
    }
}
