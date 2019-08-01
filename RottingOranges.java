
//idea:  breadth-first search 
//check whether neighbor values of 2 are 1 in grid.  as 2 means rotten orange, so checck weather any fresh organge is nearby rooten organge or not.
//if Yes then update value 1 to 2. To identify neighbor values use direction array {{1,0},{-1,0},{0,1},{0,-1}}
//use queue to store all index of grid which has value 2.  and keep counter for time ,it increases by  1 when queue size exceeds(that means all 4 directions oranges are rotten)
//to identify weather whole oranges are rotten or not keep counter for fresh oranges initially.
//and reduce fresh orange counter by 1 while rottening process  (1 to 2 value updation) happens.
//if fresh orange counter =0 then it means all oranges are rotten ,return counter-1.

//time complexity  O(N), where Nis the number of cells in the grid.
//space complexity is o(n)
////Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this:yes 


import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
	
	
	 public static int orangesRotting(int[][] grid) {
         if(grid == null || grid.length == 0) return 0;
       int rows = grid.length;
       int column =grid[0].length;
       int count_fresh =0;
       Queue<int[]> q = new LinkedList<>();
       //Put the position of all rotten oranges in queue
	        //count the number of fresh oranges
       for(int i=0;i<rows;i++){
           for(int j=0;j<column;j++){
               if(grid[i][j] == 2) {
                   q.offer(new int[]{i,j});
               }
               
               if(grid[i][j] ==1) count_fresh++;
                       
           }
       }
        //if count of fresh oranges is zero --> return 0 
       if(count_fresh ==0) return 0;
       int counter =0;
       int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
      //below for loop is for testing and understanding purpose. it shows first array in 2D is index and second array index of inside element.
       for(int i=0;i<dirs.length;i++){
           System.out.println("dir"+dirs[0][0]);  ///prints 1 four times bz at 0th index 0th element is 1.
           
       }
       //bfs starting from initially rotten oranges
       while(!q.isEmpty()){
           ++counter;
           int size = q.size();
           for(int i=0; i<size;i++){
               int[] point = q.poll();
               for(int[] dir: dirs){
                 
                   int x=point[0] + dir[0];
                   int y=point[1] + dir[1];
                   if(x>=rows || y>=column || x<0 || y<0 || grid[x][y] ==2 ||  grid[x][y] ==0) continue;
                   //mark the orange at (x , y) as rotten
                   grid[x][y] =2;
                   //put the new rotten orange at (x , y) in queue
                   q.offer(new int[]{x,y});
                     //decrease the count of fresh oranges by 1
                   count_fresh--;
                   
               }
           }
  
       }
         
       if(count_fresh ==0){
           return  counter-1;
       }else{
           return -1;
       }
       
   }
      

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[[2,1,1],[1,1,0],[0,1,1]]
		int grid[][]={{2,1,1},{1,1,0},{0,1,1}}; 
		int time= orangesRotting(grid);
		System.out.println("the minimum number of minutes that must elapse until no cell has a fresh orange."+time);
		

	}

}
