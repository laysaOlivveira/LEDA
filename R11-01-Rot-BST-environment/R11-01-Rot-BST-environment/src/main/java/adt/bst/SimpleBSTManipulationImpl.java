package adt.bst;

import adt.bt.BTNode;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		return this.equalsR(tree1.getRoot(), tree2.getRoot());
	}

	private boolean equalsR (BTNode<T> currentNodeTree1, BTNode<T> currentNodeTree2) {
		if (currentNodeTree1.equals(currentNodeTree2)) {
			if (!currentNodeTree1.isEmpty() && !currentNodeTree2.isEmpty()) {
				return
						this.equalsR(currentNodeTree1.getLeft(), currentNodeTree2.getLeft())
								&& this.equalsR(currentNodeTree1.getRight(), currentNodeTree2.getRight());
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		return this.isSimilarR(tree1.getRoot(), tree2.getRoot());
	}

	private boolean isSimilarR (BTNode<T> currentNodeTree1, BTNode<T> currentNodeTree2) {
		if (!currentNodeTree1.isEmpty() && !currentNodeTree2.isEmpty()) {
			return
					this.isSimilarR(currentNodeTree1.getLeft(), currentNodeTree2.getLeft())
							&& this.isSimilarR(currentNodeTree1.getRight(), currentNodeTree2.getRight());
		} else
			return
					(!currentNodeTree1.isEmpty() || currentNodeTree2.isEmpty())
							&& (currentNodeTree1.isEmpty() || !currentNodeTree2.isEmpty());
	}


	@Override
	public T orderStatistic(BST<T> tree, int k) {
		int treeSize = tree.size();

		if (k >= 1 && k <= treeSize) {
			BTNode<T> treeMinimum = tree.minimum();

			if (k == 1)
				return treeMinimum.getData();
			else if (k == treeSize)
				return tree.maximum().getData();
			else
				return this.orderStatisticR(tree, treeMinimum, k);
		}

		return null;
	}

	private T orderStatisticR (BST<T> tree, BTNode<T> currentNode, int k) {
		return k == 1
				? currentNode.getData()
				: this.orderStatisticR(tree, tree.sucessor(currentNode.getData()), --k);
	}

}
