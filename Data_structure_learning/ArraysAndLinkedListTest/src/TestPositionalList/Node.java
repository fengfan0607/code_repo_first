package TestPositionalList;

public class Node<E> implements Position<E> {

	Node<E> prev;
	Node<E> next;
	E data;

	public Node(Node<E> pre, Node<E> nex, E d) {
		// TODO Auto-generated constructor stub
		prev = pre;
		next = nex;
		data = d;
	}

	public Node<E> getPrev() {
		return prev;
	}

	public void setPrev(Node<E> prev) {
		this.prev = prev;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	public void setData(E data) {
		this.data = data;
	}

	@Override
	// get node element, return null for a invalid node
	public E getElement() {
		// TODO Auto-generated method stub
		if (next == null && prev == null) {
			throw new IllegalAccessError("not a valid node");
		}
		return data;
	}
}
