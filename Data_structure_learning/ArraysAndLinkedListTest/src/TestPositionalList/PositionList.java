package TestPositionalList;

public interface PositionList<E> extends Iterable<E>{

	public int size();

	public boolean isEmpty();

	Position<E> first();

	Position<E> last();

	Position<E> after(Position<E> p);

	Position<E> before(Position<E> p);

	Position<E> addAfter(Position<E> p, E e);

	Position<E> addBefore(Position<E> p, E e);

	Position<E> addFirst(E e);

	Position<E> addLast(E e);

	public E remove(Position<E> p);

	public E set(Position<E> p, E e);

}
