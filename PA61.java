//Leetcode : 994. Rotting Oranges
//Time Complexity: O(n) // Where n is the number of cell in the gird
//Space Complexity:O(n) // Queie size will be at max equal to no of oranges in grid

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0 ){
            return -1;
        }
        Queue<int[]> q= new LinkedList<>();
        int row= grid.length;
        int col= grid[0].length;
        int fresh=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    q.add(new int[] {i,j});
                }
                else{
                    if(grid[i][j]==1){
                        fresh++;
                    }
                }
                
            }
        }
        if(fresh==0){
            return 0;
        }
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        int size=0;
        int t=0;
        
        while(!q.isEmpty()){
            t++;
           size= q.size();
           while(size>0){
                int[] temp = q.poll();
                int x;
                int y;
                for(int[] dir: dirs){
                    x=temp[0]+dir[0];
                    y=temp[1] +dir[1];
                    if(x>=0 && x<row && y>=0 && y<col && grid[x][y]==1){
                        grid[x][y]=2;
                        fresh--;
                        q.add(new int[] {x,y});
                    }


                }
              
               size--;
           }
            if(fresh<=0){
                break;
            }
             
            
        }
        if(fresh!=0){
            return -1;
        }
        return t;
    }
}