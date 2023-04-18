package agenda;

public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	
	private Contato[] contatos; 

	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
	}
	
	public Contato[] getContatos() {
		return this.contatos.clone();
	}

	public Contato getContato(int posicao) {
		return contatos[posicao];
	}

	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		this.contatos[posicao] = new Contato(nome, sobrenome, telefone);
	}

}
