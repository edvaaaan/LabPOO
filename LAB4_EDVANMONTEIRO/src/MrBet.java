import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Classe principal do sistema que controla times, campeonatos e apostas.
 * 
 * @author Edvan Monteiro - 121210590
 */
public class MrBet {
    private final HashMap<String, Time> times;
    private final HashSet<Campeonato> campeonatos;
    private final ArrayList<Aposta> apostas;

    /**
     * Construtor da classe
     */
    public MrBet() {
        this.times = new HashMap<>();
        this.campeonatos = new HashSet<>();
        this.apostas = new ArrayList<>();
    }

    /**
     * Cria um time e adiciona ao hashmap de times.
     * 
     * @param codigo  Codigo do time
     * @param nome    Nome do time
     * @param mascote Mascote do time
     * @return Retorna se ele existe ou se conseguiu incluir o mesmo.
     */
    public String incluiTime(String codigo, String nome, String mascote) {
        if (times.containsKey(codigo)) {
            throw new IllegalArgumentException("TIME JÁ EXISTE!");
        } else {
            Time time = new Time(codigo, nome, mascote);
            times.put(codigo, time);
            return "INCLUSÃO REALIZADA!";
        }
    }

    /**
     * Recupera um time existente
     * 
     * @param codigo Codigo do time
     * @return Diz se o time não existe ou retorna o time
     */
    public String recuperaTime(String codigo) {
        if (!times.containsKey(codigo)) {
            throw new NoSuchElementException("TIME NÃO EXISTE!");
        } else {
            return times.get(codigo).toString();
        }
    }

    /**
     * 
     * @param nome
     * @param qtdTimes
     * @return
     */
    public String adicionaCampeonato(String nome, int qtdTimes) {
        Campeonato campeonato = new Campeonato(nome, qtdTimes);
        if (!campeonatos.add(campeonato)) {
            return "CAMPEONATO JÁ EXISTE!";
        } else {
            campeonatos.add(campeonato);
            return "CAMPEONATO ADICIONADO!";
        }
    }

    public Campeonato getCampeonato(String nome) {
        Campeonato campeonato2 = new Campeonato(nome, 0);
        for (Campeonato c2 : campeonatos) {
            if (c2.getNome().equals(nome)) {
                return campeonato2;
            }
        }
        return null;
    }

    public Time getTime(String codigo) {
        if (times.containsKey(codigo)) {
            return times.get(codigo);
        }
        return null;
    }

    /**
     * Adiciona um time a um campeonato
     * 
     * @param codigo     Codigo do time
     * @param campeonato Nome do Campeonato
     * @return Retorna se o time foi adicionado ou não.
     */
    public String incluiTimeCampeonato(String codigo, String campeonato) {
        if (!times.containsKey(codigo)) {
            throw new NoSuchElementException("TIME NÃO EXISTE!");
        }

        Campeonato campeonato2 = getCampeonato(campeonato);
        if (campeonato2 == null) {
            throw new NoSuchElementException("CAMPEONATO NÃO EXISTE!");
        }

        campeonato2.adicionaTime(times.get(codigo));
        return "TIME INCLUÍDO NO CAMPEONATO!";
    }

    /**
     * Verifica se o time está no campeonato ou não
     * 
     * @param codigo     Codigo do time
     * @param campeonato Nome do Campeonato
     * @return Retorna se o time está no campeonato ou não
     */
    public String verificaTimeCampeonato(String codigo, String campeonato) {
        if (!times.containsKey(codigo)) {
            throw new NoSuchElementException("TIME NÃO EXISTE!");
        }

        Campeonato campeonato2 = getCampeonato(campeonato);
        if (campeonato2 == null) {
            throw new NoSuchElementException("CAMPEONATO NÃO EXISTE!");
        }

        if (campeonato2.timeRegistrado(null)) {
            return "O TIME NÃO ESTÁ NO CAMPEONATO!";
        } else {
            return "O TIME ESTÁ NO CAMPEONATO!";
        }
    }

    /**
     * Cria uma aposta
     * 
     * @param codigo     Codigo do time que quer apostar
     * @param campeonato Campeonato que quer apostar
     * @param colocacao  A colocação final do time
     * @param valor      O valor a ser apostado
     * @return Diz se a aposta foi registrada ou não.
     */
    public String criaAposta(String codigo, String campeonato, int colocacao, double valor) {
        Time time = getTime(codigo);
        Campeonato campeonato2 = getCampeonato(campeonato);
        Aposta aposta;

        if (!times.containsKey(codigo)) {
            throw new NoSuchElementException("APOSTA NÃO REGISTRADA!");
        }

        if (campeonato2 == null) {
            throw new NoSuchElementException("APOSTA NÃO REGISTRADA!");
        }

        if (colocacao > campeonato2.getTamanho()) {
            throw new NoSuchElementException("APOSTA NÃO REGISTRADA!");
        }

        aposta = new Aposta(time, campeonato2, valor, colocacao);
        apostas.add(aposta);

        return "APOSTA REGISTRADA!";
    }

    /**
     * Formata um texto
     * 
     * @return String formatada em uma saida
     */
    public String mostraAposta() {
        String saida = "Apostas:\n";
        int aux = 0;
        for (Aposta i : apostas) {
            saida += (aux + 1) + ". " + i + "\n";
        }
        return saida;
    }

}
