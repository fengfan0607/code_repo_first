package PositionList;

public class DNode<E> implements Position<E> {

	private E data;
	private DNode<E> prev;
	private DNode<E> next;

	public DNode(E data, DNode<E> prev, DNode<E> next) {
		super();
		this.data = data;
		this.prev = prev;
		this.next = next;
	}

	@Override
	public E getElement() throws IllegalStateException {
		// TODO Auto-generated method stub
		if (next == null && prev == null) {
			throw new IllegalArgumentException("node does not exist in the list");
		}
		return data;
	}

	public void setElement(E e) {
		data = e;
	}

	public DNode<E> getPrev() {
		return prev;
	}

	public void setPrev(DNode<E> prev) {
		this.prev = prev;
	}

	public DNode<E> getNext() {
		return next;
	}

	public void setNext(DNode<E> next) {
		this.next = next;
	}

}
