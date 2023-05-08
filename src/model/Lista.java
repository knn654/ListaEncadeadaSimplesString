package model;

public class Lista{
	
	No primeiro;
	
	public Lista() {
		primeiro = null;
	}
	
	public boolean isEmpty() {
		return (primeiro == null);
	}
	
	public int size() {
		int cont = 0;
		No auxiliar = primeiro;
		
		while (auxiliar != null) {
			auxiliar = auxiliar.proximo;
			cont++;;
		}
		return cont;
	}

	public void addFirst(String dado) {
		No elemento = new No();
		elemento.dado = dado;
		elemento.proximo = primeiro;
		primeiro = elemento;
	}

	public void addLast(String dado) throws Exception {
		No elemento = new No();
		elemento.dado = dado;
		elemento.proximo = null;
		if (isEmpty()) {
			primeiro = elemento;
		} else {
			No ultimo = getNo(size() - 1);
			ultimo.proximo = elemento;
		}
	}

	public void add(String dado, int pos) throws Exception {
		if (isEmpty() && pos != 0) {
			throw new Exception("Lista vazia!");
		}
		if (pos < 0 || pos > size()) {
			throw new Exception("Posição inválida!");
		}
		if (pos == 0) {
			addFirst(dado);
		} else if (pos == size()) {
			addLast(dado);
		} else {
			No elemento = new No();
			No anterior = getNo(pos - 1);
			
			elemento.dado = dado;
			elemento.proximo = anterior.proximo;
			anterior.proximo = elemento;
		}
	}

	public void removeFirst() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}
		primeiro = primeiro.proximo;
	}

	public void removeLast() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}
		if (size() == 1) {
			removeFirst();
		} else {
			No anterior = getNo(size() - 2);
			anterior.proximo = null;
		}
	}

	public void remove(int pos) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}
		if (pos < 0 || pos >= size()) {
			throw new Exception("Posição inválida!");
		}
		if (pos == 0) {
			removeFirst();
		} else if (pos == size() - 1) {
			removeLast();
		} else {
			No atual = getNo(pos);
			No anterior = getNo(pos - 1);
			
			anterior.proximo = atual.proximo;
		}
	}

	public String get(int pos) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}
		int tamanho = size();
		if (pos < 0 || pos > tamanho - 1) {
			throw new Exception("Posição inválida!");
		}
		No auxiliar = primeiro;
		int cont = 0;
		while (cont < pos) {
			auxiliar = auxiliar.proximo;
			cont++;
		}
		String valor = auxiliar.dado;
		return valor;
	}
	
	private No getNo(int pos) throws Exception{
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}
		if (pos < 0 || pos >= size()) {
			throw new Exception("Posição inválida!");
		}
		No auxiliar = primeiro;
		int cont = 0;
		
		while (cont < pos) {
			auxiliar = auxiliar.proximo;
			cont++;;
		}
		return auxiliar;
	}

}