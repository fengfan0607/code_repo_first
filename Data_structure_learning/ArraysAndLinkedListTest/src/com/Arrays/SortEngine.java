package com.Arrays;

public class SortEngine {

	GameEntry[] entries;

	public SortEngine(GameEntry[] entries) {
		// TODO Auto-generated constructor stub
		this.entries = entries;
	}

	public void insertSort() {
		for (int i = 1; i < entries.length; i++) {
			for (int j = 0; j < i; j++) {
				if (less(i, j)) {
					swap(i, j);
				}
			}
		}

	}

	private void swap(int i, int j) {

		GameEntry temp = entries[i];
		entries[i] = entries[j];
		entries[j] = temp;
	}

	private boolean less(int i, int j) {
		int n = entries[i].compareTo(entries[j]);
		if (n >= 0) {
			return false;
		} else {
			return true;
		}
	}

}
