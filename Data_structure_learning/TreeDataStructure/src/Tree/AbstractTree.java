package Tree;

public abstract class AbstractTree<E> implements Tree<E> {

	@Override
	public boolean isExternal(Position<E> p) {
		// TODO Auto-generated method stub
		return numberChildren(p) > 0;
	}

	@Override
	public boolean isInternal(Position<E> p) {
		// TODO Auto-generated method stub
		return numberChildren(p) == 0;
	}

	@Override
	public boolean isRoot(Position<E> p) {
		// TODO Auto-generated method stub
		return p == root();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size() == 0;
	}

	public int depth(Position<E> p) {
		if (isRoot(p)) {
			return 0;
		} else {
			return 1 + depth(parent(p));
		}
	}

	public int height(Position<E> p) {
		int h = 0;
		for (Position<E> child : children(p)) {
			h = Math.max(h, height(child) + 1);
		}
		return h;
	}
}
