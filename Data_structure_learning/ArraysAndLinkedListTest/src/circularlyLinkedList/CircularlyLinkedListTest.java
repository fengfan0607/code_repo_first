package circularlyLinkedList;

import org.junit.Before;
import org.junit.Test;

public class CircularlyLinkedListTest {

	CircularlyLinkedList<String> testList;

	@Before
	public void setup() {
		testList = new CircularlyLinkedList<>();
		testList.add("A");
		testList.add("B");

	}

	@Test
	public void testAdd() {
		testList.add("A");
		testList.add("B");
		System.err.println("circularlyList is: " + testList.toString());
	}

	@Test
	public void testRemove() {
		testList.remove();
		System.err.println("circularlyList is: " + testList.toString());
	}

}
