//Time Complexity: O(n3) where n is the maximum diameter in the tree
//Space Complexity: O(n) for grid 

public class RottingOranges {
    public static int orangesRotting(int[][] grid) {
        int count = 0;
        boolean flag = false;
        if(allvalid(grid) == 1)
            return 0;
        int[][] visited = new int[grid.length][grid[0].length];
        while(true){
            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid[i].length;j++){
                    //check if the orange is rotten and the node is not visited
                    if(grid[i][j] == 2 && visited[i][j] != 1){
                        //marking node as visited so it may not be considered for future
                        visited[i][j] = 1;
                        //check on top
                        if(i-1 >= 0 && grid[i-1][j] == 1){
                            grid[i-1][j] = -1;
                        }
                        //check on bottom
                        if(i+1 < grid.length && grid[i+1][j] == 1){
                            grid[i+1][j] = -1;
                        }
                        //check on right
                        if(j+1 < grid[i].length && grid[i][j+1] == 1){
                            grid[i][j+1] = -1;
                        }
                        //check on left
                        if(j-1 >= 0 && grid[i][j-1] == 1){
                            grid[i][j-1] = -1;
                        }
                    }
                }
            }
            flag = true;
            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid[i].length;j++){
                    // -1 means the rotten oranges
                    if(grid[i][j]==-1)
                        grid[i][j] = 2;
                    // check if there are normal oranges are still there
                    if(grid[i][j] == 1)
                        flag = false;
                }
            }
            count++;
            //if all oranges are rotten
            if(flag)
                return count;
            //if there is any non rotten oranges there or the count is greater than the total grid elements
            else if(count >  grid.length*grid[0].length) 
                return -1;
        
        }
    }
    // check if there is normal orange
    static int allvalid(int[][] grid){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return 0;
                }
            }
        }
        return 1;
    }
    
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
}