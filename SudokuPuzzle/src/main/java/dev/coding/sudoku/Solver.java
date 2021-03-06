package dev.coding.sudoku;

/**
 * This class uses Backtracking Recursive algorithm to solve the Sudoku puzzle.
 */
class Solver {

	private final Board board;

	/**
	 * Constructor
	 * 
	 * @param input a 9x9 array representing a sudoku, empty cells are 0
	 */
	Solver(int[][] input) {
		this.board = new Board(input);
	}

	/**
	 * Method to solve the sudoku "in-place" (without creating/copying with a new
	 * array)
	 * 
	 * @return true if the sudoku is successfully solved
	 */
	boolean solve() {
		return solve(0, 0);
	}

	/**
	 * Returns the board object, useful for pretty-printing of the sudoku
	 */
	Board getBoard() {
		return board;
	}

	/**
	 * Backtracking recursive algorithm to solve sudoku
	 */
	private boolean solve(int row, int col) {
		if (row == Board.GRID_SIZE) {
			row = 0;
			if (++col == Board.GRID_SIZE) {
				return true;
			}
		}
		if (board.getCell(row, col) != Board.EMPTY_CELL) {
			return solve(row + 1, col);
		}
		// For all possible values
		for (int val = 1; val <= Board.GRID_SIZE; val++) {
			if (isMoveOK(row, col, val)) {
				board.setCell(row, col, val);
				if (solve(row + 1, col)) {
					return true;
				}
			}
		}
		// Reset the cell to EMPTY to do recursive backtrack and try again
		board.setCell(row, col, Board.EMPTY_CELL);
		return false;
	}

	private boolean isMoveOK(int row, int col, int val) {
		return !(arrayContains(board.getRow(row), val) || arrayContains(board.getColumn(col), val)
				|| arrayContains(board.getRegion(row, col), val));
	}

	private boolean arrayContains(int[] array, int val) {
		for (int arrayVal : array) {
			if (arrayVal == val) {
				// return true and stop the iteration
				return true;
			}
		}
		return false;
	}

}
