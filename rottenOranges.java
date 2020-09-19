// Time Complexity :O(m*n) because of the for loop or if all the oranges are rotten
// Space Complexity : O(m*n) because of queue 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/**
 * First we traverse the entire matirx and add the x,y coordinates of all the
 * 2s, and fresh++ for all the 1s if fresh =0 , we return 0
 * 
 * 
 * we begin level order traversal , for each level(while loop) we do time++ when
 * we go thorugh each element(x,y) in a particular level, we go the neighbors,
 * and check if value is 1 if yes we have to change it 2 and add its x,y
 * coordinates to the queue and do fresh-- (after this check if fresh =0 .. if
 * yes return the time) otherwise its value is 0 or 2 in that case we stop and
 * dont add to queue
 * 
 * 
 * at the end if fresh == 0 return the time else return -1 as all the oranges
 * are not rotten
 * 
 */

class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0, time = 0;
        int dirs[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    q.add(new int[] { i, j });
                else if (grid[i][j] == 1)
                    fresh++;
            }
        }
        if (fresh == 0)
            return time;

        while (!q.isEmpty()) {
            time++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int temp[] = q.poll();
                int cell = grid[temp[0]][temp[1]];

                for (int[] dir : dirs) {
                    int r = temp[0] + dir[0];
                    int c = temp[1] + dir[1];

                    // only if the value is 1 ..i will turn that into 2 and add it to q
                    // if its 2 skip it as it will be already added to the q.. and if its 0 skip as
                    // well
                    if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1) {
                        fresh--;
                        grid[r][c] = 2;
                        q.offer(new int[] { r, c });
                    }
                    if (fresh == 0)
                        return time;
                }

            }
        }
        return fresh == 0 ? time : -1;

    }
}