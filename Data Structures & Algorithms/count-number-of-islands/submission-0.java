class Solution {
    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int count=0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                if(!visited[i][j] && grid[i][j]=='1') {
                    dfs(grid, visited, i, j, m, n);
                    count++;
                }
            }
        }

        return count;
        
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j, int m, int n) {

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i, j));

        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            int row = p.row;
            int col = p.col;
            visited[row][col] = true;

            checkNeighbours(grid, visited, row, col+1, m, n, queue);
            checkNeighbours(grid, visited, row, col-1, m, n, queue);
            checkNeighbours(grid, visited, row+1, col, m, n, queue);
            checkNeighbours(grid, visited, row-1, col, m, n, queue);
        }
        
    }
    // row, col+1
    // row, col-1
    // row+1, col
    // row-1, col
    private void checkNeighbours(char[][] grid, boolean[][] visited, int i, int j, 
                            int m, int n, Queue<Pair> queue) {
        
        if((i>=0 && i<m) && (j>=0 && j<n) && (!visited[i][j] && grid[i][j]=='1')) {
            queue.add(new Pair(i, j));
        }
    }

    class Pair {
        int row;
        int col;
        Pair(int i, int j) {
            row=i;
            col=j;
        }
    }
}
