package PositionList;

import java.util.Iterator;

import org.omg.CORBA.Current;

import DoublyLinkedList.Node;

public class DoublyLinkedPositionList<E> implements PositionList<E> {

	private DNode<E> header;
	private DNode<E> tailer;
	private int size;

	public DoublyLinkedPositionList() {
		// TODO Auto-generated constructor stub
		header = new DNode<E>(null, null, null);
		tailer = new DNode<E>(null, null, null);
		size = 0;
		header.setNext(tailer);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public Position<E> first() {
		// TODO Auto-generated method stub
		return position(header.getNext());
	}

	@Override
	public Position<E> last() {
		// TODO Auto-generated method stub
		return position(tailer.getPrev());
	}

	@Override
	public Position<E> before(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		DNode<E> node = validate(p);
		return node.getPrev();
	}

	@Override
	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		DNode<E> node = validate(p);
		return node.getNext();
	}

	@Override
	public Position<E> addFirst(E e) {
		// TODO Auto-generated method stub

		return addBetween(e, header, header.getNext());
	}

	@Override
	public Position<E> addLast(E e) {
		// TODO Auto-generated method stub
		return addBetween(e, tailer.getPrev(), tailer);
	}

	@Override
	public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		DNode<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
	}

	@Override
	public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		DNode<E> node = validate(p);
		return addBetween(e, node, node.getNext());
	}

	@Override
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		DNode<E> node = validate(p);
		E prevData = node.getElement();
		node.setElement(e);
		return prevData;
	}

	@Override
	public E remove(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		DNode<E> node = validate(p);
		DNode<E> prev = node.getPrev();
		DNode<E> next = node.getNext();
		prev.setNext(next);
		next.setPrev(prev);
		size--;
		E removedElement = node.getElement();
		node.setElement(null);
		node.setNext(null);
		node.setPrev(null);
		return removedElement;
	}

	private Position<E> position(DNode<E> node) {
		if (node == null) {
			return null;
		} else {
			return node;
		}
	}

	protected DNode<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof DNode)) {
			throw new IllegalArgumentException("not a valid node");
		}

		DNode<E> node = (DNode<E>) p;
		if (node.getNext() == null || node.getPrev() == null) {
			throw new IllegalArgumentException("node p is no longer exist in the list");
		}
		return node;

	}

	private Position<E> addBetween(E e, DNode<E> prev, DNode<E> next) {
		DNode<E> node = new DNode<E>(e, null, null);
		node.setNext(next);
		node.setPrev(prev);
		prev.setNext(node);
		next.setPrev(node);
		size++;
		return position(node);
	}

	@Override
	public String toString() {
		String s = "";
		DNode<E> currentNode = header.getNext();
		for (int i = 0; i < this.size; i++) {
			s += currentNode.getElement();
			s += "<->";
			currentNode = currentNode.getNext();
		}
		return s;
	}

	public Iterator<E> iterator() {
		return new ElementIterator();
	}

	private class ElementIterator implements Iterator<E> {
		Iterator<Position<E>> positionIterator = new positionIterator();

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return positionIterator.hasNext();
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return positionIterator.next().getElement();
		}

	}

	private class positionIterator implements Iterator<Position<E>> {

		Position<E> cursor = first();
		Position<E> Current = null;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return cursor != null;
		}

		@Override
		public Position<E> next() {
			// TODO Auto-generated method stub
			if (cursor == null) {
				throw new IllegalAccessError("no element left");
			} else {
				Current = cursor;
				cursor = after(cursor);
			}
			return Current;
		}

	}

	private class PositionIterable implements Iterable<Position<E>> {

		@Override
		public Iterator<Position<E>> iterator() {
			// TODO Auto-generated method stub
			return new positionIterator();
		}

		public Iterable<Position<E>> positions() {
			return new PositionIterable();
		}

	}

}
