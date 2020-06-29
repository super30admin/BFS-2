// Time Complexity :O(M*N)
// Space Complexity :O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//BFS Approach

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int minutes =0,fresh=0;
        if(grid.size()==0)
            return -1;
        queue<pair<int,int>> q;
        int m = grid.size(), n = grid[0].size();
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2)
                    q.push(make_pair(i,j));
                else if(grid[i][j] == 1)
                    fresh++;
            }
       if(fresh==0) return 0;
       vector<pair<int,int>> dirs{make_pair(0,1),make_pair(0,-1),make_pair(1,0),make_pair(-1,0)};
        while(!q.empty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int r = q.front().first;
                int c = q.front().second;
                q.pop();
                for(auto it:dirs){
                    int nr = r + it.first;
                    int nc = c+ it.second;
                    if(nr>=0 && nc>=0 && nr<m && nc <n && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        q.push(make_pair(nr,nc));
                    }
                }
            }
            minutes++;
        }

        return fresh==0?minutes-1:-1;
    }
};
