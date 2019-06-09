package dev.coding.sudoku;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class SolverTest {

    private int[][] sudoku = {
            {8, 6, 0, 0, 2, 0, 0, 0, 0},
            {0, 0, 0, 7, 0, 0, 0, 5, 9},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 6, 0, 8, 0, 0},
            {0, 4, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 5, 3, 0, 0, 0, 0, 7},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 2, 0, 0, 0, 0, 6, 0, 0},
            {0, 0, 7, 5, 0, 9, 0, 0, 0}
    };

    private int[] sortedLine = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    private Solver solver;

    @Before
    public void initSolver() {
        solver = new Solver(sudoku);
    }

    @Test
    public void testSolve() {
        solver.solve();
        verifySolved(sudoku);
    }

    @Test
    public void testGetBoard() {
        Board b = solver.getBoard();
        for (int i = 0; i < Board.GRID_SIZE; i++) {
            assertArrayEquals(sudoku[i], b.getRow(i));
        }
    }

    private void verifySolved(int[][] toVerify) {
        Board b = new Board(toVerify);
        // Check all lines and columns
        for (int i = 0; i < Board.GRID_SIZE; i++) {
            assertTrue(isArrayOk(b.getRow(i)));
            assertTrue(isArrayOk(b.getColumn(i)));
        }
        // Check all regions
        for (int x = 0; x < Board.REGION_SIZE; x++) {
            for (int y = 0; y < Board.REGION_SIZE; y++) {
                int row = x * Board.REGION_SIZE;
                int col = y * Board.REGION_SIZE;
                assertTrue(isArrayOk(b.getRegion(row, col)));
            }
        }
    }

    private boolean isArrayOk(int[] toVerify) {
        int[] copy = Arrays.copyOf(toVerify, Board.GRID_SIZE);
        Arrays.sort(copy);
        return Arrays.equals(sortedLine, copy);
    }

}
