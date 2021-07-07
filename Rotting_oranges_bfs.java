TC:O(m*n)
SC:O(m*n)

Runtime: 2 ms, faster than 86.41% of Java online submissions for Rotting Oranges.
Memory Usage: 39.5 MB, less than 81.25% of Java online submissions for Rotting Oranges.




class Solution {
    public int orangesRotting(int[][] grid) {
        int length = grid.length;
        int height = grid[0].length;
        Queue<int []> queue = new LinkedList<>();
        int fresh =0;
        int minute=0;
        for(int i=0; i<length; i++){
            for(int j=0; j< height ; j++){
                if(grid[i][j]== 2) queue.add(new int[]{i,j});
                if(grid[i][j]==1) fresh++;
            }
        }
        if (fresh ==0) return 0;
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!queue.isEmpty()){
            minute++;
            int size = queue.size();
            for(int k=0; k< size; k++){
                int[] curr = queue.poll();

                for(int[] dir : dirs ) {
                    int a= curr[0]+ dir[0];
                    int b= curr[1]+ dir[1];
                    if(a>=0 && a<length && b>=0 && b<height && grid[a][b] == 1) {
                        queue.add(new int []{a,b});
                        grid[a][b]=2;
                        fresh--;

                    }

                }
            
            }
        }
        
        if(fresh==0) return minute-1;
        else return -1;

        
        
    }
}
