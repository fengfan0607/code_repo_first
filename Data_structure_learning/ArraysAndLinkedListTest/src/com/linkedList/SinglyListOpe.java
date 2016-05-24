package com.linkedList;

import java.util.Vector;

public class SinglyListOpe {

	public static Node<String> reverseList(Node<String> head) {
		if (head == null) {
			return null;
		}
		Node<String> prevNode = new Node<String>();
		while (head != null) {
			Node<String> nextNode = head.getNext();
			head.setNext(prevNode);
			prevNode = head;
			head = nextNode;
		}
		return prevNode;
	}

	public static Node<String> mergeList(Node<String> firstHead, Node<String> secondHead) {
		Node<String> currentNode = firstHead;
		Node<String> nextNode = secondHead;
		while (currentNode != null) {
			Node<String> temp = currentNode.getNext();
			currentNode.setNext(nextNode);
			currentNode = nextNode;
			nextNode = temp;
		}
		return firstHead;

	}

	public static int middlePointSerch(Node<String> node) {
		Node<String> firstPointer = node;
		int i = 0;
		int j = 0;
		if (node.getNext().getNext() == null) {
			return 1;
		}
		Node<String> secondPointer = node;
		while (firstPointer != null && firstPointer.getNext() != null) {
			firstPointer = firstPointer.getNext().getNext();
			secondPointer = secondPointer.getNext();
			i++;
		}
		if (firstPointer == null) {
			return i - 1;
		} else {
			return i;
		}
	}

	public static String printList(Node<String> head) {
		// TODO Auto-generated method stub
		Node<String> currentNode = head;
		String s = new String();
		while (currentNode != null) {
			s += currentNode.getElement() + " -> ";
			currentNode = currentNode.getNext();
		}
		return s;
	}

	public Vector<Node<String>> breakList(Node<String> head) {
		Vector<Node<String>> vector = new Vector<>();
		int middle = middlePointSerch(head);
		
		return null;

	}
}
