
// Time Complexity - O(m*n)
// Space Complexity - O(m*n)
class Solution {

    static class Position {
        int x,y;
        public Position(int _x, int _y){
            x = _x;
            y = _y;
        }
    }
    public int orangesRotting(int[][] grid) {

        if(grid.length ==0)
            return 0;

        Queue<Position> queue = new LinkedList<>();

        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};

        int m=grid.length, n = grid[0].length;
        int total=0;
        for(int i=0; i < m; i++){
            for(int j=0; j < n; j++){
                if(grid[i][j] == 1 || grid[i][j] == 2)
                    total++;
                if(grid[i][j] == 2)
                    queue.add(new Position(i,j));
            }
        }

        if(total==0)
            return 0;

        int time=0, rotten=0;

        while(!queue.isEmpty() &&  rotten < total){
            int size = queue.size();
            rotten += size;

            if(rotten == total){
                return time;
            }
            time++;
            for(int i=0; i<size;i++){
                Position pos = queue.poll();
                for(int[] dir : dirs){
                    int r = pos.x + dir[0];
                    int c = pos.y + dir[1];

                    if(r>=0 && r < m && c>=0 && c<n && grid[r][c] == 1){
                        grid[r][c] = 2;
                        queue.add(new Position(r,c));
                    }
                }
            }
        }
       return -1;
    }
}