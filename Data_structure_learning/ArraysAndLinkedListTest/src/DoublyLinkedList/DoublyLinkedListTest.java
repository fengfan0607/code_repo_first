package DoublyLinkedList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListTest {
	DoublyLinkedList<String> testList;
	DoublyLinkedList<String> emptyList;
	insertionSortofDoublyLinkedList insertSort;
	DoublyLinkedList<Integer> intList;

	@Before
	public void setUp() {
		testList = new DoublyLinkedList<String>();
		emptyList = new DoublyLinkedList<>();
		intList = new DoublyLinkedList<Integer>();
		testList.add("A");
		testList.add("B");

	}

	// @Test
	public void testAdd() {
		System.err.println("test list is : " + testList.toString());
		testList.add(0, "C");
		System.err.println("add at position 0: " + testList.toString());
		testList.add(2, "D");
		System.err.println("again add at position 2: " + testList.toString());
	}

	// @Test
	public void testGet() {
		assertEquals("check first element", "A", testList.get(0));
		// assertEquals("check empty list", null, emptyList.get(0));
		// check git update correctly +++
	}

	// @Test
	public void testRemove() {
		System.err.println("before remove: " + testList.toString());
		testList.remove(0);
		System.err.println("after remove: " + testList.toString());
	}

	@Test
	public void testSort() {
		intList.add(5);
		intList.add(6);
		System.err.println("before sort: " + intList.toString());
		insertSort.insertionSort(intList);
		System.err.println("after sort: " + intList.toString());
		intList.add(7);
		intList.add(100);

		System.err.println("before sort: " + intList.toString());
		insertSort.insertionSort(intList);
		System.err.println("after sort: " + intList.toString());

	}

}
