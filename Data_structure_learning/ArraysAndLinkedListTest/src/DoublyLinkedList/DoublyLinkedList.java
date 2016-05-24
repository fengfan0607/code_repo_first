package DoublyLinkedList;

import java.util.AbstractList;

public class DoublyLinkedList<E> extends AbstractList<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size;

	public DoublyLinkedList() {
		// TODO Auto-generated constructor stub
		head = new Node<E>(null);
		tail = new Node<E>(null);
		head.setNext(tail);
		tail.setNext(head);
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("index out of bounds");
		}
		int pointer = -1;
		Node<E> currentNode = head;
		while (pointer != index) {
			currentNode = currentNode.getNext();
			pointer++;
		}
		return currentNode.getData();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	// add node to the end to the list
	@Override
	public boolean add(E data) {
		// TODO Auto-generated method stub
		Node<E> newNode = new Node<E>(data);
		if (size == 0) {
			head.setNext(newNode);
			newNode.setNext(tail);
			newNode.setPrev(head);
			tail.setPrev(newNode);
		} else {
			Node<E> lastNode = tail.getPrev();
			lastNode.setNext(newNode);
			newNode.setPrev(lastNode);
			newNode.setNext(tail);
			tail.setPrev(newNode);
		}
		size++;
		return true;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		Node<E> newNode = new Node<E>(element);
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("check index");
		}
		int counter = -1;
		Node<E> currentNode = head;
		while (counter != index) {
			currentNode = currentNode.getNext();
			counter++;
		}
		Node<E> prevNode = currentNode.getPrev();
		prevNode.setNext(newNode);
		newNode.setPrev(prevNode);
		newNode.setNext(currentNode);
		currentNode.setPrev(newNode);
		size++;
	}

	@Override
	public String toString() {
		String s = "";
		Node<E> currentNode = head.getNext();
		for (int i = 0; i < this.size; i++) {
			s += currentNode.getData();
			s += "<->";
			currentNode = currentNode.getNext();
		}
		return s;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub.3
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException();
		}
		int counter = -1;
		Node<E> currentNode = head;
		while (counter != index) {
			currentNode = currentNode.getNext();
			counter++;
		}
		Node<E> prevNode = currentNode.getPrev();
		prevNode.setNext(currentNode.getNext());
		currentNode.getNext().setPrev(prevNode);
		size--;
		return currentNode.getData();
	}

}
