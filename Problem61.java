Executed in leet code-Yes
Time complexity- m*n
Space complexity-m*n when all are rotten intially

class Solution {
    public int orangesRotting(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
        int fresh =0;
        Queue<int[]> q= new LinkedList<int[]>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2)
                    q.add(new int[] {i,j});
                if(grid[i][j]==1)
                    fresh++;
            }
        }
        int time=0;
        int[][] dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        int converted =0;
        while(!q.isEmpty()){
            int size=q.size();
            boolean madeRotten=false;
            for(int i=0;i<size;i++){
                int[] cur = q.poll();
                for(int[] dir:dirs){
                    int r= cur[0]+dir[0];
                    int c= cur[1]+dir[1];
                    if(r>=0 && r<m && c>=0 && c<n && grid[r][c]==1){
                        grid[r][c]=2;
                        q.add(new int[] {r,c});
                        madeRotten=true;
                        converted++;
                    }
                }
            }
            if(madeRotten)
                time++;
        }
        if(fresh==converted)
            return time;
        else 
            return -1;
    }
}
