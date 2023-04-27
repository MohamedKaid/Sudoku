package soduko;

import java.util.Random;

public class SudokuGenerator{
    private static final int SIZE = 9;
    private static final int BOX_SIZE = 3;
    private static final Random random = new Random();
    private static final Random rad = new Random();


    public static int[][] generate() {
        int[][] grid = new int[SIZE][SIZE];

        // Fill in diagonal 3x3 boxes
        for (int i = 0; i < SIZE; i += BOX_SIZE) {
            fillBox(grid, i, i);
        }

        // Fill in remaining cells
        fillRemaining(grid, 0, BOX_SIZE);

        return grid;
    }

    private static void fillBox(int[][] grid, int row, int col) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        shuffleArray(nums);
        int index = 0;
        for (int i = row; i < row + BOX_SIZE; i++) {
            for (int j = col; j < col + BOX_SIZE; j++) {
                grid[i][j] = nums[index];
                index++;
            }
        }
    }

    private static boolean fillRemaining(int[][] grid, int row, int col) {
        if (col >= SIZE && row < SIZE - 1) {
            row++;
            col = 0;
        }
        if (row >= SIZE && col >= SIZE) {
            return true;
        }
        if (row < BOX_SIZE) {
            if (col < BOX_SIZE) {
                col = BOX_SIZE;
            }
        } else if (row < SIZE - BOX_SIZE) {
            if (col == (int)(row / BOX_SIZE) * BOX_SIZE) {
                col += BOX_SIZE;
            }
        } else {
            if (col == SIZE - BOX_SIZE) {
                row++;
                col = 0;
                if (row >= SIZE) {
                    return true;
                }
            }
        }

        for (int num = 1; num <= SIZE; num++) {
            if (isValid(grid, row, col, num)) {
                grid[row][col] = num;
                if (fillRemaining(grid, row, col + 1)) {
                    return true;
                }
                grid[row][col] = 0;
            }
        }
        return false;
    }

    private static boolean isValid(int[][] grid, int row, int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (grid[row][i] == num || grid[i][col] == num) {
                return false;
            }
        }
        int boxRow = row - row % BOX_SIZE;
        int boxCol = col - col % BOX_SIZE;
        for (int i = boxRow; i < boxRow + BOX_SIZE; i++) {
            for (int j = boxCol; j < boxCol + BOX_SIZE; j++) {
                if (grid[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void shuffleArray(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
