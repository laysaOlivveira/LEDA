package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de
 * contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de
 * entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a
 * ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros
 * negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (verificador(array, leftIndex, rightIndex)) {
			int[] C = new int[this.maiorValor(array, leftIndex, rightIndex) + 1];
			int[] auxiliar = new int[rightIndex - leftIndex + 1];

			// preenchendo C com as frequências dos elementos de array
			for (int i = leftIndex; i <= rightIndex; i++) {
				C[array[i]]++;
			}

			// calculando a soma em C
			for (int i = 1; i < C.length; i++) {
				C[i] += C[i - 1];
			}

			// registra os elementos ordenados em um array auxiliar
			for (int i = rightIndex; i >= leftIndex; i--) {
				auxiliar[C[array[i]] - 1] = array[i];
				C[array[i]]--;
			}

			// Atribuindo o array auxiliar em array
			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = auxiliar[i - leftIndex];
			}
		}
	}

	// Verifica se o array de entrada não está vazio e se os indices sao validos
	private boolean verificador(Integer[] array, int leftIndex, int rightIndex) {
		return leftIndex >= 0 && leftIndex < rightIndex && rightIndex <= array.length - 1;
	}

	// encontra o valor maior dentro do array
	private int maiorValor(Integer[] array, int leftIndex, int rightIndex) {
		int maior = array[leftIndex];
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i] > maior) {
				maior = array[i];
			}
		}
		return maior;
	}

}
