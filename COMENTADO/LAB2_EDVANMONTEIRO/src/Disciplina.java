import java.util.Arrays;

/**
 * A classe representa um disciplina que guarda
 * informações da mesma como o nome, horas de estudo
 * notas e a media das notas.
 * 
 * @author Edvan Monteiro
 */
public class Disciplina {
    /**
     * Nome da disciplina.
     */
    private String nomeDisciplina;
    /**
     * Horas de estudo na disciplina.
     */
    private int horasEstudo;
    /**
     * Array com as notas da disciplina.
     */
    private double[] notas;
    /**
     * A media das notas na disciplina.
     */
    private double media;

    /**
     * Constrói uma disciplina com o nome e define
     * os atributos hora e média como 0 e a Array de notas
     * com o tamanho 4 para as notas que ela vai receber.
     * 
     * @param nomeDisciplina Nome da disciplina
     */
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[4];
        this.media = 0;
    }

    /**
     * Cadastra as horas de estudo da disciplina.
     * 
     * @param horas Horas de estudo na disciplina.
     */
    public void cadastraHoras(int horas) {
        this.horasEstudo = horas;
    }

    /**
     * Cadastra as notas da disciplina na Array.
     * 
     * @param nota      Index da nota a ser cadastrada.
     * @param valorNota O valor da nota a ser cadastrada.
     */
    public void cadastraNota(int nota, double valorNota) {
        this.notas[nota - 1] = valorNota;
    }

    /**
     * Calcula a media e retorna a situção do aluno
     * podendo ser aprovado (true) ou reprovado (false).
     * 
     * @return Retorna a aprovação ou reprovação do aluno.
     */
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

    /**
     * Retorna todos os dados da disciplina
     * nome, horas de estudo, media e notas.
     * 
     * @return String com os atributos da disciplina.
     */
    public String toString() {
        return this.nomeDisciplina + " " + this.horasEstudo + " " + this.media + " " + Arrays.toString(this.notas);
    }
}
