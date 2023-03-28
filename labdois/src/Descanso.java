public class Descanso {
    private int horasDescanso;
    private int numerosSemana;

    public Descanso() {
        this.horasDescanso = 0;
        this.numerosSemana = 0;
    }

    public void defineHorasDescanso(int valor) {
        this.horasDescanso = valor;
    }

    public void defineNumeroSemanas(int valor) {
        this.numerosSemana = valor;
    }

    public String getStatusGeral() {
        if(this.numerosSemana == 0 || (this.horasDescanso / this.numerosSemana) < 26 ) {
            return "cansado";
        } else {
            return "descansado";
        }
    }
}
