package com.Arrays;

import java.util.Comparator;
import java.util.jar.Attributes.Name;

public class GameEntry implements Comparable<GameEntry> {
	private String name;
	private int score;

	public GameEntry() {
		// TODO Auto-generated constructor stub
		super();
	}

	public GameEntry(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + name + " , " + score + ")";
	}

	@Override
	public int compareTo(GameEntry o) {
		// TODO Auto-generated method stub
		return this.score - o.getScore();
	}

}
