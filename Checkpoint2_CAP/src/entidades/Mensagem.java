package entidades;

public class Mensagem {
	String nome;
	String email;
	int motivoContato, telefone;
	String mensagem;
	
	public Mensagem(String email, int motivoContato, int telefone, String mensagem) {
		this.email = email;
		this.motivoContato = motivoContato;
		this.telefone = telefone;
		this.mensagem = mensagem;
	}
	public Mensagem(String nome, String email, int motivoContato, int telefone, String mensagem) {
		this.nome = nome;
		this.email = email;
		this.motivoContato = motivoContato;
		this.telefone = telefone;
		this.mensagem = mensagem;
	}
}
