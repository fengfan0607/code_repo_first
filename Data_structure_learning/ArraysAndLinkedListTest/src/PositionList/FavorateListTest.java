package PositionList;

import org.junit.Before;
import org.junit.Test;

import conm.moveToFront.FavoriteList;

public class FavorateListTest {

	FavoriteList<Integer> list;

	@Before
	public void setUp() {

		list = new FavoriteList<Integer>();
		list.accsee(1);
		;

	}

	@Test
	public void test() {
		System.err.println("the favorate list right now is: " + list.toString());
	}

}
