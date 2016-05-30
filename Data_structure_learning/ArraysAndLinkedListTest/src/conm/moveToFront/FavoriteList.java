package conm.moveToFront;

import java.awt.event.ItemEvent;
import java.util.Iterator;

import org.junit.internal.Throwables;
import org.junit.validator.PublicClassValidator;

import PositionList.DoublyLinkedPositionList;
import PositionList.Position;
import PositionList.PositionList;

public class FavoriteList<E> {

	PositionList<Item<E>> favoriteList;

	public FavoriteList() {
		// TODO Auto-generated constructor stub
		favoriteList = new DoublyLinkedPositionList<>();
	}

	public E getValue(Position<Item<E>> p) {

		return p.getElement().getData();

	}

	public int count(Position<Item<E>> p) {

		return p.getElement().getCoutner();

	}

	public Position<Item<E>> findPos(E e) {
		Position<Item<E>> walker = favoriteList.first();
		while (walker != null && walker.getElement().getData() != e) {
			walker = favoriteList.after(walker);
		}
		return walker;
	}

	public void moveUp(Position<Item<E>> p) {

		int count = count(p);
		Position<Item<E>> walker = favoriteList.first();
		while (walker != null && walker.getElement().getCoutner() > count) {
			walker = favoriteList.after(walker);
		}
		if (walker != p) {
			favoriteList.addAfter(p, favoriteList.remove(p));
		}
	}

	public int size() {
		return favoriteList.size();
	}

	public boolean isEmpty() {
		return (size() == 0);

	}

	public void accsee(E e) {
		Position<Item<E>> position = findPos(e);
		if (position == null) {
			favoriteList.addLast(new Item<E>(e));
		} else {
			position.getElement().increamentCoundter();
			moveUp(position);
		}
	}

	public void remove(E e) {

		Position<Item<E>> position = findPos(e);
		if (position == null) {
			return;
		} else {
			favoriteList.remove(position);
		}

	}

	public Iterable<E> getFavorite(int k) {

		if (k <= 0 || k >= size()) {
			throw new IllegalArgumentException();
		}
		PositionList<E> result = new DoublyLinkedPositionList<>();
		Iterator<Item<E>> iter = favoriteList.iterator();
		for (int i = 0; i < k; i++) {
			result.addLast(iter.next().getData());
		}
		return (Iterable<E>) result;

	}

	protected static class Item<E> {
		E data;
		int coutner;

		public Item(E data) {
			// TODO Auto-generated constructor stub
			data = data;
			coutner = 0;
		}

		public int getCoutner() {
			return coutner;
		}

		public void increamentCoundter() {
			coutner++;
		}

		public E getData() {
			return data;
		}

	}

}
