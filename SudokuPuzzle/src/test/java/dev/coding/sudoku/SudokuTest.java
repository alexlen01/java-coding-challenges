package dev.coding.sudoku;

import org.junit.Test;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SudokuTest {

    private static final Logger logger = LoggerFactory.getLogger(SudokuTest.class);

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


    @Test
    public void testSudoku() {
        int repeatTimes = 10;
        for (int i = 0; i < repeatTimes; i++) {
            int[][] b = randomBoard();

            System.out.format("Sudoku %s:\n\n", String.valueOf(i + 1));
            System.out.format("(puzzle)\n%s\n", Sudoku.asString(b));

            if (Sudoku.solve(b)) {
                System.out.format("(solved)\n%s\n", Sudoku.asString(b));
            } else {
                System.err.println(Board.ERROR_MSG_SIZE);
            }
        }
    }

    private int[][] randomBoard() {
        int p = 1;
        int firstval = new Random().nextInt(8);
        while (p == 1) {
            int x = firstval, v = 1;
            int[][] a = new int[9][9];
            int[][] b = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if ((x + j + v) <= 9) {
                        a[i][j] = j + x + v;
                    } else {
                        a[i][j] = j + x + v - 9;
                    }
                    if (a[i][j] == 10) {
                        a[i][j] = 1;
                    }
                }
                x += 3;
                if (x >= 9) {
                    x = x - 9;
                }
                if (i == 2) {
                    v = 2;
                    x = firstval;
                }
                if (i == 5) {
                    v = 3;
                    x = firstval;
                }
            }
            int res = (int) (Math.random() * 2 + 1); // will return either 1 or 2
            switch (res) {
                case 1:
                    b[0][0] = a[0][0];
                    b[8][8] = a[8][8];
                    b[0][3] = a[0][3];
                    b[0][4] = a[0][4];
                    b[1][2] = a[1][2];
                    b[1][3] = a[1][3];
                    b[1][6] = a[1][6];
                    b[1][7] = a[1][7];
                    b[2][0] = a[2][0];
                    b[2][4] = a[2][4];
                    b[2][8] = a[2][8];
                    b[3][2] = a[3][2];
                    b[3][8] = a[3][8];
                    b[4][2] = a[4][2];
                    b[4][3] = a[4][3];
                    b[4][5] = a[4][5];
                    b[4][6] = a[4][6];
                    b[5][0] = a[5][0];
                    b[5][6] = a[5][6];
                    b[6][0] = a[6][0];
                    b[6][4] = a[6][4];
                    b[6][8] = a[6][8];
                    b[7][1] = a[7][1];
                    b[7][2] = a[7][2];
                    b[7][5] = a[7][5];
                    b[7][6] = a[7][6];
                    b[8][4] = a[8][4];
                    b[8][5] = a[8][5];
                    return b;
                case 2:
                    b[0][3] = a[0][3];
                    b[0][4] = a[0][4];
                    b[1][2] = a[1][2];
                    b[1][3] = a[1][3];
                    b[1][6] = a[1][6];
                    b[1][7] = a[1][7];
                    b[1][8] = a[1][8];
                    b[2][0] = a[2][0];
                    b[2][4] = a[2][4];
                    b[2][8] = a[2][8];
                    b[3][2] = a[3][2];
                    b[3][5] = a[3][5];
                    b[3][8] = a[3][8];
                    b[4][0] = a[4][0];
                    b[4][2] = a[4][2];
                    b[4][3] = a[4][3];
                    b[4][4] = a[4][4];
                    b[4][5] = a[4][5];
                    b[4][6] = a[4][6];
                    b[5][0] = a[5][0];
                    b[5][1] = a[5][1];
                    b[5][4] = a[5][4];
                    b[5][6] = a[5][6];
                    b[6][0] = a[6][0];
                    b[6][4] = a[6][4];
                    b[6][6] = a[6][6];
                    b[6][8] = a[6][8];
                    b[7][0] = a[7][0];
                    b[7][1] = a[7][1];
                    b[7][2] = a[7][2];
                    b[7][5] = a[7][5];
                    b[7][6] = a[7][6];
                    b[8][2] = a[8][2];
                    b[8][4] = a[8][4];
                    b[8][5] = a[8][5];
                    return b;
                default:
                    break;
            }
        }
        return sudoku;
    }
}
