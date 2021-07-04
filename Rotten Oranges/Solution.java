import sun.misc.Queue;

class RottenOranges {
    public int orangesRotting(int[][] grid) {
        
        int fresh = 0;
        Queue<int[]> queue = new Queue<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){

                if(grid[i][j] == 1) fresh++;

                if(grid[i][j] == 2) {
                    int[] position = new int[2];
                    position[0] = i;
                    position[1] = j;
                    queue.add(position);
                }
            }
        }
        int timer=-1;
        if(fresh == 0) return 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0){
                int[] temp = queue.poll();
                int row = temp[0];
                int col = temp[1];

                if(row>0 && grid[row-1][col] == 1){
                    grid[row-1][col] = 2;
                    fresh--;
                    queue.add(new int[] {row-1, col});
                }

                if(row<grid.length-1 && grid[row+1][col] == 1){
                    grid[row+1][col] = 2;
                    fresh--;
                    queue.add(new int[]{row+1, col});
                }

                if(col>0 && grid[row][col-1] == 1){
                    grid[row][col-1] = 2;
                    fresh--;
                    queue.add(new int[]{row, col-1});
                }

                if(col<grid[0].length-1 && grid[row][col+1] == 1){
                    grid[row][col+1] = 2;
                    fresh--;
                    queue.add(new int[]{row, col+1});
                }

                size--;
            }          
            timer++;  
        }
        

        
        if(fresh == 0) return timer;
        
        return -1;
    }
}

class Solution {
    public static void main(String[] args){
        System.out.println("RottenOranges");
    }
}