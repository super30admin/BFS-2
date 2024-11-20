//Time and space complexity -O[N]

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int []> q = new LinkedList<>();
        int fresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) fresh++;
                else
                    if((grid[i][j]==2)) q.add(new int[]{i,j});
            }
        }
        if(fresh==0) return 0;
        int time=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size!=0){
                int [] temp = q.remove();
                int r=temp[0];
                int c = temp[1];
                if(r>0 && grid[r-1][c]==1){
                    grid[r-1][c]=2;
                    fresh--;
                    q.add(new int[] {r-1,c});
                }
                if(r<grid.length-1 && grid[r+1][c]==1){
                    grid[r+1][c]=2;
                    fresh--;
                    q.add(new int[] {r+1,c});
                }
                if(c>0 && grid[r][c-1]==1){
                    grid[r][c-1]=2;
                    fresh--;
                    q.add(new int[] {r,c-1});
                }
                if(c<grid[0].length-1 && grid[r][c+1]==1){
                    grid[r][c+1]=2;
                    fresh--;
                    q.add(new int[] {r,c+1});
                }
                size--;
            }
            time++;
        }
        if(fresh==0) return time-1;
        else return -1;
    }
}