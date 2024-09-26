// Time Complexity : O(n+n*m)
// Space Complexity : O(n) n is max diameter of level(for queue)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> res=new LinkedList<>();
        
        int fresh=0;
        int minutes=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    fresh+=1;
                }
                else if(grid[i][j]==2){
                    res.add(new int[]{i,j});
                }
            }
        }
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!res.isEmpty()){
            int size=res.size();
            if(fresh==0){
                return minutes;
            }
             //minutes+=1;
          
            for(int x=0;x<size;x++){
                int[] front=res.poll();
                
                for(int[] dirs:directions){
                    int r=front[0]+dirs[0];
                    int c=front[1]+dirs[1];
                    
                    if(r>=0&&r<grid.length &&c>=0&&c<grid[0].length&& grid[r][c]==1){
                        res.add(new int[]{r,c});
                        grid[r][c]=2;
                        fresh-=1;
                    }
                }
            }
           
            minutes+=1;  

        }
        if(fresh>0){
            return -1;
        }
        return minutes;
        
        
    }
}