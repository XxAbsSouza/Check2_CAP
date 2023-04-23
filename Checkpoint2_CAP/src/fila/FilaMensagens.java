package fila;

import entidades.Mensagem;

public class FilaMensagens {

	public final int N=30;
	Mensagem dados[]= new Mensagem[N];
	int ini, fim, cont;
	
	public void init() {
		ini = fim = cont = 0;
	}
	public boolean isEmpty() {
		if (cont == 0)
			return true;
		else
			return false;
	}
	public boolean isFull() {
		if (cont == N)
			return true;
		else
			return false;
	}
	public void enqueue(Mensagem elem) {
		if (isFull())
			System.out.println("Fila cheia");
		else {
			dados[fim] = elem;
			fim = (fim+1) % N;
			cont++;
		}
	}
	public Mensagem dequeue() {
		Mensagem elem = dados[ini];
		//ini = (ini+1) % N;
		ini++;
		if (ini==N)
			ini=0;
		cont--;
		return elem;
	}
	
	@Override
	public String toString() {
		Mensagem elem = dados[ini];
		String aux = null;
		aux += elem;
		
		return aux;
	}
	
}
