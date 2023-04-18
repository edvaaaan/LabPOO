package agenda;

public class Contato {
    private String nomes;
    private String sobrenomes;
    private String numeros; 

    public Contato(String nomes, String sobrenomes, String numeros) {
        this.nomes = nomes;
        this.sobrenomes = sobrenomes;
        this.numeros = numeros;
    }

    public String getNome() {
        return this.nomes;
    }

    public String getSobrenome() {
        return this.sobrenomes;
    }

    public String getNumeros() {
        return this.numeros;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }

        Contato oContato = (Contato) o;
        if (this.nomes.equals(oContato.nomes) && this.sobrenomes.equals(oContato.sobrenomes)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.nomes + " " + this.sobrenomes + "\n" + this.numeros;
    } 
}
