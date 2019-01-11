package com.local.coding.sudoku;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.local.coding.sudoku.Board;

public class BoardTest {

	private int[][] sudoku = { 
		{ 8, 6, 0, 0, 2, 0, 0, 0, 0 }, 
		{ 0, 0, 0, 7, 0, 0, 0, 5, 9 },
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
		{ 0, 0, 0, 0, 6, 0, 8, 0, 0 }, 
		{ 0, 4, 0, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 5, 3, 0, 0, 0, 0, 7 }, 
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
		{ 0, 2, 0, 0, 0, 0, 6, 0, 0 },
		{ 0, 0, 7, 5, 0, 9, 0, 0, 0 } 
	};

	private Board board;
	
	@Before
	public void initBoard() {
		board = new Board(sudoku);
	}

	@Test
	public void testGetRow() {
		int[] row5 = { 0, 0, 5, 3, 0, 0, 0, 0, 7 };
		assertTrue(Arrays.equals(row5, board.getRow(5)));
	}

	@Test
	public void testGetColumn() {
		int[] col5 = { 0, 0, 0, 0, 0, 0, 0, 0, 9 };
		assertTrue(Arrays.equals(col5, board.getColumn(5)));
	}

	@Test
	public void testGetRegion() {
		int[] region3 = { 0, 0, 0, 0, 5, 9, 0, 0, 0 };
		assertTrue(Arrays.equals(region3, board.getRegion(2, 8)));
	}

	@Test
	public void testGetCell() {
		assertEquals(4, board.getCell(4, 1));
	}

	@Test
	public void testSetCell() {
		board.setCell(4, 1, 2);
		assertEquals(2, board.getCell(4, 1));
	}

	@Test
	public void testToString() {
		final String expectedOutput = 
				" -------------------------\n" + 
				" | 8 6 0 | 0 2 0 | 0 0 0 |\n" + 
				" | 0 0 0 | 7 0 0 | 0 5 9 |\n" + 
				" | 0 0 0 | 0 0 0 | 0 0 0 |\n" + 
				" -------------------------\n" + 
				" | 0 0 0 | 0 6 0 | 8 0 0 |\n" + 
				" | 0 4 0 | 0 0 0 | 0 0 0 |\n" + 
				" | 0 0 5 | 3 0 0 | 0 0 7 |\n" + 
				" -------------------------\n" + 
				" | 0 0 0 | 0 0 0 | 0 0 0 |\n" + 
				" | 0 2 0 | 0 0 0 | 6 0 0 |\n" + 
				" | 0 0 7 | 5 0 9 | 0 0 0 |\n" + 
				" -------------------------\n"; 
		assertEquals(expectedOutput, board.toString());
	}
}
