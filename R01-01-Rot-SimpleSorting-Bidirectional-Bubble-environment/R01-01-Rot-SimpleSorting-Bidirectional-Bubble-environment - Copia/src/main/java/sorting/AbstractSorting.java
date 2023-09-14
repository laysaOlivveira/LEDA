package sorting;

public abstract class AbstractSorting<T extends Comparable<T>> implements
		Sorting<T> {

	@Override
	public void sort(T[] array) {
		sort(array, 0, array.length - 1);
	}

	/**
	 * This method sorts an interval of the array, starting in leftIndex and
	 * ending in rightIndex, both inclusive.
	 * You do not have to worry about null values inside the array. 
	 * If leftIndex and/or rightIndex are outside the array limits, the algorithm does nothing. 
	 * 
	 * @param array
	 *            the target of the sorting algorithm
	 * @param leftIndex
	 *            where the sorting should begin
	 * @param rightIndex
	 *            where the sorting should end
	 */
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
