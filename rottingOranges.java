    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/rotting-oranges/
    Time Complexity for operators : o(m*n)
    Extra Space Complexity for operators : o(m*n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach 

        # Optimized approach: 
                              
              # - Approach
                    A. Initially, two for loops for count number of 1's andnumbers of 2's will be added in the Queue.
                    B. Then we will process all the elements from the Queue. As we did BFS. if fresh becomes Zero
                       return minutes at that time only else we will go like level order traversal BFS>
                    C. this sprocess will runf or all the elements,whichever new elements will be found in all 4 directions,
                       we will add all those elemnts into queue for next processing.
                    D. In the end it minutes are  not equalt to Zero that means all oranges are not rotten. Return false in 
                       that case.
                    E. In the end, return true.
       */

class rottingOranges {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int minutes = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1)
                    fresh += 1;
                else if(grid[i][j]==2)
                    queue.add(new int[]{i,j});
            }
        }
        
        int directions[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        
        // Apply BFS on matrix
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            if(fresh == 0)
                return minutes;
            
            minutes += 1;
            
            for(int i=0;i<size;i++){
                
                int[] front = queue.poll();
                for(int[] dirs: directions){
                    int r = front[0] + dirs[0];
                    int c = front[1] + dirs[1];
                    
                    if(r>=0 && r<grid.length && c>=0 && c< grid[0].length && grid[r][c]==1){
                        queue.add(new int[]{r,c});
                        grid[r][c] = 2;
                        fresh -= 1;
                    }
                }
            }
        }
        
        if(fresh != 0)
            return -1;
        
        return minutes;
    }
}