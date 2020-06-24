// Time Complexity :  O(m*n*4)  -> (m*n) + (queue size at max can be 4 at a minute - hence constant)  
// Space Complexity : O(1) A queue of pairs but at any given minute the max can only be 4 UP DOWN LEFT RIGHT
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Alot of thinking!


class Pair
{
    int i;
    int j;
    int value;
    
    Pair(int i,int j, int value)
    {
        this.i=i;
        this.j=j;
        this.value=value;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<Pair> queue=new LinkedList<>();
        
        /* Find number of fresh oranges */
        int numberOfFreshOranges=0;
        for(int i=0;i<grid.length;i++)
        {    
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                    numberOfFreshOranges++;
                if(grid[i][j]==2)
                    queue.add(new Pair(i,j,grid[i][j]));
            }
        }
        
        if(numberOfFreshOranges==0)
            return 0;
        /* traverse queue */
        
        int[][] directions={{0,1},{0,-1},{-1,0},{1,0}};
        int minutes=0;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            
            for(int i=0;i<size;i++)
            {
                Pair current=queue.poll();
                int m=current.i;
                int n=current.j;
                /* directions */
                for(int j=0;j<directions.length;j++)
                {
                    int k=m;
                    int l=n;
                    
                    k+=directions[j][0]; // 0
                    l+=directions[j][1]; // 1
                    
                    if(k>=0 && k<grid.length && l>=0 && l<grid[0].length)
                    {
                        if(grid[k][l]==1)
                        {
                            queue.add(new Pair(k,l,grid[k][l]));
                            grid[k][l]=-1;
                            numberOfFreshOranges--;
                        }
                    }   
                }
            }
            minutes++;
        }
        
        if(numberOfFreshOranges==0)
            return minutes-1;
        
        return -1;
}
}