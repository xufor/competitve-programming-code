import java.util.LinkedList;

class Solution {
    public boolean isValidNeighbour(int i, int j, char[][] grid) {
        return (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1');
    }
    
    public void bfs(char[][] grid, int i, int j) {
        var queue = new LinkedList<Integer[]>();
        queue.addLast(new Integer[] {i, j});
        grid[0][0] = '0';

        
        while(!queue.isEmpty()) {
            var coord = queue.removeFirst();
            int x = coord[0], y = coord[1];
            // Integer[][] neighbours = {{x-1, y-1}, {x-1, y}, {x-1, y+1}, {x, y-1}, {x, y+1}, {x+1, y-1}, {x+1, y}, {x+1, y+1}};
            Integer[][] neighbours = {{x-1, y}, {x, y-1}, {x, y+1}, {x+1, y}};
            
            for(Integer[] neighbour: neighbours) {
                if(isValidNeighbour(neighbour[0], neighbour[1], grid)) {
                    queue.addLast(neighbour);
                    grid[neighbour[0]][neighbour[1]] = '0';
                }
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }
}