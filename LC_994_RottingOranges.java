// Time Complexity :O(rows*Cols)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
//Runtime: 1 ms, faster than 100.00% of Java online submissions for Rotting Oranges.
//Memory Usage: 38.9 MB, less than 81.25% of Java online submissions for Rotting Oranges.
// Any problem you faced while coding this :No, as already discussed in class
import java.util.*;
import java.io.*;
public class LC_994_RottingOranges {
	public static int orangesRotting(int[][] grid) {
        int fresh=0;
        int min=0;
        Queue<int[] > q= new LinkedList<>();
        for(int i=0; i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] ==1){
                    fresh++;   
                }else if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                } 
            }
        }
        if(fresh ==0) return 0;
        while(!q.isEmpty()){
            
            int size= q.size();
  
            for(int i=0; i<size;i++){
                int[] temp= q.poll();
                int row=temp[0];
                int col=temp[1];
                //Check top 
                if(row>0 && grid[row-1][col]==1){
                    grid[row-1][col]=2;
                    fresh--;
                    q.add(new int[]{row-1,col});
                }
                //Check bottom
                if(row <grid.length-1 && grid[row+1][col] ==1){
                    grid[row+1][col]=2;
                    fresh--;
                    q.add(new int[]{row+1,col});
                }
                //Check left
                if(col>0 && grid[row][col-1]==1){
                    grid[row][col-1]=2;
                    fresh--;
                    q.add(new int[]{row,col-1});
                }
                //Check right
                if(col <grid[0].length-1 && grid[row][col+1] ==1){
                    grid[row][col+1]=2;
                    fresh--;
                    q.add(new int[]{row,col+1});
                }
            }
            min++;
           
        }
        if(fresh == 0) 
            return min-1;
        else 
        		return -1; 
        	
        
            
    }
	 public static void main(String[] args) {
		 int[][] grid= {{2,1,1},{1,1,0},{0,1,1}};
		 
		System.out.println("Minutes taken: "+orangesRotting(grid) );

	 }

}
