package PositionList;

import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedPositionListTest {

	private DoublyLinkedPositionList<Integer> testList;

	@Before
	public void setUp() {
		testList = new DoublyLinkedPositionList<Integer>();
		testList.addFirst(8);
		testList.addFirst(10);
		testList.addFirst(4);
		testList.addFirst(1);
		testList.addFirst(5);
		System.err.println("curret list is :" + testList);

	}

	@Test
	public void testInsertSort() {
		InsertionSortPositionList.insertSort(testList);
		System.err.println("sorted list is : " + testList);
	}

}
