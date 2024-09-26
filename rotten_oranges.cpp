//Time Complexity-O(no. of employees + no. of subordinates)
//Space Complexity-O(no. of employees + no. of subordinates)
//Ran successfully on leetcode
//3 point algo-
	//1.First we calculate the no. of fresh oranges and push the rotten ones into a queue. If there are no fresh oranges, then we return 0.
	//2.As we iterate through the queue, we push the 4 neighbours into the queue if they are fresh, turn them rotten and decrement the fresh count.
	//3.Once all he neighbours are inside the queue, and the top is popped out, then we increase the time counter i.e. it gets incremented once we process all the elements for that
	    //size of the queue.
	//4.If the fresh count is 0, we return the time. Else, we return -1 signifiying that all the oranges cant become rotten.

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        if(grid.empty())
            return -1;
        int fresh=0,count=0;
        int m=grid.size();
        int n=grid[0].size();
        queue<vector<int>>q;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                    fresh++;
                if(grid[i][j]==2)
                    q.push({i,j});
            }
        if(fresh==0)
            return 0;
        vector<vector<int>>dirs={{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.empty())
        {
            int size=q.size();
            cout<<fresh<<" ";
            for(int i=0;i<size;i++)
            {
                vector<int>curr=q.front();
                q.pop();
                for(auto dir:dirs)
                {
                    int r=curr[0]+dir[0];
                    int c=curr[1]+dir[1];
                    if(r>=0 && r<m && c>=0 && c<n && grid[r][c]==1)
                    {
                        grid[r][c]=2;
                        q.push({r,c});
                        fresh--;
                    }
                }
            }
            count++;
        }
        if(fresh==0)
            return count-1;
        return -1;
    }
};