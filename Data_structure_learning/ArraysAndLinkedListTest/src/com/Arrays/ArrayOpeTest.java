package com.Arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ArrayOpeTest {
	String[] names = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
	int[] scores = { 2, 3, 4, 5, 10, 20, 30, 35, 999, 10000 };
	List<GameEntry> testEntries;
	HighestScoreLog scoreLog;
	SortEngine sortEngine;

	@Before
	public void setup() {
		testEntries = new ArrayList<>();
		for (int i = 0; i < names.length; i++) {
			String name = names[i];
			int score = scores[i];
			GameEntry entry = new GameEntry(name, score);
			testEntries.add(entry);
		}
		scoreLog = new HighestScoreLog();
		for (GameEntry enrty : testEntries) {
			scoreLog.add(enrty);
		}
		System.err.println(scoreLog.toString());
	}

	@Test
	public void testAdd() {
		GameEntry addEntry = new GameEntry("test", 400);
		scoreLog.add(addEntry);
		System.err.println(scoreLog.toString());
	}

	@Test
	public void testRemove() {
		int removeIndex = 4;
		GameEntry removerdEnrtry = scoreLog.remove(removeIndex);
		System.err.println("removed entry: " + removerdEnrtry + "\n" + scoreLog.toString());
		int removeIndex1 = 8;
		GameEntry removerdEnrtry1 = scoreLog.remove(removeIndex1);
		System.err.println("removed entry: " + removerdEnrtry1 + "\n" + scoreLog.toString());
	}

	@Test
	public void testInsertionSort() {
		sortEngine = new SortEngine(scoreLog.getEntries());
		System.err.println("before sort : " + "\n" + scoreLog.toString());
		sortEngine.insertSort();
		System.err.println("increasing order sort is : " + "\n" + scoreLog.toString());
	}
}
