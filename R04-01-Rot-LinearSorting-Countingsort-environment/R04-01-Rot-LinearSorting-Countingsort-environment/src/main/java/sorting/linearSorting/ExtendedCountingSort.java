package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (verificador(array, leftIndex, rightIndex)) {
			int[] maiorMenorValorArray = this.valorMaiorEMenor(array, leftIndex, rightIndex);
			int maior = maiorMenorValorArray[0];
			int menor = maiorMenorValorArray[1];

			int[] C = new int[maior - menor + 1];
			int[] auxiliar = new int[rightIndex - leftIndex + 1];

			// Preenche C com as frequências dos elementos de array
			for (int i = leftIndex; i <= rightIndex; i++) {
				C[array[i] - menor]++;
			}

			// Calculando a soma em C
			for (int i = 1; i < C.length; i++) {
				C[i] += C[i - 1];
			}

			// registra os elementos ordenados em um array auxiliar
			for (int i = rightIndex; i >= leftIndex; i--) {
				auxiliar[C[array[i] - menor] - 1] = array[i];
				C[array[i] - menor]--;
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

	// encontra o valor maior e menor dentro do array
	private int[] valorMaiorEMenor(Integer[] array, int leftIndex, int rightIndex) {
		int maior = array[leftIndex];
		int menor = array[leftIndex];

		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i] > maior) {
				maior = array[i];
			}
			if (array[i] < menor) {
				menor = array[i];
			}
		}

		return new int[] { maior, menor };
	}

}
