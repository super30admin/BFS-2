//Time Complexity:O(m*n)
//Space Complexity: O(m*n).


//When dealing with matrix, the BFS QUEUE usually holds coordinates. Initially we calculate the total number of fresh oranges and put the rotten oranges into queue, for each rotten orrange in the queue we check it's neighbours and update the coordinates accordingly and then again put it in the queue. 


class Solution {

    public int orangesRotting(int[][] grid) {
        
    int[][] dirs = {{0, 1},{0, -1},{1, 0},{-1, 0}};
        
    int m = grid.length;
    int n = grid[0].length;
    int freshOranges = 0;
    
    Queue<int[]> oq = new LinkedList<>();
        
      
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(grid[i][j] == 1)
                freshOranges++;
            else if(grid[i][j] == 2)
                oq.add(new int[] {i,j});
        }
    }
        
    if(freshOranges == 0) return 0;
    
    int totalMin = 0; 
    while(!oq.isEmpty()){
    int size = oq.size();
    for(int i = 0; i < size;i++){
        int[] temp = oq.poll();
        for(int[] dir:dirs){
            int row = temp[0] + dir[0];
            int col = temp[1] + dir[1];
            if(row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1){
                freshOranges--;
                oq.add(new int[] {row, col});
                grid[row][col] = 2;
                }
             }
         }
        totalMin++;
    }

    
    if(freshOranges != 0) return -1;
        
    return totalMin-1;

    }
}