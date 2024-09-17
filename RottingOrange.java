/*
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
// nope

// Your code here along with comments explaining your approach
*/
class Solution {
    class Pair{
        int x = 0;
        int y = 0;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode(){
            return (this.x*10)+this.y;
        }

        @Override
        public boolean equals(Object obj){
            if(obj instanceof Pair){
                Pair p = (Pair)obj;
                int thisval = (this.x*10)+this.y;
                int objval = (p.x*10)+p.y;
                if(thisval == objval)
                    return true;
            }
            return false;
        }
    }

    public int orangesRotting(int[][] grid) {
        HashSet<Pair> seen = new HashSet<>();
        Queue<Pair> qu = new LinkedList<>();
        int fresh = 0;
        int cnt = 0;
        int ret = 0;
        if(grid.length == 0)
            return ret;

        //get loc for all rotten oranges.
        //also count fresh oranges.
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0 ; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    Pair iLoc = new Pair(i,j);
                    qu.add(iLoc);
                    seen.add(iLoc);
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        //if we have rotten oranges, set time to before 0.
        //else we will return 0.
        if(!qu.isEmpty())
            cnt--;

        //walk over the matrix, once per turn to change fresh oranges to
        //rotten, if next to rotten oranges.
        int direction[][] = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        while(!qu.isEmpty()){
            List<Pair> temp = new ArrayList<>();
            while(!qu.isEmpty()){
                Pair loc = qu.poll();

                for(int dir[] : direction){

                    if(loc.x+dir[0] >= 0 && loc.x+dir[0] < grid.length &&
                       loc.y+dir[1] >= 0 && loc.y+dir[1] < grid[0].length &&
                       grid[loc.x+dir[0]][loc.y+dir[1]] == 1){

                       Pair newLoc = new Pair(loc.x+dir[0], loc.y+dir[1]);

                       if(!seen.contains(newLoc)){
                           fresh--;
                           grid[newLoc.x][newLoc.y] = 2;
                           seen.add(newLoc);
                           temp.add(newLoc);
                       }
                    }

                }
            }
            qu.addAll(temp);
            cnt++;
        }

        if(fresh == 0)
            return cnt;
        return -1;
    }
}
