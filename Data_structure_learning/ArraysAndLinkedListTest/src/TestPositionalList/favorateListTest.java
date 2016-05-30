package TestPositionalList;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class favorateListTest {
	FavorateListImp<Integer> testList;

	@Before
	public void setup() {
		testList = new FavorateListImp<>();

	}

	@Test
	public void testAdd() {
		// System.err.println("current list is :" + testList.toString());
		testList.access(1);
		testList.access(2);
		testList.access(3);
		testList.access(4);
		testList.access(4);
		testList.access(4);
		testList.access(1);
		testList.access(1);
		testList.access(1);
		System.err.println("current list is : " + testList.toString());
		Iterator<Integer> iter = testList.top(3).iterator();
		int i = 1;
		while (iter.hasNext()) {
			System.err.println("top " + i + " is " + iter.next());
			i++;
		}
		testList.access(5);
		testList.access(5);
		testList.access(5);
		testList.access(5);
		testList.access(6);
		testList.access(6);
		testList.access(6);
		testList.access(1);
		testList.access(1);
		System.err.println("current list is : " + testList.toString());
		Iterator<Integer> iter1 = testList.top(3).iterator();
		int j = 1;
		while (iter1.hasNext()) {
			System.err.println("top " + j + " is " + iter1.next());
			j++;
		}
	}

}
