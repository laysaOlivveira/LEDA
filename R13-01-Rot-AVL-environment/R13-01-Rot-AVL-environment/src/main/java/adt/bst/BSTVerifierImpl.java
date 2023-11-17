package adt.bst;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {
	
	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}
	
	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
		return isBSTValid(bst.getRoot(), null, null);
}

    private boolean isBSTValid(BSTNode<T> node, T minValue, T maxValue) {
        if (node.isEmpty()) {
            // Se o nó for nulo, é uma árvore válida
            return true;
        }

        // Verifica se o valor do nó está dentro dos limites permitidos
        if ((minValue != null && node.getData().compareTo(minValue) <= 0)
                || (maxValue != null && node.getData().compareTo(maxValue) >= 0)) {
            return false;
        }

        // Verifica recursivamente as subárvores esquerda e direita
        return isBSTValid((BSTNode<T>) node.getLeft(), minValue, node.getData())
                && isBSTValid((BSTNode<T>) node.getRight(), node.getData(), maxValue);
    }
	
}
