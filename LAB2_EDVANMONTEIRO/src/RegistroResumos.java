public class RegistroResumos {
    private int resumosCadastrados;
    private int auxiliar;
    private String[] titulo;
    private String[] resumo;

    public RegistroResumos(int numeroDeResumos) {
        this.resumosCadastrados = numeroDeResumos;
        this.auxiliar = 0;
        this.titulo = new String[numeroDeResumos];
        this.resumo = new String[numeroDeResumos];
    }

    public void adiciona(String tema, String resumo) {
        if (this.auxiliar < this.resumosCadastrados) {
            this.titulo[auxiliar] = tema;
            this.resumo[auxiliar] = resumo;
        }

        this.auxiliar += 1;
    }

    public String[] pegaResumos() {
        String[] retornoResumo = new String[this.auxiliar];

        for (int i = 0; i < this.auxiliar; i++) {
            retornoResumo[i] = this.titulo[i] + ": " + this.resumo[i];
        }

        return retornoResumo;
    }

    public String imprimeResumos() {
        String retornoDados = "- " + this.auxiliar + " resumo(s) cadastrado(s)\n" + "-";

        for (int i = 0; i < this.auxiliar; i++) {
            if (i == (this.auxiliar - 1)) {
                retornoDados += " " + this.titulo[i];
            } else {
                retornoDados += " " + this.titulo[i] + " |";
            }
        }
        return retornoDados;
    }

    public int conta() {
        return this.auxiliar;
    }

    public boolean temResumo(String tema) {
        for (int i = 0; i < this.auxiliar; i++) {
            if (tema.equals(this.titulo[i])) {
                return true;
            }
        }
        return false;
    }
}
