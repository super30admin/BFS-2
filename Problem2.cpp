//
// Created by shazm on 7/31/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <set>
#include <queue>
#include <tuple>

// Runtime: O(n)
// Space: O(n)
// Approach: 1) Use a queue to save all the rotten oranges in the beginning. and add to the visited set.
// 2) check the 4-directions of the top element of the queue for fresh oranges.
// 3) if any orange in those directions is not rotten and not visited, add to visited set, push to queue, and mark rotten.
// 4) pop element from queue and repeat 1,2,3, and 4 till queue is empty.

using namespace std;

struct Oranges{
    int i;
    int j;
};

bool operator<(const Oranges& lhs, const Oranges& rhs)
{
    return std::tie(lhs.i, lhs.j) < std::tie(rhs.i, rhs.j);
}


class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int res = 0;
        queue<Oranges> que;
        set<Oranges> visited;
        for(int i = 0; i<grid.size(); i++){
            for(int j = 0; j<grid[0].size(); j++){
                if(grid[i][j]==2){
                    Oranges ora{i,j};
                    que.push(ora);
                    visited.insert(ora);
                }
            }
        }
        Oranges orange; int size; int it = 0;
        while(!que.empty()){
            size = que.size();
            for(int x = 0; x<size; x++){
                orange = que.front();
                if(validate(orange.i,orange.j+1,grid)){
                    Oranges ora1{orange.i,orange.j+1};
                    if(grid[ora1.i][ora1.j]==1 && visited.insert(ora1).second){
                        que.push(ora1);
                        grid[ora1.i][ora1.j] = 2;
                    }
                }
                if(validate(orange.i,orange.j-1,grid)){
                    Oranges ora1{orange.i,orange.j-1};
                    if(grid[ora1.i][ora1.j]==1 && visited.insert(ora1).second){
                        que.push(ora1);
                        grid[ora1.i][ora1.j] = 2;
                    }
                }
                if(validate(orange.i+1,orange.j,grid)){
                    Oranges ora1{orange.i+1,orange.j};
                    if(grid[ora1.i][ora1.j]==1 && visited.insert(ora1).second){
                        que.push(ora1);
                        grid[ora1.i][ora1.j] = 2;
                    }
                }
                if(validate(orange.i-1,orange.j,grid)){
                    Oranges ora1{orange.i-1,orange.j};
                    if(grid[ora1.i][ora1.j]==1 && visited.insert(ora1).second){
                        que.push(ora1);
                        grid[ora1.i][ora1.j] = 2;
                    }
                }
                que.pop();
            }
            if(it>0){res++;}
            it++;
        }
        for(int i = 0; i<grid.size(); i++){  // You can avoid this by having a one counter in previous 2 pass. and compare with number of times 1 has come across in while loop. Saves time.
            for(int j = 0; j<grid[0].size(); j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return res;
    }
private:
    bool validate(int i, int j, vector<vector<int>>& grid){
        if(i>=0 && i<grid.size() && j<grid[0].size() && j>=0){
            return true;
        }
        return false;
    }
};

int main(){
    Solution s;
    vector<vector<int>> vec{{2,1,1},{0,1,1},{1,0,1}};
    s.orangesRotting(vec);
    return 0;
}