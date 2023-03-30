import java.util.Arrays;

public class Disciplina {
    private String nomeDisciplina;
    private int horasEstudo;
    private double[] notas;
    private double media;

    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[4];
        this.media = 0;
    }

    public void cadastraHoras(int horas) {
        this.horasEstudo = horas;
    }

    public void cadastraNota(int nota, double valorNota) {
        this.notas[nota - 1] = valorNota;
    }

    public boolean aprovado() {
        double soma = 0;

        for (int i = 0; i < notas.length; i++) {
            soma += notas[i];
        }

        this.media = soma / notas.length;

        if (media >= 7.0) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return this.nomeDisciplina + " " + this.horasEstudo + " " + this.media + " " + Arrays.toString(this.notas);
    }
}
