package com.linkedList;

import org.junit.experimental.theories.Theories;

public class Node<E> {
	private E data;
	private Node next;

	public Node() {
		this.data = null;
		this.next = null;
	}
	

	public Node(E data, Node<E> next) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.next = next;
	}


	public E getElement() {
		return this.data;
	}

	public Node<E> getNext() {
		return this.next;
	}

	public void setElement(E data) {
		this.data = data;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
