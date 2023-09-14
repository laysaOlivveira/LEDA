package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (array == null || leftIndex < 0 || rightIndex >= array.length || leftIndex >= rightIndex) {
            return; // Retorna se o array for nulo ou índices inválidos
        }

        for (int i = rightIndex; i > leftIndex; i--) {
            for (int j = leftIndex; j < i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private void swap(T[] array, int i, int j) {
        T troca = array[i];
        array[i] = array[j];
        array[j] = troca;
    }
}
