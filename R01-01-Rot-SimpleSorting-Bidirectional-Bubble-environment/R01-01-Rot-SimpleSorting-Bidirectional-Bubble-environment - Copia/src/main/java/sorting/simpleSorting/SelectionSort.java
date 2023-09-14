package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {
	  @Override
	    public void sort(T[] array, int leftIndex, int rightIndex) {
	        if (array == null || leftIndex < 0 || rightIndex >= array.length || leftIndex >= rightIndex) {
	            return; // Retorna se o array for nulo ou índices inválidos
	        }
	        
	        for (int i = leftIndex; i <= rightIndex; i++) {
	            int minIndex = i;
	            for (int j = i + 1; j <= rightIndex; j++) {
	                if (array[j].compareTo(array[minIndex]) < 0) {
	                    minIndex = j;
	                }
	            }
	            swap(array, i, minIndex);
	        }
	    }
	    
	    private void swap(T[] array, int i, int j) {
	        T troca = array[i];
	        array[i] = array[j];
	        array[j] = troca;
	    }
}

