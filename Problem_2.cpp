class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int count = 0;
        queue<pair<int,int>> Q;
        for(int i=0; i<grid.size(); i++){
            for(int j=0; j<grid.at(0).size(); j++){
                if(grid[i][j]==2){
                    pair<int,int>start(i,j);
                    Q.push(start);
                }
                if(grid[i][j]==1) count++;
            }
        }
        int time = -1;
        pair<int,int> d1(0,1);
        pair<int,int> d2(0,-1);
        pair<int,int> d3(1,0);
        pair<int,int> d4(-1,0);
        vector<pair<int,int>>dirs{d1,d2,d3,d4};
        while(!Q.empty()){
            int sz = Q.size();
            while(sz--){
                pair<int,int>temp = Q.front();
                Q.pop();
              for(pair<int,int>i:dirs){
                int r = temp.first + i.first;
                int c = temp.second + i.second;
                if(r<grid.size() && r>=0 && c<grid.at(0).size() && c>=0 && grid[r][c] == 1){
                    grid[r][c] = 2;
                    pair<int,int>t(r,c);
                    Q.push(t);
                    count--;    
                }
            }  
        }
            time++;
    }
        if(count > 0) return -1;
        if(time==-1) return 0;
        return time;
    }
};