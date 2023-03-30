public class RegistroTempoOnline {
    private String nomeDisciplina;
    private int tempoOnlineEsperado;
    private int tempoOnlineRegistrado;

    public RegistroTempoOnline(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = 120;
        this.tempoOnlineRegistrado = 0;
    }

    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
        this.tempoOnlineRegistrado = 0;
    }

    public void adicionaTempoOnline(int tempo) {
        this.tempoOnlineRegistrado += tempo;
    }

    public boolean atingiuMetaTempoOnline() {
        if (this.tempoOnlineRegistrado >= this.tempoOnlineEsperado) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return this.nomeDisciplina + " " + this.tempoOnlineRegistrado + "/" + this.tempoOnlineEsperado;
    }

}