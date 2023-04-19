package aplicacao;
import java.util.Scanner;
import entidades.Mensagem;
import fila.FilaMensagens;

//Ana Beatriz dos Santos Souza	96229
//Yann Santana					93609
//Daniel Franceschi				95175					
//Guilherme Mendes da Cunha		95173					
//Enzo Mansi						92955	

public class AtendimentoMensagem {

	
	public static void main(String[] args) {
		Scanner le = new Scanner(System.in);
		
		//inst�nciando as tr�s filas! 
		
		//Cria��o da filaReclamacao com 30
		FilaMensagens filaReclamacao = new FilaMensagens();
		//Cria��o da filaSugestao com 30
		FilaMensagens filaSugestao = new FilaMensagens();
		//Cria��o da filaResolucao com 30
		FilaMensagens filaResolucao = new FilaMensagens();
		
		//inicializa��o das 3 filas
		filaReclamacao.init();
		filaSugestao.init();
		filaResolucao.init();
		
		int opcao = 0;
		do {
			
			System.out.println(" 0 - Encerra o programa");
			System.out.println(" 1 - Recebimeto de Mensagem");
			System.out.println(" 2 - Atendimento de Mensagem");
			System.out.println(" 3 - Recebimento e Encaminhamento de Resolu��o");
			//l� a op��o escolhida
			opcao = le.nextInt();
			
			switch (opcao) {
			case 0:
				if(filaReclamacao.isEmpty() && filaResolucao.isEmpty() && filaSugestao.isEmpty()) {
					System.out.println("Encerrando programa...");
				}
				else {
					System.out.println("Existe algumas mensagens ainda!!");
					//Um jeito de permitir o loop
					opcao = -1;
				}
				
				break;
			
			case 1:
				//Limpa o �ltimo next: opcao = le.nextInt();
				le.nextLine();
				
				System.out.println("Nome(opcional): ");
				String nome = le.nextLine();
				
				System.out.println("Email/Telefone: ");
				String emailTelefone = le.next();
				
				System.out.println("Motivo do contato (1 - reclama��o / 2 - sugest�o): ");
				int motivoContato = le.nextInt();
				
				//Valida��o
				while (motivoContato < 1 && motivoContato > 2) {
					System.out.println("Digite corretamente o motivo do contato (1 - reclama��o / 2 - sugest�o): ");
					motivoContato = le.nextInt();
				}
				
				le.nextLine();
				
				System.out.println("Mensagem (texto): ");
				String texto = le.nextLine();
				
				//Guardando os dados do usuario no objeto mensagem
				if(nome != null){
					//Inst�nciando mensagem
					Mensagem mensagem = new Mensagem(nome, emailTelefone,motivoContato,texto);
					
					//Indo na sua devida fila
					if(motivoContato == 1) {
						filaReclamacao.enqueue(mensagem);
					} else {
						if(motivoContato == 2) {
							filaSugestao.enqueue(mensagem);
						} 
					}
					
				} else {
					Mensagem mensagem = new Mensagem(emailTelefone,motivoContato,texto);
					
					//Indo na sua devida fila
					if(motivoContato == 1) {
						filaReclamacao.enqueue(mensagem);
					} else {
						if(motivoContato == 2) {
							filaSugestao.enqueue(mensagem);
						} 
					}
					
				}
				
				break;
				
			case 2:
				
				//Perguntar qual fila vai querer atender
				System.out.println("Escolha o tipo de mensagem que ser� respondido (1 - reclama��o / 2 - sugest�o): ");
				int atendimentoTipoMensagem = le.nextInt();
				
				//Valida��o
				while (atendimentoTipoMensagem != 1 || atendimentoTipoMensagem != 2) {
					System.out.println("Digite corretamente o tipo de mensagem que ser� respondido (1 - reclama��o / 2 - sugest�o): ");
					motivoContato = le.nextInt();
				}
				
				if(atendimentoTipoMensagem == 1) {
					//getDados para mostrar as informa��es
					
					
					
					filaReclamacao.dequeue();
					//Encaminhar para outro setor
					
					
					//Confirma��o para solucionar
					
				} else {
					filaSugestao.dequeue();
				}
				
				break;
			
			case 3:
				
				break;

			default:
				break;
			}
			
		} while (opcao != 0);
		
		le.close();

	}
}
