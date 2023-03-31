/**
 * Classe que registra resumos: o conteudo e seus temas.
 * 
 * @author Edvan Monteiro
 */
public class RegistroResumos {
    /**
     * O número de resumos que podem ser cadastrados
     */
    private int resumosCadastrados;
    /**
     * Variavel auxiliar que vai ajudar como
     * index dos resumos que vão ser cadastrados.
     */
    private int auxiliar;
    /**
     * Array com os titulos/temas dos resumos.
     */
    private String[] titulo;
    /**
     * Array com o conteúdo/texto dos resumos.
     */
    private String[] resumo;

    /**
     * Constrói um registrador de resumos com o número
     * de resumos que podem ser cadastrados e os atributos
     * como as Arrays titulo e resumo recebem o tamanho do
     * limite de resumos que podem ser cadastrados e a auxiliar
     * inicia em 0.
     * 
     * @param numeroDeResumos
     */
    public RegistroResumos(int numeroDeResumos) {
        this.resumosCadastrados = numeroDeResumos;
        this.auxiliar = 0;
        this.titulo = new String[numeroDeResumos];
        this.resumo = new String[numeroDeResumos];
    }

    /**
     * Adiciona um resumo recebendo o titulo e o conteudo dele.
     * 
     * @param tema   Tema/titulo do resumo.
     * @param resumo Conteudo/Texto do resumo.
     */
    public void adiciona(String tema, String resumo) {
        if (this.auxiliar < this.resumosCadastrados) {
            this.titulo[auxiliar] = tema;
            this.resumo[auxiliar] = resumo;
        }

        this.auxiliar += 1;
    }

    /**
     * Faz a união do resumo juntando o
     * seu titulo com o conteúdo.
     * 
     * @return Array de Strings com a junção do titulo e conteúdo do resumo.
     */
    public String[] pegaResumos() {
        String[] retornoResumo = new String[this.auxiliar];

        for (int i = 0; i < this.auxiliar; i++) {
            retornoResumo[i] = this.titulo[i] + ": " + this.resumo[i];
        }

        return retornoResumo;
    }

    /**
     * Retorna a quantidade de resumos que foram cadastrados e
     * os titulos dos mesmos.
     * 
     * @return String com a quantidade de resumos registrados e
     *         o titulo dos resumos.
     */
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

    /**
     * Retorna a quantidade de resumos cadastrados
     * 
     * @return Inteiro quando a quantidade de resumos que
     *         foram cadastrados.
     */
    public int conta() {
        return this.auxiliar;
    }

    /**
     * Retorna se o resumo existe ou não dentro
     * da Array titulo.
     * 
     * @param tema Tema/titulo a ser checado se
     *             existe na lista de titulos.
     * @return Booleana que retorna true caso ache
     *         o titulo na Array e false se não ache.
     */
    public boolean temResumo(String tema) {
        for (int i = 0; i < this.auxiliar; i++) {
            if (tema.equals(this.titulo[i])) {
                return true;
            }
        }
        return false;
    }
}
