import java.util.ArrayList;
import java.util.NoSuchElementException;

public class InsereFinalFilaPrioridade implements FilaPrioridade {

	private ArrayList<Pair> fila;

	public InsereFinalFilaPrioridade(int capacidade) {
		this.fila = new ArrayList<Pair>(capacidade);
	}
	
	// criar um Pair e adicionar no fim da fila
	public void add(String elemento, int prioridade) {
		Pair newPair = new Pair(elemento, prioridade);
		fila.add(newPair);
	}


	// buscar pelo elemento de maior prioridade na fila.
	public String removeNext() {
		if (fila.isEmpty()){
			throw new NoSuchElementException("Fila Vazia!");
		}

		int indexMaiorPrioridade = 0;

		for (int i = 1; i < fila.size(); i++){
			if (fila.get(i).getPrioridade() > fila.get(indexMaiorPrioridade).getPrioridade()){
				indexMaiorPrioridade = i;
			}
		}

		Pair newPair = fila.remove(indexMaiorPrioridade);
		return newPair.getElemento();
	}

}
