package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (array == null || leftIndex < 0 || rightIndex >= array.length || leftIndex >= rightIndex) {
            return; // Retorna se o array for nulo ou índices inválidos
        }

        recursiveSelectionSort(array, leftIndex, rightIndex);
    }
    
    private void recursiveSelectionSort(T[] array, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return; // Caso base: array de tamanho 1 já está ordenado
        }
        
        int minIndex = leftIndex;
        for (int i = leftIndex + 1; i <= rightIndex; i++) {
            if (array[i].compareTo(array[minIndex]) < 0) {
                minIndex = i;
            }
        }
        
        swap(array, leftIndex, minIndex);
        
        recursiveSelectionSort(array, leftIndex + 1, rightIndex); // Chama recursivamente para a parte não ordenada
    }

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
