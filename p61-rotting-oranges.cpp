// Time complexity is O(m*n) - m = #rows; n = #columns
// Space complexity is O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Using BFS
class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        if(grid.size() == 0) return 0;
        int time = 0;
        int nFresh = 0; // number of fresh oranges
        queue<vector<int>> q;
        for(int i = 0; i < grid.size(); i++) {
            for(int j = 0; j < grid[0].size(); j++) {
                if(grid[i][j] == 1) {
                    nFresh++;
                }
                else if(grid[i][j] == 2) {
                    vector<int> temp = {{i,j}};
                    q.push(temp);
                }
            }
        }
        
        if(nFresh == 0) return 0;
        
        while(!q.empty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                vector<int> currCell = q.front();
                q.pop();
                vector<vector<int>> directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
                for(vector<int> dir : directions) {
                    int neighborRow = currCell[0] + dir[0];
                    int neighborCol = currCell[1] + dir[1];
                    if(neighborRow >= 0 && neighborRow < grid.size()
                       && neighborCol >= 0 && neighborCol < grid[0].size()
                       && grid[neighborRow][neighborCol] == 1) {
                        nFresh--;
                        grid[neighborRow][neighborCol] = 2;
                        vector<int> temp = {{neighborRow,neighborCol}};
                        q.push(temp);
                    }
                }
            }
            time++;
        }
        if(nFresh) return -1;
        return time-1;
    }
};
