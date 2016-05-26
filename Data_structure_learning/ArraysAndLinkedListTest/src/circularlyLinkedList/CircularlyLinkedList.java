package circularlyLinkedList;

import java.util.AbstractList;

import com.linkedList.Node;

public class CircularlyLinkedList<E> extends AbstractList<E> {

	Node<E> cursor;
	int size;

	public CircularlyLinkedList() {
		// TODO Auto-generated constructor stub
		cursor = new Node();
		size = 0;
	}

	public boolean add(E data) {
		Node<E> newNode = new Node<E>(data, null);
		if (size == 0) {
			cursor = newNode;
			newNode.setNext(cursor);
		} else {
			newNode.setNext(cursor.getNext());
			cursor.setNext(newNode);
		}
		size++;
		return true;

	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean remove() {

		if (size == 0) {
			throw new NullPointerException();
		} else if (size == 1) {
			cursor = null;
		} else {
			cursor.setNext(cursor.getNext().getNext());
		}
		size--;
		return true;
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	public String toString() {
		// TODO Auto-generated method stub
		Node<E> currentNode = this.cursor;
		String s = new String();
		for (int j = 0; j < this.size; j++) {
			s += currentNode.getElement() + " -> ";
			currentNode = currentNode.getNext();
		}
		return s;

	}
}
