// Time Complexity : O(n+n*m) for traversing all the elements to find freshoranges and a rotten orange
// Space Complexity : O(n*m) for queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// First traverse through the matrix for finding the number of fresh oranges and rotten oranges
// add all rotten oranges indexes to the queue.
// while the queus is not emplty pop the first index and find it's surrounding cells in 1 distances to find fresh orange
// Increment the counter for minutes once it enters the while loop of queue.
// for this use direction matrix which is intitialized below and change it to 2 (rotten) if present.
// add those indexes also to the queue to find further rotting oranges because of them.
// if there are no rotting oranges or no fresh oranges we will return -1


class Solution {
    public int orangesRotting(int[][] grid) {
        int freshOranges = 0;
        int min = 0;
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    freshOranges++;
                }
                else if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }
       
        
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){ 
            if(freshOranges==0) {return min;}
            min++; 
            int size = q.size();
            for(int k=0; k<size;k++){
                int[] pop = q.poll();
                for(int[] arr:dir){
                    int r=arr[0];
                    int c=arr[1];
                    int i=pop[0];
                    int j = pop[1];
                    if(i+r<grid.length && i+r>=0 && j+c<grid[0].length && j+c>=0 && grid[i+r][j+c]==1 ){
                    grid[i+r][j+c] = 2;
                    q.add(new int[]{i+r,j+c});
                    freshOranges--;
                    }
                }
                
            }
        }
        if(freshOranges>0) {return -1;}
        return min;
    }
}