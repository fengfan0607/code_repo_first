package com.linkedList;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class testMySinglyList {
	private static final int LONG_LIST_LENGTH = 10;

	SinglyList<String> shortList;
	SinglyList<String> shortList1;
	SinglyList<Integer> emptyList;
	SinglyList<Integer> longerList;
	SinglyList<Integer> list1;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
		shortList = new SinglyList<String>();
		emptyList = new SinglyList<>();
		shortList.addFirst("A");
		shortList.addFirst("B");
		shortList.addFirst("C");
		shortList.addFirst("E");
		shortList.addFirst("W");
		// System.err.println("add first" + shortList.toString());
		shortList1 = new SinglyList<String>();
		shortList1.addLast("A");
		shortList1.addLast("B");
		shortList1.addLast("C");
		shortList1.addLast("D");

		// System.err.println("add last " + shortList1.toString());
	}

	// @Test
	public void testAdd() {
		System.err.println(shortList.toString());
		System.err.println(shortList1.toString());

	}

	// @Test
	public void testGet() {
		assertEquals("check first element in shrotlist1", "E", shortList.get(0));
		System.err.println(shortList1.get(shortList1.size() - 1));
	}

	@Test
	public void testReverse() {
		System.err.println("before reverse shortList: " + shortList.toString());
		System.err.println(
				"after reverse shortList: " + SinglyListOpe.printList(SinglyListOpe.reverseList(shortList.getHead())));

		System.err.println("before reverse shortList1: " + shortList1.toString());
		System.err.println("after reverse shortList1: "
				+ SinglyListOpe.printList(SinglyListOpe.reverseList(shortList1.getHead())));

	}

	@Test
	public void testMiddlePointSeach() {
		System.err.println("shortList: " + shortList1.toString());
		// System.err.println("the middle point is: " +
		// shortList1.get(shortList1.middlePointSerch(shortList1.getHead())));
		System.err.println(
				"the middle point is: " + shortList1.get(SinglyListOpe.middlePointSerch(shortList1.getHead())));

		System.err.println("shortList: " + shortList.toString());
		System.err
				.println("the middle point is: " + shortList.get(SinglyListOpe.middlePointSerch(shortList.getHead())));

	}

	@Test
	public void testMergeTwoList() {
		System.err.println("shortList: " + shortList.toString());
		System.err.println("shortList1: " + shortList1.toString());
		System.err.println("merged list"
				+ SinglyListOpe.printList(SinglyListOpe.mergeList(shortList.getHead(), shortList1.getHead())));
	}

}
