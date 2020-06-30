//Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        //O(n) space and O(n) time
        if(grid.size()==0) return 0;
        
        queue<vector<int>> q;
        int fresh=0;
        int time = 0;
       
        int m = grid.size(); int n = grid[0].size();
        for(int i=0; i<m; i++){
             vector<int> temp;
            for(int j=0;j<n; j++){
                if(grid[i][j]==2){
                    temp.push_back(i);
                    temp.push_back(j);
                    q.push(temp);
                    temp.clear();
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
            
            
        }
        
        if(fresh==0) return 0;
        
        
        int dirs[4][2]={{0,1},{0,-1},{-1,0}, {1,0}};
        
        while(q.empty()==false){
            int size=q.size();
            for(int i=0; i<size; i++){
                vector<int> temp = q.front(); q.pop();
                for(int j=0; j<4; j++){
                    int r = dirs[j][0]+temp[0];
                    int c = dirs[j][1]+temp[1];
                    vector<int> arr;
                    if(r>=0 && r<m && c>=0 && c<n && grid[r][c]==1){
                        fresh--; grid[r][c]=2;
                        arr.push_back(r);
                        arr.push_back(c);
                    }
                    if(arr.size()>0)  q.push(arr);
                }
            }
            time++;
        }
        
        if(fresh>0) return -1;
        
        return time-1;

    }
};