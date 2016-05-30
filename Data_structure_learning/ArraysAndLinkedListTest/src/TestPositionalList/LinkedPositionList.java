package TestPositionalList;

import java.awt.Cursor;
import java.util.Iterator;

import org.junit.internal.Throwables;
import org.junit.validator.ValidateWith;

public class LinkedPositionList<E> implements PositionList<E> {

	private Node<E> header, tailer;
	int size;

	public LinkedPositionList() {
		// TODO Auto-generated constructor stub
		header = new Node<E>(null, null, null);
		tailer = new Node<E>(header, null, null);

		header.setNext(tailer);
		size = 0;

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0);
	}

	@Override
	public Position<E> first() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}
		return header.getNext();

	}

	@Override
	public Position<E> last() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new IllegalAccessError("list is empty");
		}
		return tailer.getPrev();
	}

	private Node<E> validate(Position<E> p) {

		if (p == null) {
			throw new IllegalArgumentException("invalida position");
		}

		// if (p == header || p == tailer) {
		// throw new IllegalArgumentException("head or tail is not a valid
		// position");
		// }
		Node<E> node = (Node<E>) p;

		if (node.getNext() == null && node.getPrev() == null) {
			throw new IllegalArgumentException("node is not exist in the list");
		}

		return node;

	}

	public Position<E> position(Node<E> node) {
		if (node == null) {
			return null;
		}
		return node;
	}

	@Override
	public Position<E> after(Position<E> p) {
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		return position(node.getNext());
	}

	@Override
	public Position<E> before(Position<E> p) {
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		return position(node.getPrev());
	}

	@Override
	public Position<E> addAfter(Position<E> p, E e) {
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		return addBetween(node, node.getNext(), e);
	}

	@Override
	public Position<E> addBefore(Position<E> p, E e) {
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		return addBetween(node.getPrev(), node, e);

	}

	private Position<E> addBetween(Node<E> prev, Node<E> next, E e) {
		// TODO Auto-generated method stub
		Node<E> node = new Node<E>(null, null, e);
		node.setPrev(prev);
		node.setNext(next);
		prev.setNext(node);
		next.setPrev(node);

		size++;
		return position(node);
	}

	@Override
	public Position<E> addFirst(E e) {
		// TODO Auto-generated method stub
		return addBetween(header, header.getNext(), e);

	}

	@Override
	public Position<E> addLast(E e) {
		// TODO Auto-generated method stub
		return addBetween(tailer.getPrev(), tailer, e);
	}

	@Override
	public E remove(Position<E> p) {
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		E value = node.getElement();
		Node<E> prev = node.getPrev();
		Node<E> next = node.getNext();
		prev.setNext(next);
		next.setPrev(prev);
		node.setData(null);
		node.setNext(null);
		node.setPrev(null);
		size--;
		return value;
	}

	@Override
	public E set(Position<E> p, E e) {
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		E value = node.getElement();
		node.setData(e);
		return value;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "";
		if (size == 0) {
			return null;
		}
		Node<E> current = header.getNext();
		for (int i = 0; i < size; i++) {
			s += current.getElement();
			s += "<->";
			current = current.getNext();
		}
		return s;
	}

	private class PositionIterator implements Iterator<Position<E>> {

		private Position<E> cursor = first();
		private Position<E> recent = null;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub

			return (cursor != null);
		}

		@Override
		public Position<E> next() {
			// TODO Auto-generated method stub
			if (cursor == null) {
				throw new IllegalArgumentException("no such element");
			} else {
				recent = cursor;
				if (cursor == last()) {
					cursor = null;
				} else {
					cursor = after(cursor);
				}
			}
			return recent;
		}

	}

	private class ElementIterator implements Iterator<E> {

		Iterator<Position<E>> iter = new PositionIterator();

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return iter.hasNext();
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return iter.next().getElement();
		}

	}

	@Override
	public java.util.Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new ElementIterator();
	}
}
