class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0)
                    visit(matrix, i, j, 0, visited);
            }
        }
        return matrix;
    }

    private void visit(int[][] matrix, int i, int j, int step, boolean[][] visited) {
        if (matrix[i][j] == 0 && step > 0) return;
        if (visited[i][j] && matrix[i][j] <= step) return;
        visited[i][j] = true;
        matrix[i][j] = step;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length) {
                if(!visited[i][j])
                    visit(matrix, x, y, step + 1, visited);
            }
        }
        visited[i][j] = false;
    }
}
