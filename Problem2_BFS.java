/**
LeetCode Submitted : YES
Space Complexity : o(N+M)
Time Complexity : O(N*M)

The idea is to store the rotten oranges in the Queue and then iterate in all possible 4 directions. Once each level is completed increase counter by counter. If the queue is empty and number of rotten oranges is not equal to total oranges then return -1 else return counter value.

**/


import javafx.util.Pair;
class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    int total = 0;
    int rot   = 0;
    int fresh = 0;
    int flag = 0;
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        
        for(int i = 0; i< grid.length; i++){
            for(int j  = 0; j< grid[0].length; j++){
                if(grid[i][j] == 1)
                    fresh++;
                else if(grid[i][j] == 2){
                    q.add(new Pair<Integer,Integer>(i,j));
                    rot++;
                }
            }
        }
        
        
        if(fresh == 0)
            return 0;
        
        if(fresh == 0 || rot == 0)
            return -1;
        
        total = rot + fresh;
        int count = 0;
         
        while(!q.isEmpty()){
            if(rot >= total)
                return count;
            
            int size = q.size();
            
            while(size > 0){
                Pair<Integer,Integer> p  = q.poll();
                size --;
                Integer i = p.getKey();
                Integer j = p.getValue();
            
                if(grid[i][j] == 2){
                    for(int [] dir : directions){
                        Integer row = i + dir[0];
                        Integer col = j + dir[1];
        
                        if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length){
                            if(grid[row][col] == 1){
                                grid[row][col] = 2;
                                q.add(new Pair<Integer,Integer>(row,col));
                                rot++;
                            }        
                        }
            
                    }
                
                }    
            }
            count ++;
            
        }
        return -1;
    }
}
