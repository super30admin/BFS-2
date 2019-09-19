//Time Complexity:O(N)
//Space Complexity:O(N)
//In this problem, I'll be having a queue which will have all the indices of the rotten oranges. I'll also keep a count of the number of fresh oranges in the grid. If the count is 0, I'll be returning 0. Else, I'll iterate until my queue is empty in all possible directions. If I go out of my grid scope or if the neighboring elemnt is empty or a rotten orange, I'll skip that step and move on to the next step. If I encounter a fresh orange in any 4 directions of my rotten orange, I'll make them as rotten oranges and add them to the queue. I'll also deduct the fresh orange count and increment the rotten orange count. If my fresh orange count is 0, I'll simply return the rotten orange count. Else I'll return -1, because, not all the fresh oranges could get rotten.
//This code was executed successfully and got accepted in leetcode.

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length==0){
            return 0;
        }
        int row=grid.length;
        int col=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int fresh_count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh_count++;
                }
            }
        }
        if(fresh_count==0){
            return 0;
        }
        int count=0;
        int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
        while(!queue.isEmpty()){
            ++count;
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] point=queue.poll();
                for(int[] d:dir){
                    int x=point[0]+d[0];
                    int y=point[1]+d[1];
                    if(x<0||y<0||x>=row||y>=col||grid[x][y]==0||grid[x][y]==2){
                        continue;
                    }
                    grid[x][y]=2;
                    queue.add(new int[]{x,y});
                    fresh_count--;
                }
                
                
            }
        }
        return fresh_count==0?count-1:-1;
    }
}