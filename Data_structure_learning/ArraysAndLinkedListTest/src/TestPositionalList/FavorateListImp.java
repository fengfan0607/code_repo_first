package TestPositionalList;

import java.util.Iterator;

public class FavorateListImp<E> {

	PositionList<Item<E>> favorateList;

	public FavorateListImp() {
		// TODO Auto-generated constructor stub
		favorateList = new LinkedPositionList<Item<E>>();
	}

	public int size() {
		return favorateList.size();
	}

	public boolean isEmpty() {
		return favorateList.isEmpty();
	}

	public void access(E e) {
		Position<Item<E>> p = find(e);
		if (p == null) {
			Item<E> item = new Item<E>(e);
			p = favorateList.addLast(item);
		} else {
			p.getElement().increment();

		}
		moveUpOpe(p);

	}

	public E getValue(Position<Item<E>> p) {
		return p.getElement().value();
	}

	private Position<Item<E>> find(E e) {
		if (favorateList.isEmpty()) {
			return null;
		}
		Position<Item<E>> walker = favorateList.first();
		while (walker != favorateList.after(favorateList.last()) && !e.equals(getValue(walker))) {
			walker = favorateList.after(walker);
		}
		if (walker == favorateList.after(favorateList.last())) {
			return null;
		}

		return walker;
	}

	private int getCount(Position<Item<E>> p) {
		return p.getElement().getCount();
	}

	private void moveUpOpe(Position<Item<E>> p) {
		Position<Item<E>> walker = p;
		int cnt = getCount(p);
		if (favorateList.size() == 1) {
			return;
		}
		while (walker != favorateList.first() && cnt > getCount(favorateList.before(walker))) {
			// System.err.println("current walker is " + walker);
			walker = favorateList.before(walker);
		}

		if (walker != p) {
			favorateList.addBefore(walker, favorateList.remove(p));
		}

	}

	public Iterable<E> top(int k) {
		if (k < 0 || k > favorateList.size()) {
			throw new IllegalArgumentException();
		}
		Position<Item<E>> node = favorateList.first();
		PositionList<E> result = new LinkedPositionList<>();
		for (int i = 0; i < k; i++) {
			result.addLast(node.getElement().value());
			node = favorateList.after(node);
		}
		return result;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "";
		String s1 = "";
		Position<Item<E>> node = favorateList.first();
		if (node == null) {
			return s;
		}
		for (int i = 0; i < favorateList.size(); i++) {
			s += node.getElement().value();
			s += "<->";
			s1 += node.getElement().toString();
			node = favorateList.after(node);
		}
		return s + "\n" + s1;
	}

	private static class Item<E> {
		private E element;
		private int counter;

		public Item(E ele) {
			// TODO Auto-generated constructor stub
			element = ele;
			counter = 1;
		}

		public void increment() {
			++counter;
		}

		public E value() {
			return element;
		}

		public int getCount() {
			return counter;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			String string = "element is : " + element.toString() + ". access number is " + counter + "\n";
			return string;
		}

	}

}
