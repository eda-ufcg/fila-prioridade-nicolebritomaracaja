import java.util.Arrays;
import java.util.NoSuchElementException;

public class InsereOrdenadoFilaPrioridade implements FilaPrioridade {

	private Pair[] fila;
	private int head;
	private int last;

	public InsereOrdenadoFilaPrioridade(int capacidade) {
		this.fila = new Pair[capacidade];
		this.last = -1;
		this.head = -1;
	}

	public boolean isEmpty(){
		return this.head == -1 && this.last == -1;
	}

	public boolean isFull(){
		return (this.last + 1) % fila.length == this.head;
	}

	// criar um Pair e inserir de forma ordenada decrescente no array.
	public void add(String elemento, int prioridade) {
		Pair newPair = new Pair(elemento, prioridade);

		if (isFull()){
            throw new RuntimeException("Fila Cheia!");
        }

		if(this.isEmpty()){
			this.head = 0;
		}

		last = (last + 1) % fila.length;
        fila[last] = newPair;
		
		int i = last;
		int j = last - 1;

		while (i >= 0 && j >= 0 && fila[i].getPrioridade() > fila[j].getPrioridade()){
			swap(i, j, fila);
			i--;
			j--;
		}
	}

	public void swap(int i, int j, Pair[] v){
		Pair aux = v[i];
		v[i] = v[j];
		v[j] = aux;

	}

	// remover e retornar o primeiro elemento do array, que é o de maior prioridade. lembrar manipular head e tail
	// para ser uma fila circular. assim a remoção fica O(1)
	public String removeNext() {
		if (this.isEmpty()){
			throw new NoSuchElementException("Fila vazia!");
		}

		Pair valor = fila[head];

		if (this.head == this.last){
			this.head = -1;
			this.last = -1;
		} else {
			head = (head + 1) % fila.length;
		}

		return valor.getElemento();
	}

}
