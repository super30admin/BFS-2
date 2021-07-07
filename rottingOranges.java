//Time complexity: O(V+E) => O(N)
//Space Complexity: O(V+E) => O(N)
//Tried on leetcode and accepted
//attempts: 4
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null||grid.length==0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        // 2 stands for all rotten oranges so put the index of all the rottrn oranges in a queue
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i , j});
                }
                else if(grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }
        //If count of fresh oranges is 0 then return 0
        if(count_fresh == 0) return 0;
        
        int count=0 ;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        
        while(!queue.isEmpty())
        {
            ++count;
            int size = queue.size();
            for(int i=0; i< size ; i++)
            {
                int[] point=queue.poll();
                for(int dir[]: dirs)
                {
                    int x = point[0]+dir[0];
                    int y = point[1]+dir[1];
                    //If the x and y coordinate is out of bounds
                    //or if the cell is empty
                    //or if the orange in the cell is already rotten
                    //we do nothing
                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    //else mark the orange at x,y rotten
                    grid[x][y] = 2;
                    //add the index of this rotten orange as well in the queue
                    queue.offer(new int[]{x , y});
                    //decrease count of freash oranges by 1
                    count_fresh --;
                }
            }
        }
        return count_fresh==0 ? count-1 : -1;
    }
}