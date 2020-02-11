package com.rs.algos.neatcode.arrays;

public class ValidSudoku {

    public boolean isValidPos(char[][] board, int a, int b) {
        char c = board[a][b];
        for (int i = 0; i < 9; i++) {
            if (i != b && c == board[a][i]) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (i != a && c == board[i][b]) {
                return false;
            }
        }

        int p = a - a % 3;
        int q = b - b % 3;

        for (int i = p; i < 3 + p; i++) {
            for (int j = q; j < 3 + q; j++) {
                if (!(i == a && j == b) && c == board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!isValidPos(board, i, j)) return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] arr = {{'1', '2', '3', '4', '5', '6', '7', '8', '9'},
                {'4', '5', '6', '1', '2', '3', '4', '5', '6'},
                {'4', '5', '6', '1', '2', '3', '4', '5', '6'},
                {'4', '5', '6', '1', '2', '3', '4', '5', '6'},
                {'4', '5', '6', '1', '2', '3', '4', '5', '6'},
                {'4', '5', '6', '1', '2', '3', '4', '5', '6'},
                {'4', '5', '6', '1', '2', '3', '4', '5', '6'},
                {'4', '5', '6', '1', '2', '3', '4', '5', '6'},
                {'4', '5', '6', '1', '2', '3', '4', '5', '6'}
        };
        System.out.println((new ValidSudoku()).isValidSudoku(arr));
    }
}

