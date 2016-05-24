package DoublyLinkedList;

public class Node<E> {

	private E data;
	private Node<E> prev;
	private Node<E> next;

	public Node(E data, Node<E> prev, Node<E> next) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

	public Node(E data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.next = null;
		this.prev = null;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
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

}
