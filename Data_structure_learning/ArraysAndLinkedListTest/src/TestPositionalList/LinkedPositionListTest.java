package TestPositionalList;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class LinkedPositionListTest {

	private LinkedPositionList<Integer> test;
	private LinkedPositionList<Integer> test1;

	@Before
	public void setup() {
		test = new LinkedPositionList<>();
		test1 = new LinkedPositionList<>();

	}

	@Test
	public void testAdd() {
		Position<Integer> p1 = test.addFirst(1);
		System.err.println("position 1 is :" + p1);
		System.err.println("current list is: " + test);

		Position<Integer> p2 = test.addAfter(p1, 20);
		System.err.println("position 2 is :" + p2);
		System.err.println("current list is: " + test);

		Position<Integer> p3 = test.addAfter(p2, 30);
		System.err.println("position 3 is :" + p3);
		System.err.println("current list is: " + test);

		Position<Integer> p4 = test.addAfter(p1, 50);
		System.err.println("position 4 is :" + p4);
		System.err.println("current list is: " + test);

		test.remove(p3);
		System.err.println("removed position is :" + p3);
		System.err.println("current list is : " + test);

		test.set(p4, 5);
		System.err.println("current list is : " + test);

		Iterator<Integer> iter = test.iterator();
		int i = 1;
		while (iter.hasNext()) {
			System.err.println("current element of list " + i + " is " + iter.next());
			i++;
		}

	}

	@Test
	public void test1() {
		Position<Integer> p1 = test1.addLast(9);
		System.err.println("current list 1 is : " + test1);
		Iterator<Integer> iter = test1.iterator();
		int i = 1;
		while (iter.hasNext()) {
			System.err.println("current element of list " + i + " is " + iter.next());
			i++;
		}
		System.err.println("current list 1 is : " + test1);
	}

}
