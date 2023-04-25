package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100
 * contatos.
 * 
 * @author nazareno
 *
 */
public class Agenda {

	/**
	 * tamanho da agenda
	 */
	private static final int TAMANHO_AGENDA = 100;

	/**
	 * armazena os contados criados
	 */
	private Contato[] contatos;

	/**
	 * armazena os contatos favoritados
	 */
	private Contato[] favoritos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[10];
	}

	/**
	 * Acessa a lista de contatos mantida.
	 * 
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}

	/**
	 * Acessa a lista de contatos favoritos
	 * 
	 * @return O array de contatos favoritos
	 */
	public Contato[] getFavoritos() {
		return this.favoritos.clone();
	}

	/**
	 * Acessa os dados de um contato específico.
	 * 
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public Contato getContato(int posicao) {
		if (this.contatos[posicao - 1] == null || posicao > 100 || posicao < 0) {
			throw new IllegalArgumentException("\nPOSIÇÃO INVÁLIDA");
		} else {
			return this.contatos[posicao - 1];
		}
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe
	 * sobrescreve o anterior.
	 * 
	 * @param posicao   Posição do contato.
	 * @param nome      Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone  Telefone do contato.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		verificaContato(posicao, nome, sobrenome, telefone);
		this.contatos[posicao - 1] = new Contato(nome, sobrenome, telefone);
	}

	/**
	 * vai verificar a existencia do contato
	 * se a posição que ta sendo registrada
	 * não é maior que 100 ou menor que 0
	 * e se os nomes não estão vazios
	 * 
	 * @param posicao   Posição do contato.
	 * @param nome      Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone  Telefone do contato.
	 */
	private void verificaContato(int posicao, String nome, String sobrenome, String telefone) {
		if (posicao < 0 || posicao > 100) {
			throw new IllegalArgumentException("\nPOSIÇÃO INVÁLIDA");
		}

		if (nome.isEmpty() || telefone.isEmpty()) {
			throw new IllegalArgumentException("\nCONTATO INVÁLIDO");
		}

		Contato testeContato = new Contato(nome, sobrenome, telefone);
		for (Contato con : this.contatos) {
			if (con != null) {
				if (con.equals(testeContato)) {
					throw new IllegalArgumentException("\nCONTATO JÁ CADASTRADO");
				}
			}
		}
	}

	/**
	 * Verifica se o contato ta favoritado ou nao
	 * 
	 * @param favoritoPosicao posição do contato favoritado
	 * @param posicao         posição do contato na agenda
	 */
	private void verificaFavorito(int favoritoPosicao, int posicao) {
		Contato testeContato = this.contatos[favoritoPosicao - 1];

		for (Contato fav : this.favoritos) {
			if (fav != null) {
				if (fav.equals(testeContato)) {
					throw new IllegalArgumentException("\nO CONTATO JÁ SE ENCONTRA NOS FAVORITOS");
				}
			}
		}

		if (posicao < 0 || posicao > 100) {
			throw new IllegalArgumentException("\nPOSIÇÃO INVÁLIDA");
		}
	}

	/**
	 * adicionar um contato a lista de favoritos
	 * 
	 * @param contato o contato a ser adicionado
	 * @param posicao a posicao na lista de adicionados
	 */
	public void adicionaFavorito(int contato, int posicao) {
		verificaFavorito(contato, posicao);
		this.favoritos[posicao - 1] = this.getContato(contato);
	}

	/**
	 * remove um contato ja favoritado
	 * 
	 * @param posicao a posiçao na lista de favoritos
	 *                a ser removida
	 */
	public void removeFavorito(int posicao) {
		this.favoritos[posicao - 1] = null;
	}
}
