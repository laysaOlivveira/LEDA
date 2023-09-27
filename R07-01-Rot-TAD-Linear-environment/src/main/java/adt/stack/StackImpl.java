package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		if (isEmpty()) {
            return null; // Retorna null se a pilha estiver vazia
        }
        return array[top];
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}
	

	@Override
	public boolean isFull() {
		return top == array.length -1;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull()) {
            throw new StackOverflowException(); // Lança exceção de estouro de pilha se estiver cheia
        }
		top++;
        array[top] = element;
    }

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()) {
            throw new StackUnderflowException(); // Lança exceção de subfluxo de pilha se estiver vazia
        }
        T element = array[top];
        array[top--] = null; // Remove o elemento da pilha e atualiza o topo
        return element;
	}

}
