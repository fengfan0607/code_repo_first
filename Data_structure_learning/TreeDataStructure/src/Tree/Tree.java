package Tree;

import java.util.Iterator;

// The DS tree interface
public interface Tree<E> extends Iterable<E> {

	Position<E> root();

	Position<E> parent(Position<E> p);

	Iterable<Position<E>> children(Position<E> p);

	int numberChildren(Position<E> p);

	boolean isInternal(Position<E> p);

	boolean isExternal(Position<E> p);

	boolean isRoot(Position<E> p);

	boolean isEmpty();

	int size();

	Iterator<E> iterator();

	Iterator<Position<E>> positions();
}
