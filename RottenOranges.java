/*
* The time complexity is O(N) and the space complexity is O(N).
* Here create a custom class called RottenPosition where add the positions of every rotten oranges into the queue. We keep the
* count of the queue. We take each RottenPosition from the queue and check its neighbours. If any of them is 1 we make it zero and add it
* to the queue and decrease count. When count becomes zero we increase the time.
*
* Yes, the solution passed all the test cases.
 */

class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<RottenPosition> queue = new LinkedList<>();
        int fresh = 0; int time = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.offer(new RottenPosition(i,j));
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int size = queue.size();
        while(size>0){
            RottenPosition temp = queue.poll();
            if(temp.x-1>=0){
                if(grid[temp.x-1][temp.y]==1){
                    queue.add(new RottenPosition(temp.x-1,temp.y));
                    grid[temp.x-1][temp.y]=2;
                    fresh--;
                }
            }
            if(temp.y-1>=0){
                if(grid[temp.x][temp.y-1]==1){
                    queue.add(new RottenPosition(temp.x,temp.y-1));
                    grid[temp.x][temp.y-1]=2;
                    fresh--;
                }
            }
            if(temp.x+1<grid.length){
                if(grid[temp.x+1][temp.y]==1){
                    queue.add(new RottenPosition(temp.x+1,temp.y));
                    grid[temp.x+1][temp.y]=2;
                    fresh--;
                }
            }
            if(temp.y+1<grid[0].length){
                if(grid[temp.x][temp.y+1]==1){
                    queue.add(new RottenPosition(temp.x,temp.y+1));
                    grid[temp.x][temp.y+1]=2;
                    fresh--;
                }
            }
            size--;
            if(size==0 && queue.size()!=0){
                time++;
                size = queue.size();
            }
        }

        if(fresh!=0){return -1;}
        else{
            return time;
        }
    }
}

class RottenPosition{
    int x;
    int y;
    RottenPosition(int x,int y){
        this.x = x;
        this.y = y;
    }
}