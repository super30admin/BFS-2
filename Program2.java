package LeetCode;
/*
 * 
 * 
 * TC = O(n)
 *  SC = O(n) 
 * 
 * */
public class Program2 {
	class Solution {
	    int direction[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
	   
	    public int orangesRotting(int[][] grid) {
	       int level = -1;
	       int goodOranges = 0;
	       Queue<int[]> q = new LinkedList<>();
	        
	        for(int i=0;i<grid.length; i++)
	            for(int j=0; j<grid[0].length; j++){
	                if(grid[i][j] == 2){
	                    q.add(new int[]{i,j});
	                }
	                else if(grid[i][j] == 1)
	                    goodOranges++;
	            }
	        
	            if(goodOranges == 0) return 0;
	            if(q.isEmpty()) return -1;
	        
	        while(!q.isEmpty()){
	           
	            int size = q.size();
	            for(int i=0; i<size; i++){
	                int[] temp = q.poll();
	                for(int[] dir : direction)
	                {
	                    int x = temp[0]+ dir[0];
	                    int y = temp[1] + dir[1];
	                
	                    if(x<0 || x>=grid.length || y< 0 || y>=grid[0].length) continue;
	                     if(grid[x][y] == 1){
	                         grid[x][y] = 2;
	                         q.add(new int[]{x,y});
	                         goodOranges--;
	                         
	                     }
	                     
	                 }
	            }
	            level++;
	         }
	            
	        if(goodOranges != 0)
	            return -1;
	        
	        return level;
	}
	}

}
