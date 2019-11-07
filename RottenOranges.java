//Time Complexity :O(N)
//Space Complexity :O(2^L) At max the queue size can be width of the level
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Nope


//Your code here along with comments explaining your approach
class RottenOranges {
    public int orangesRotting(int[][] grid) {
        if(null == grid || 0 == grid.length || 0 == grid[0].length){
            return -1;
        }
        Queue<int[]> q = new LinkedList<>();
        int nodes = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    int arr[] = new int[2];
                    arr[0] = i;
                    arr[1] = j;
                    q.add(arr);
                    nodes++;
                }else if(grid[i][j] == 1){
                    nodes++;
                }
            }
        }
        if(q.isEmpty()&& 0 == nodes){return 0;}
        int timeTaken = 0;
        while(!q.isEmpty()){
            timeTaken++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                int arr[] = q.poll();
                nodes--;
                int x = arr[0];
                int y = arr[1];
                if(x-1>=0 && y>=0 && grid[x-1][y] == 1){
                    int newArray[] = new int[2];
                    newArray[0] = x-1;
                    newArray[1] = y;
                    q.add(newArray);
                    grid[x-1][y] = 2;
                }
                if(x>=0 && y-1>=0 && grid[x][y-1] == 1){
                    int newArray[] = new int[2];
                    newArray[0] = x;
                    newArray[1] = y-1;
                    q.add(newArray);
                    grid[x][y-1] = 2;
                }
                if(x>=0 && y+1< grid[0].length && grid[x][y+1] == 1){
                    int newArray[] = new int[2];
                    newArray[0] = x;
                    newArray[1] = y+1;
                    q.add(newArray);
                    grid[x][y+1] = 2;
                }
                if(x+1<grid.length && y>=0 && grid[x+1][y] == 1){
                    int newArray[] = new int[2];
                    newArray[0] = x+1;
                    newArray[1] = y;
                    q.add(newArray);
                    grid[x+1][y] = 2;
                }
            }
        }
        if(0 != nodes){return -1;}
        return timeTaken-1;
    }
}