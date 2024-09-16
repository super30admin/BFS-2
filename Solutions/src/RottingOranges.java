// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
class RottingOranges {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length==0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<Pair>();
        int fresh = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
            }
        }
        if(fresh==0) return 0;
        int time = 0;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        while(!q.isEmpty()){
            time++;
            int level = q.size();
            for(int i=0;i<level;i++){
                Pair cell = q.poll();
                for(int k=0;k<4;k++){
                    int x = cell.x+dx[k];
                    int y = cell.y+dy[k];
                    if(x>=0 && y>=0 && x<m && y<n && grid[x][y]==1){
                        grid[x][y]=2;
                        fresh--;
                        if(fresh==0)return time;
                        q.add(new Pair(x,y));
                    }
                }
            }
        }
        return -1;
    }
}
class Pair{
    int x,y;
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}
