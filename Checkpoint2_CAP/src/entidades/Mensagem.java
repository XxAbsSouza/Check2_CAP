package entidades;

public class Mensagem {
	private String nome;
	private String emailTelefone;
	private int motivoContato;
	private String mensagem;
	
	public Mensagem(String emailTelefone, int motivoContato, String mensagem){
		this.emailTelefone = emailTelefone;
		this.motivoContato = motivoContato;
		this.mensagem = mensagem;
	}
	
	public Mensagem(String nome, String emailTelefone, int motivoContato, String mensagem){
		this.nome = nome;
		this.emailTelefone = emailTelefone;
		this.motivoContato = motivoContato;
		this.mensagem = mensagem;
	}
	

	@Override
	public String toString() {
		String aux = "";
		aux = "Nome: "+ nome + "\n";
		aux += "Email/Telefone: "+ emailTelefone + "\n";
		aux += "Motivo de Contato: "+ motivoContato + "\n";
		aux += "Mensagem: "+ mensagem;
		return aux;
	}
}
