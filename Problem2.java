// https://leetcode.com/problems/rotting-oranges/
// Time Complexity :O(m*n) -> number of elements(row*column)
// Space Complexity :O(m*n) -> Queue(worst case if all oranges are rotten).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes
   // Initially thought of putting array in queue to get row and column positions of element , but unable to put array in queue.
//Approach:
// 1.Traverse all elements in grid and push all rotten oranges into a queue . At the same time while traversing , keep track of
//   live and empty oranges.
// 2.If there are no rotten oranges then check if no live oranges are present theen return -1 since it is impossible to rot all oranges
//   without a rotten orange . Else if no live oranges then we don't need to rot any oranges,so return 0.
// 3.Now for each element in queue check if it has live oranges as neighbours and rot them and decrease count of live oranges . Do this
//   till size of queue times and keep track of queue size each time and increment count by 1 after queue size times . Do this till queue is empty.
// 4.Now if any live oranges are remaining then it is impossible to rot them so return -1. Else return count which is the number of minutes elapsed.
import java.util.LinkedList;
import java.util.Queue;

public class rottenOranges {
    public static int orangesRotting(int[][] grid) {
        if(grid.length == 0)    return 0;
        int count = 0,onecount=0,zerocount=0;
        int column = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    int value = i*column+j;
                    queue.add(value);
                }
                else if(grid[i][j] == 1)
                    onecount++;
                else
                    zerocount++;
            }
        }
        if(queue.size() == 0 ) {
            if(onecount!=0) return -1;
            if(zerocount!=0) return 0;
        }
        if(queue.size() == grid.length*grid[0].length || onecount == 0 ) return 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                int temp = queue.poll();
                int i = temp/column;
                int j = temp%column;
                if(i!=0 && grid[i-1][j] == 1) {
                    grid[i-1][j] = 2;
                    queue.add((i-1)*column+j);
                    onecount--;
                }
                if(j!=grid[0].length-1 && grid[i][j+1] == 1) {
                    grid[i][j+1] = 2;
                    queue.add(i*column+(j+1));
                    onecount--;
                }
                if(i!=grid.length-1 && grid[i+1][j] == 1) {
                    grid[i+1][j] = 2;
                    queue.add((i+1)*column+j);
                    onecount--;
                }
                if(j!=0 && grid[i][j-1]==1) {
                    grid[i][j-1] = 2;
                    queue.add(i*column+(j-1));
                    onecount--;
                }
                size--;
            }
            count++;
            if(onecount==0) break;
        }
        if(onecount!=0) return -1;
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
        int x = orangesRotting(grid);
    }

}
