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

		// inst�nciando as tr�s filas!

		// Cria��o da filaReclamacao com 30
		FilaMensagens filaReclamacao = new FilaMensagens();
		// Cria��o da filaSugestao com 30
		FilaMensagens filaSugestao = new FilaMensagens();
		// Cria��o da filaResolucao com 30
		FilaMensagens filaResolucao = new FilaMensagens();

		// inicializa��o das 3 filas
		filaReclamacao.init();
		filaSugestao.init();
		filaResolucao.init();

		int opcao = 0;
		do {

			System.out.println(" 0 - Encerra o programa");
			System.out.println(" 1 - Recebimeto de Mensagem");
			System.out.println(" 2 - Atendimento de Mensagem");
			System.out.println(" 3 - Recebimento e Encaminhamento de Resolu��o");
			// l� a op��o escolhida
			opcao = le.nextInt();

			switch (opcao) {
				case 0:
					if (filaReclamacao.isEmpty() && filaResolucao.isEmpty() && filaSugestao.isEmpty()) {
						System.out.println("Encerrando programa...");
						break;
					}

				case 1:
					// Limpa o �ltimo next: opcao = le.nextInt();
					le.nextLine();

					System.out.println("Nome(opcional): ");
					String nome = le.nextLine();

					System.out.println("Email/Telefone: ");
					String emailTelefone = le.next();

					System.out.println("Motivo do contato (1 - reclama��o / 2 - sugest�o): ");
					int motivoContato = le.nextInt();

					// Valida��o
					while (motivoContato < 1 || motivoContato > 2) {
						System.out.println("Digite corretamente o motivo do contato (1 - reclama��o / 2 - sugest�o): ");
						motivoContato = le.nextInt();
					}

					le.nextLine();

					System.out.println("Mensagem (texto): ");
					String texto = le.nextLine();

					System.out.println();

					// Guardando os dados do usuario no objeto mensagem
					if (nome != null) {
						// Inst�nciando mensagem
						Mensagem mensagem = new Mensagem(nome, emailTelefone, motivoContato, texto);

						// Indo na sua devida fila
						if (motivoContato == 1) {
							filaReclamacao.enqueue(mensagem);
						} else {
							if (motivoContato == 2) {
								filaSugestao.enqueue(mensagem);
							}
						}

					} else {
						Mensagem mensagem = new Mensagem(emailTelefone, motivoContato, texto);

						// Indo na sua devida fila
						if (motivoContato == 1) {
							filaReclamacao.enqueue(mensagem);
						} else {
							if (motivoContato == 2) {
								filaSugestao.enqueue(mensagem);
							}
						}

					}

					break;

				case 2:
				//conferindo se tem algo nas filas
				if (filaReclamacao.isEmpty() && filaSugestao.isEmpty()) {
					System.out.println("Não há mensagens para atender.");
					break;
				}
					// Perguntar qual fila vai querer atender
					System.out.println(
							"Escolha o tipo de mensagem que ser� respondido (1 - reclama��o / 2 - sugest�o): ");
					int atendimentoTipoMensagem = le.nextInt();

					// Valida��o
					while (atendimentoTipoMensagem < 1 || atendimentoTipoMensagem > 2) {
						System.out.println(
								"Digite corretamente o tipo de mensagem que ser� respondido (1 - reclama��o / 2 - sugest�o): ");
						atendimentoTipoMensagem = le.nextInt();
					}

					if (atendimentoTipoMensagem == 1) {
						// getDados para mostrar as informa��es
						System.out.println(filaReclamacao.toString());

						System.out.println(
								"Confirmar a entrega da mensagem da solução do problema? (1 - sim / 2 - não, encaminhar para outro setor): ");
						int op = le.nextInt();

						// validação
						while (op < 1 || op > 2) {
							System.out.println(
									"Confirmar a entrega da mensagem da solução do problema? (1 - sim / 2 - não, encaminhar para outro setor): ");
							op = le.nextInt();
						}

						// Encaminhar para outro setor ou confirmar para solucionar
						if (op == 1) {
							System.out.println(
									"Enviada resposta para cliente: sua solicitação já foi resolvida. Obrigado!!!");
							filaReclamacao.dequeue();
						} else {
							filaResolucao.enqueue(filaReclamacao.dequeue());
						}
					} else {
						System.out.println(filaSugestao.toString());

						System.out.println(
								"Confirmar a entrega da mensagem do feedback? (1 - sim / 2 - não, encaminhar para outro setor):");
						int op = le.nextInt();

						// validação
						while (op < 1 || op > 2) {
							System.out.println(
									"Confirmar a entrega da mensagem da solução do problema? (1 - sim / 2 - não, encaminhar para outro setor): ");
							op = le.nextInt();
						}

						// Encaminhar para outro setor ou confirmar para solucionar
						if (op == 1) {
							System.out.println(
									"Enviada resposta para cliente: sua solicitação já foi resolvida. Obrigado!!!");
							filaSugestao.dequeue();
						} else {
							filaResolucao.enqueue(filaSugestao.dequeue());
						}

					}

					break;

				case 3:
				//conferindo se há algo na fila resolução
				if (filaResolucao.isEmpty()) {
					System.out.println("Não há mensagens para encaminhar.");
					break;
				}
					System.out.println(filaResolucao.dequeue());
					System.out.println("Enviada resposta para cliente: sua solicitação já foi resolvida. Obrigado!!!");
					break;

				default:
					System.out.println("Opção inválida");
					break;
			}

		} while (opcao != 0|| !filaReclamacao.isEmpty() || !filaSugestao.isEmpty() || !filaResolucao.isEmpty());

		le.close();

	}
}
