// Time Complexity : O(mn)
// Space Complexity : O(mn) all rotten at start, whole matrix will be in queue 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Do it similar to level order using BFS and increment time after each for loop
// 2. Add all rotten to queue first
// 3. Pop from queue and go thru its 4 neighbors, if fresh, rot them and add to queue
// 4. Return time-1 since last level processed doesn't rot anything but time increments on processing them

// BFS like level order traversal
class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        if(grid.size() == 0)
            return 0;
        int m=grid.size(), n=grid[0].size();
        queue<vector<int>> q;
        int fresh=0;
        vector<vector<int>> dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1)
                    fresh++;
                if(grid[i][j] == 2)
                    q.push({i,j});
            }
        }
        
        if(fresh == 0)
            return 0;
        
        int size = 0, time = 0;
        bool changed = false;
        while(!q.empty()){
            size = q.size();
            for(int i=0;i<size;i++){
                auto curr = q.front(); q.pop();
                for(auto dir: dirs){
                    int r = curr[0]+dir[0];
                    int c = curr[1]+dir[1];
                    if(r>=0 && r<m && c>=0 && c<n && grid[r][c]==1){
                        grid[r][c] = 2;
                        fresh--;
                        q.push({r,c});
                    }
                }
            }
            time++;
        }
        // last element will also add time but it does not rot any oranges; so decrement time
        time--;
        if(fresh == 0)
            return time;
        else
            return -1;
    }
};