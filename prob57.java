class Solution {
    public int orangesRotting(int[][] g) {
        int m = g.length, n = g[0].length, count = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i < m; i++){
            for(int j=0; j < n; j++){
		//If the oranges are rotten, add it to the queue
                if(g[i][j] == 2)
                    q.add(new int[]{i, j});
		//If the orange is fresh or rotten, increment the value of count
                if(g[i][j] != 0)
                    ++count;
            }
        }
	//If there is no oranges except rotten oranges return 0 as the result
        if(count == 0) return 0;
        int rotten = 0, levels = 0;
	//If the queue is not empty,iterate through the queue and rot the oranges adjacent to the oranges in the queue
        while(!q.isEmpty()){
            int size = q.size();
            for(int k=0; k < size; k++){
                int[] curr = q.remove();
                int i=curr[0], j = curr[1];
                if(g[i][j] == 4) continue;
                ++rotten;
                //rotten all the adjacent oranges in all the four directions
                if(i+1 < m && g[i+1][j] == 1){
                    g[i+1][j] = 2;
                    q.add(new int[]{i+1, j});
                }
                if(i-1 >= 0 && g[i-1][j] == 1){
                    g[i-1][j] = 2;
                    q.add(new int[]{i-1, j});
                }
                if(j+1 < n && g[i][j+1] == 1){
                    g[i][j+1] = 2;
                    q.add(new int[]{i, j+1});
                }
                if(j-1 >= 0 && g[i][j-1] == 1){
                    g[i][j-1] = 2;
                    q.add(new int[]{i, j-1});
                }
		//Assigning a value 4 to the already visited orange 
                g[i][j] = 4;
            }
            ++levels;
        }
	//If the number of rotten oranges is equal to the number of oranges present return the decrement the value of levels and return it as output else return -1.
        return rotten == count ? levels-1 : -1;
    }
}