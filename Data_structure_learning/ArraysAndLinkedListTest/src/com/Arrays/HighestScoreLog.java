package com.Arrays;

import java.net.Inet4Address;

import org.junit.validator.PublicClassValidator;

public class HighestScoreLog {

	private static final int MAXIMUM_Length = 10;
	private int numberOfEntries;
	private GameEntry[] entries;

	public HighestScoreLog() {
		// TODO Auto-generated constructor stub
		entries = new GameEntry[MAXIMUM_Length];
		numberOfEntries = 0;
	}

	public void add(GameEntry entry) {
		if (numberOfEntries == MAXIMUM_Length) {
			if (entry.compareTo(entries[MAXIMUM_Length - 1]) <= 0) {
				return;
			}
		} else {
			numberOfEntries++;
		}
		int i = numberOfEntries - 1;
		for (; i >= 1 && (entry.compareTo(entries[i - 1]) >= 0); i--) {
			entries[i] = entries[i - 1];
		}
		entries[i] = entry;
	}

	public GameEntry remove(int i) {
		GameEntry removerdEntry;
		if (i >= numberOfEntries) {
			throw new IndexOutOfBoundsException("index out of bounds");
		}
		removerdEntry = entries[i];
		int j = i;
		for (; j < numberOfEntries - 1; j++) {
			entries[j] = entries[j + 1];
		}
		entries[j] = null;
		numberOfEntries--;
		return removerdEntry;
	}

	@Override
	public String toString() {
		String s = "number of entries: " + numberOfEntries + "[";
		for (int i = 0; i < numberOfEntries; i++) {
			s += entries[i];
			s += ",";
		}
		return s += "]";
	}

	public GameEntry[] getEntries() {
		return this.entries;
	}

}
