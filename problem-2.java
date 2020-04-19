//TC:o(n*m)
//sc:o(n*m)

class Pair
{ 
 int row;
 int col;
  
 public Pair(int row,int col)
 {
   this.row=row;
   this.col=col; 
 }  
}


class Solution {
    
    Queue<Pair> q = new LinkedList<>();
    int fresh=0;
    public int orangesRotting(int[][] grid) 
    {
      if(grid==null||grid.length==0||grid[0].length==0) 
              return -1;
     int r = grid.length;
     int c = grid[0].length;
 
     for(int i=0;i<r;i++){
       for(int j=0;j<c;j++)
       {
           if(grid[i][j]==1)
               fresh++;
           if(grid[i][j]==2)
               q.add(new Pair(i,j));  
       }}
        
       if(fresh==0) return 0; 
      int time=0;
     int x[]={0,0,-1,1}; 
     int y[]={1,-1,0,0};
        
       while(!q.isEmpty())
       {
          int size=q.size();
          for(int i=0;i<size;i++)
          {
            Pair p = q.poll(); 
            for(int l=0;l<x.length;l++)
              {
               int row = p.row+x[l];
               int col = p.col+y[l];
               if(row>=0&&row<r&&col>=0&&col<c&&grid[row][col]==1)
                 {
                   fresh--;
                   grid[row][col]=2;
                    q.add(new Pair(row,col)); 
                 }
              }
          }
         time=time+1;
       }
      return fresh>0?-1:(time-1);
    }   
}