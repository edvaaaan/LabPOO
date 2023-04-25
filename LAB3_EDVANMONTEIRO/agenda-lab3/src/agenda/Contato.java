package agenda;

/**
 * A classe Contato cria contatos
 * para serem adicionados a uma agenda
 * eles tem nome, sobrenome e um numero.
 * 
 * @author Edvan Monteiro - 121210590
 */

public class Contato {
    /**
     * nome da pessoa
     */
    private String nome;
    /**
     * sobrenome da pessoa
     */
    private String sobrenome;
    /**
     * numero da pessoa
     */
    private String numero;

    /**
     * Construtor constroi um
     * contato novo
     * 
     * @param nome      nome de uma pessoa
     * @param sobrenome sobrenome de uma pessoa
     * @param numero    numero de uma pessoa
     */
    public Contato(String nome, String sobrenome, String numero) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numero = numero;
    }

    /**
     * o metodo get
     * 
     * @return retorna o nome da pessoa
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * o metodo get
     * 
     * @return retorna o sobrenome da pessoa
     */
    public String getSobrenome() {
        return this.sobrenome;
    }

    /**
     * metodo equals
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }

        Contato oContato = (Contato) o;
        if (this.nome.equals(oContato.nome) && this.sobrenome.equals(oContato.sobrenome)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * metodo toString
     */
    @Override
    public String toString() {
        return this.nome + " " + this.sobrenome + "\n" + this.numero;
    }
}
