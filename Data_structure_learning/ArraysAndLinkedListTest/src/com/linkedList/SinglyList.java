package com.linkedList;

import java.util.AbstractList;

public class SinglyList<E> extends AbstractList<E> {

	private Node<E> head;
	private Node<E> tail;
	private int size;

	public Node<E> getHead() {
		return head;
	}

	public SinglyList() {
		// TODO Auto-generated constructor stub
		head = null;
		tail = null;
		size = 0;
	}

	public boolean addFirst(E element) {
		// empty linked list
		Node<E> newNode = new Node<E>();
		newNode.setElement(element);
		newNode.setNext(head);
		head = newNode;
		size++;
		return true;
	}

	public boolean addLast(E element) {

		Node<E> newNode = new Node<>();
		newNode.setElement(element);
		newNode.setNext(null);
		if (tail == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
		size++;
		return true;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub

		if (head == null) {
			return null;
		}
		if (index >= size() - 1 || index < 0) {
			throw new IndexOutOfBoundsException("out of bounds");
		}

		return super.remove(index);
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		if (head == null) {
			return null;
		}
		if (index == 0) {
			return head.getElement();
		}

		if (index > size - 1 || index < 0) {
			throw new IndexOutOfBoundsException("index out of bounds");
		}
		Node<E> currentNode = head;
		int i = 0;
		while (i < index) {
			currentNode = currentNode.getNext();
			i++;
		}
		return currentNode.getElement();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		Node<E> currentNode = this.head;
		String s = new String();
		for (int j = 0; j < this.size; j++) {
			s += currentNode.getElement() + " -> ";
			currentNode = currentNode.getNext();
		}
		return s;

	}

	

	

	

	

}
