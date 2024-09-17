/* https://leetcode.com/problems/rotting-oranges/
994. Rotting Oranges - MEDIUM

Approach: At every second, all fresh oranges adjacent to rotten oranges get rotten, that is, 
the layer around rotten orange get rotten, leading to BFS.
Also, we need to get the minumun time to rot all oranges. This also points to bfs.
Start with all rotten oranges in queue, and count the number of fresh oranges.
Explore adjacent grids and if fresh, change it to rotten.
If at any point, the number of fresh oramges becomes 0, we can return the minutes.
The total minutes is the number of steps needed to reach all oranges from the start rotten oranges.

TC: O(m*n) => to traverse and find all rotten and fresh oranges,
SC: O(m*n) => all nodes at max
*/
import java.util.*;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
        
        if (grid == null || grid.length == 0) {
            return -1;
        }
        
        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i,j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        
        int mins = 0;
        
        while (!q.isEmpty()) {
            if (freshOranges == 0) {
                return mins;
            }
            
            mins++;
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                
                int[] p = q.remove();
                int x = p[0];
                int y = p[1];
            
                for (int[] dir: dirs) {
                   int r = x  + dir[0];
                   int c = y  + dir[1];

                    if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length) {
                        if (grid[r][c] == 1) {
                            grid[r][c] = 2;
                            freshOranges--;
                            q.offer(new int[] {r,c});
                        }
                    }
                }
            }            
        }
        
        return (freshOranges > 0) ? -1 : mins;
    }
}
