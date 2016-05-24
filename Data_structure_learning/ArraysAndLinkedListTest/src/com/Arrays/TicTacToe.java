package com.Arrays;

import java.awt.Window;

public class TicTacToe {

	private int[][] board;

	private int x = 1;
	private int o = -1;
	private int empty = 0;
	private int player;
	private int[][] sumMatrix;

	public TicTacToe() {
		board = new int[3][3];
		sumMatrix = new int[3][3];
		player = x;
	}

	private void makeStep(int posX, int posY) {
		if (checkBounds(posX, posY)) {
			throw new IllegalArgumentException("index out of bounds");
		}
		if (board[posX][posY] == empty) {
			board[posX][posY] = player;
			player = -player;
		} else {
			throw new IllegalArgumentException("position is not empty");
		}
	}

	private boolean checkBounds(int i, int j) {
		if (i < 0 || i > 3 || j < 0 || j > 2) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isWin(int marker) {

		for (int i = 0; i < sumMatrix.length; i++) {
			for (int j = 0; j < sumMatrix[0].length; j++) {
				if (sumMatrix[i][j] == marker) {
					return true;
				}
			}
		}
		return false;

	}

	private void getSumMatrix() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				sumMatrix[0][i] += board[i][j];
				sumMatrix[1][i] += board[j][i];
				if (i - j == 0) {
					sumMatrix[2][0] += board[i][j];
				}
				if ((i + j) == 2) {
					sumMatrix[2][1] += board[i][j];
				}

			}
		}
		System.err.println(toStringSum());
	}

	private int winners() {
		getSumMatrix();
		if (isWin(o * 3)) {
			return o;
		} else if (isWin(x * 3)) {
			return x;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String string = "";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 0) {
					string += " ";
					continue;
				} else if (board[i][j] == x) {
					string += "X";
				} else if (board[i][j] == o) {
					string += "Q";
				}
				if (j < 2) {
					string += "|";
				}
			}
			if (i <= 2) {
				string += "\n------------\n";
			}
		}
		return string;
	}

	public String toStringSum() {
		// TODO Auto-generated method stub
		String string = "";
		for (int i = 0; i < sumMatrix.length; i++) {
			for (int j = 0; j < sumMatrix[0].length; j++) {
				string += sumMatrix[i][j];
				if (j < 2) {
					string += "|";
				}

			}
			if (i <= 2) {
				string += "\n**************\n";
			}
		}
		return string;
	}

	public static void main(String[] args) {
		TicTacToe ticTacToe = new TicTacToe();
		ticTacToe.makeStep(2, 0);
		ticTacToe.makeStep(1, 1);
		ticTacToe.makeStep(0, 2);
		ticTacToe.makeStep(2, 2);
		ticTacToe.makeStep(1, 2);
		ticTacToe.makeStep(0, 0);
		ticTacToe.makeStep(1, 0);
		ticTacToe.makeStep(0, 1);
		ticTacToe.makeStep(2, 1);

		System.err.println(ticTacToe.toStringSum());
		System.err.println(ticTacToe.toString());

		int winner = ticTacToe.winners();
		if (winner != 0) {
			System.err.println("winner is: " + winner);

		} else {
			System.err.println("there is a tie");
		}
	}
}
