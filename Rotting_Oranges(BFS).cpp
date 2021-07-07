Time Complexity-O(m*n)
Space Complexity-O(m*n)--> size of queue when everything in the grid are rotten oranges(worst case)

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        if(grid.size()==0)
        {
            return 0;
        }
        queue<vector<int>>m;
        int fresh=0;
        int time=0;
        for(int i=0;i<grid.size();i++)
        {
            for(int j=0;j<grid[i].size();j++)
            {
                if(grid[i][j]==1)
                {
                    fresh++;
                }
                if(grid[i][j]==2)
                {
                    vector<int>k;
                    k.push_back(i);
                    k.push_back(j);
                    m.push(k);
                }
            }
        }
        if(fresh==0)
        {
            return 0;
        }
        while(!m.empty())
        {
            vector<vector<int>>dir={{0,1},{0,-1},{1,0},{-1,0}};
            int size=m.size();
            for(int i=0;i<size;i++)
            {
                vector<int>a=m.front();
                m.pop();
                for(int j=0;j<dir.size();j++)
                {
                    vector<int>b=dir[j];
                    int row=a[0]+b[0];
                    int col=a[1]+b[1];
                    if(row>=0 && row<grid.size() && col>=0 && col<grid[0].size() && grid[row][col]==1)
                    {
                        grid[row][col]=2;
                        vector<int>x;
                        x.push_back(row);
                        x.push_back(col);
                        m.push(x);
                        fresh--;
                    }
                }
            }
            time++;
        }
        if(fresh>0)
        {
            return -1;
        }
        else
        {
            return time-1;
        }
    }
};