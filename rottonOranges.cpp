//Time Complexity-O(m*n)
//Space Complexity-O(m*n)
//Runs successfully on leetcode
class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        if(grid.empty())
            return -1;
        int fresh=0,time=0;
        int m=grid.size(); int n=grid[0].size();
        queue<vector<int>>q;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) fresh++;
                if(grid[i][j]==2) q.push({i,j});
            }
        if(fresh==0) return 0;
        vector<vector<int>>dirs={{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.empty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                vector<int>curr=q.front();
                q.pop();
                for(auto dir:dirs){
                    int r=curr[0]+dir[0];
                    int c=curr[1]+dir[1];
                    if(r>=0 && r<m && c>=0 && c<n && grid[r][c]==1){
                        grid[r][c]=2;
                        q.push({r,c});
                        fresh--;
                    }
                }
            }
            time++;
        }
        if(fresh==0)
            return time-1;
        return -1;
    }
};