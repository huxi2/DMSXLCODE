package backTrack;

import org.junit.Test;

public class SolveSudoku {

    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    public boolean backtrack(char[][] board) {
        for (int rowId = 0; rowId < 9; rowId++) {
            for (int colId = 0; colId < 9; colId++) {
                if (board[rowId][colId] != '.') continue;
                for (char num = '1'; num <= '9'; num++) {
                    if (!isValid(board, rowId, colId, num)) continue;//尝试解题
                    board[rowId][colId] = num;
                    if (backtrack(board)) return true;
                    board[rowId][colId] = '.';
                }
                return false;//无解
            }
        }
        return true;
    }


    //验证char[][] board 是否合法
    public boolean isValid(char[][] board, int rowId, int colId, char num) {
        //垂直、水平方向
        for (int i = 0; i < 9; i++) {
            if (board[i][colId] == num) return false;
            if (board[rowId][i] == num) return false;
        }
        //九宫格
        int ci = (rowId / 3) * 3;
        int cj = (colId / 3) * 3;
        for (int i = ci; i < ci + 3; i++) {
            for (int j = cj; j < cj + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }
}

