package aod.nb23;

import java.util.Scanner;

/**
 *
 * @author Tobias Johansson <tobias@johansson.xyz>
 */
public class EightQueens {
    
    boolean board[][];
    int solutions;
    int N;

    public void solve() {
        System.out.print("[Welcome to N Queens]\nEnter desired N: ");
        Scanner scanIn = new Scanner(System.in);
        N = scanIn.nextInt();
        board = new boolean[N][N];
        solutions = 0;
        addQueen(0);
        System.out.println("\nNumber of solutions: " + solutions);
    }

    private void addQueen(int row) {
        for (int col = 0; col <= N-1; col++) {
            if (possible(row, col)) {
                reserve(row, col);
                if (row == N-1) {
                    printSolution();
                    solutions++;
                } else {
                    addQueen(row + 1);
                }
                cancel(row, col);
            }
        }
    }

    private boolean possible(int row, int col) {
        int i, j;

        // check col
        for (i = 0; i <= N-1; i++) {
            if (board[i][col] == true) {
                return false;
            }
        }

        // check row
        for (j = 0; j <= N-1; j++) {
            if (board[row][j] == true) {
                return false;
            }
        }

        // check diagonals
        for (i = row - col, j = 0; j <= N-1; i++, j++) {
            if (i >= 0 && i <= N-1) {
                if (board[i][j] == true) {
                    return false;
                }
            }
        }
        for (i = 0, j = row + col; i <= N-1; i++, j--) {
            if (j >= 0 && j <= N-1) {
                if (board[i][j] == true) {
                    return false;
                }
            }
        }

        return true;
    }

    private void reserve(int row, int col) {
        board[row][col] = true;
    }

    private void cancel(int row, int col) {
        board[row][col] = false;
    }

    private void printSolution() {
        System.out.println("\nSolution:");
        for (int i = 0; i <= N-1; i++) {
            for (int j = 0; j <= N-1; j++) {
                System.out.print(board[i][j] ? "O " : "# ");
            }
            System.out.println();
        }
    }

} 
