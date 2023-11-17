package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bt.BTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		for (Integer value : array)
			this.insert(value);

		return this.floorR(this.root, numero, null);
	}

	private Integer floorR (BTNode<Integer> currentNode, double number, Integer floor) {
		if (!currentNode.isEmpty()) {
			if (number > currentNode.getData())
				floor = this.floorR(currentNode.getRight(), number, currentNode.getData());
			else if (number < currentNode.getData())
				floor = this.floorR(currentNode.getLeft(), number, floor);
			else
				floor = currentNode.getData();
		}

		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		for (Integer value : array)
			this.insert(value);

		return this.ceilR(this.root, numero, null);
	}
	private Integer ceilR (BTNode<Integer> currentNode, double number, Integer ceil) {
		if (!currentNode.isEmpty()) {
			if (number > currentNode.getData())
				ceil = this.ceilR(currentNode.getRight(), number, ceil);
			else if (number < currentNode.getData())
				ceil = this.ceilR(currentNode.getLeft(), number, currentNode.getData());
			else
				ceil = currentNode.getData();
		}

		return ceil;
	}

}
