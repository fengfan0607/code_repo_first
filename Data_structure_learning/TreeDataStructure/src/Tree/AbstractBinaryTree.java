package Tree;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

	@Override
	public Position<E> sibling(Position<E> p) {
		// TODO Auto-generated method stub
		Position<E> parent = parent(p);
		if (parent == null) {
			return null;
		}
		if (p == left(parent)) {
			return right(parent);
		} else {
			return left(parent);
		}
	}

	@Override
	public int numberChildren(Position<E> p) {
		// TODO Auto-generated method stub
		int count = 0;
		if (left(p) != null) {
			count++;
		}
		if (right(p) != null) {
			count++;
		}
		return count;
	}

	@Override
	public Iterable<Position<E>> children(Position<E> p) {
		// TODO Auto-generated method stub

		List<Position<E>> children = new ArrayList<>();
		if (left(p) != null) {
			children.add(left(p));
		}
		if (right(p) != null) {
			children.add(right(p));
		}
		return children;
	}
}
