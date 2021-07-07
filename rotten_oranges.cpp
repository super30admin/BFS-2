// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//BFS technique is used to fill up rotten oranges first and then we proceed level by level.
class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        //edge case
        
        int row = grid.size();
        int col = grid[0].size();
        //BFS
        queue<vector<int>> my_index_queue;
        for(int i =0; i< row; i++){
            for(int j =0; j< col; j++){
                if(grid[i][j] ==2){
                 vector<int> temp = {i,j} ;
                 my_index_queue.push(temp); 
                }
            }
        }
        int size, time=0;
        int dirs[4][2]={{1,0},{-1,0},{0,-1},{0,1}};
        while(!my_index_queue.empty()){
            size = my_index_queue.size();
            while(size>0){
                vector<int> temp =  my_index_queue.front();
                my_index_queue.pop();
                size--;
                for(int i=0; i<4; i++){
                    int r = temp[0]+dirs[i][0];
                    int c = temp[1]+dirs[i][1];
                    if(r>=0 && r<row && c>=0 && c< col){
                       vector<int> temp2 = {r,c};
                       if(grid[r][c] == 1) {
                           my_index_queue.push(temp2); 
                           grid[r][c] = 2;
                       }
                    }
                    
                }
            }
            time++;
        }
        for(int i =0; i< row; i++){
            for(int j =0; j< col; j++){
                if(grid[i][j] ==1){
                 return -1;
                }
            }
        }
        if(time>0) return time-1;
        return time;
    }
};
