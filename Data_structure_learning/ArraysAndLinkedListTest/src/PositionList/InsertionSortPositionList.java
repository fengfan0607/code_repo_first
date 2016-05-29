package PositionList;

import DoublyLinkedList.insertionSortofDoublyLinkedList;

public class InsertionSortPositionList {

	public static void insertSort(DoublyLinkedPositionList<Integer> list) {
		Position<Integer> marker = list.first();

		if (list.size() == 1) {
			return;
		}

		while (marker != list.last()) {
			Position<Integer> pivot = list.after(marker);
			int value = pivot.getElement();
			if (pivot.getElement() > marker.getElement()) {
				marker = pivot;
			} else {
				Position<Integer> walker = marker;
				while (walker != list.first() && list.before(walker).getElement() > value) {
					walker = list.before(walker);
				}
				list.remove(pivot);
				list.addBefore(walker, value);
			}
		}

	}
}
