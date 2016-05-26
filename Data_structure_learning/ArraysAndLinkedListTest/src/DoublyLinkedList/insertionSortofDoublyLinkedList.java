package DoublyLinkedList;

public class insertionSortofDoublyLinkedList {

	public static void insertionSort(DoublyLinkedList<Integer> list) {
		if (list.size() <= 1) {
			return;
		}
		Node<Integer> outerLoop = list.getHead().getNext();
		Node<Integer> innerLoop;
		while (outerLoop.getNext() != list.getTail()) {
			outerLoop = outerLoop.getNext();
			innerLoop = outerLoop;
			while (innerLoop.getPrev() != list.getHead()) {
				Node<Integer> currentNode = innerLoop;
				Node<Integer> preNode = innerLoop.getPrev();
				if (currentNode.getData() > preNode.getData()) {
					int temp = currentNode.getData();
					currentNode.setData(preNode.getData());
					preNode.setData(temp);
					innerLoop = innerLoop.getPrev();
				} else {
					break;
				}
			}

		}

	}

}
