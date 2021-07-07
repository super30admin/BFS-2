//Leetcode all test cases passed
//Time complexity: O(n)
//Space Comlexity: O(n)

class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh=0,count=0;
        Queue<int[]> queue = new LinkedList<>();
        //First traverse through the array, to get the indices of the rotten oranges
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2)
                    queue.add(new int[] {i,j});
                if(grid[i][j]==1)
                    fresh++;
            }
        }
        //Edge cases
        if(fresh==0) return 0;
        //Declaring a directional array for going n 4 directions
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        //BFS
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int p=0;p<size;p++){
                int[] rot = queue.poll();
                for(int[] dir : dirs){
                    //Right, Left, Top and bottom
                    int i=dir[0]+rot[0];
                    int j=dir[1]+rot[1];               
                    if((i>=0&&i<grid.length)&&(j>=0&&j<grid[0].length)&&(grid[i][j]==1)){
                        queue.add(new int[] {i,j});
                        grid[i][j]=2;
                        fresh--;
                    }
                }
            }
            //incrementing the count of minutes (i.e. keeping a track of levels).
            count++;
        }
        if(fresh!=0) return -1; //This means there still some fresh oranges left
        if(count>0) return count-1;
        else return 0;
    }
}
