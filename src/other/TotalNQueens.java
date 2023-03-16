package other;

public class TotalNQueens {
    int ans = 0;
    int[][] map;

    public int totalNQueens(int n) {
        if (n <= 1) return n;
        map = new int[n][n];//表明n皇后的位置
        countQueens(0);
        return ans;
    }

    public void countQueens(int row) {
        if (row == map.length) {
            ans++;
            return;
        }
        for (int col = 0; col < map.length; col++) {
            if (isValid(row, col)) {//当前位置合法
                map[row][col] = 1;
                countQueens(row + 1);
                map[row][col] = 0;
            }
        }
    }

    public boolean isValid(int row, int col) {
        for (int i = 0; i < map.length; i++) {// 行列
            if (i >= row && i >= col) break;
            if (i != row && map[i][col] == 1) return false;
            if (i != col && map[row][i] == 1) return false;
        }
        //对角线方向 只需要判断左上和右上
        for (int i = 1; i < map.length; i++) {
            if (row - i >= 0 && col - i >= 0 && map[row - i][col - i] == 1) return false;//左上
            if (row - i >= 0 && col + i < map.length && map[row - i][col + i] == 1) return false;//右上
        }
        return true;
    }
}
