// Time Complexity : O(rows*columns) 
// Space Complexity : O(rows*columns)
// Three line explanation of solution in plain english

class Pair{
    int x,y;
    Pair(int x,int y){
        this.x = x;
        this.y=y;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int rowLen = grid.length;
        if(rowLen==0)
            return 0;
        int colLen = grid[0].length;
        int flg =0,count=0,time=0;
        
        for(int i=0;i<rowLen;i++){
            for(int j=0;j<colLen;j++){
                if(grid[i][j]==2)
                {
                    q.add(new Pair(i,j));
                    count++;
                }else if(grid[i][j]==1){
                    count++;
                }
            }
        }
        
        if(count==0)
            return 0;
        
        while(!q.isEmpty()){
            int size=q.size();
            
            time++;
            
            for(int i=0;i<size;i++){
                Pair p = q.poll();
                helperDir(p.x,p.y,q,grid,rowLen,colLen);
                count--;
            }
            
            
            
            
        }
        
        
        return count==0?time-1:-1;
    }
    
    public void helperDir(int x,int y, Queue<Pair> q,int[][] grid, int rowLen, int colLen){
        int[] arrX = {-1,0,1,0};
        int[] arrY = {0,1,0,-1};
        
        for(int i=0;i<4;i++){
            int a = x+arrX[i];
            int b = y+arrY[i];
            
            if(a>=0 && a<rowLen && b>=0 && b<colLen && grid[a][b]==1){
                grid[a][b]=2;
                q.add(new Pair(a,b));
            }
        }
    }
}