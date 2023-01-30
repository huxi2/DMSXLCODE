package backTrack;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveNQueens {
    char[][] matrix;
    List<List<String>> ans;

    public List<List<String>> solveNQueens(int n) {
        matrix = new char[n][n];
        for (char[] c : matrix) Arrays.fill(c, '.');
        ans = new ArrayList<>();
        backtrack(0, n);
        return ans;
    }

    public void backtrack(int rowId, int n) {
        if (rowId == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(matrix[i]));
            }
            ans.add(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(rowId, i)) {
                matrix[rowId][i] = 'Q';
                backtrack(rowId + 1, n);
                matrix[rowId][i] = '.';
            }
        }
    }

    public boolean isValid(int rowId, int colId) {
        //横竖
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[rowId][i] == 'Q' || matrix[i][colId] == 'Q') return false;
        }
        //左上
        for (int i = rowId - 1, j = colId - 1; i >= 0 && j >= 0; i--, j--) {
            if (matrix[i][j] == 'Q') return false;
        }
        // 右上
        for (int i = rowId - 1, j = colId + 1; i >= 0 && j < matrix.length; i--, j++) {
            if (matrix[i][j] == 'Q') return false;
        }
        return true;
    }
}
