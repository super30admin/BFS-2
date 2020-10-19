//time complexity:O(m*n)
//space complexity:O(m*n)
//executed on leetcode: yes
//approach:using bfs
//any issues faced? yes, but understood it

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        if(grid.size()==0)
            return 0;
        int freshorange=0;
        int time=-1;
        vector<vector<int>>dirs{{-1,0},{1,0},{0,-1},{0,1}};
        queue<pair<int,int>>q;
        int nrows=grid.size();
        int ncols=grid[0].size();
        for(int i=0; i<nrows; i++)
        {
            for(int j=0; j<ncols; j++)
            {
                if(grid[i][j]==2)
                    q.push({i,j});
                else if(grid[i][j]==1)
                    freshorange++;
            }
        }
        if(freshorange==0)
            return 0;
        while(!q.empty())
        {
            int size=q.size();
            for(int i=0; i<size; i++)
            {
                pair<int,int>curr=q.front();
                q.pop();
                int row=curr.first;
                int col=curr.second;
                for(vector<int>dir:dirs)
                {
                    int x=row+dir[0];
                    int y=col+dir[1];
                    if(x>=0 && y>=0 && x<grid.size() && y<grid[0].size() && grid[x][y]==1)
                    {
                        grid[x][y]=2;
                        freshorange--;
                        q.push({x,y});
                        
                    }
                }
            }
            time++;
        }
        if(freshorange==0)
            return time;
        else
            return -1;
    }
};