// Time Complexity : O(N x M)
// Space Complexity : O(N x M)
// Leetcode passes: yes
// Any problems while solving this problem : no
class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        
        auto matrix = grid;
        
        int nrows = matrix.size();
        int ncols = matrix[0].size();
        queue<pair<int, int>> queue;
        vector<pair<int, int>> dirs {{0, 1}, {1, 0}, {-1, 0}, {0,-1}};
        int time = -1;
        int oranges = 0;
        
        for(int i = 0; i < nrows; i++)
        {
            for(int j = 0; j < ncols; j++)
            {
                if(matrix[i][j] == 2)
                {
                    queue.push(make_pair(i, j));
                }
                else if(matrix[i][j] == 1)
                {
                    oranges++;
                }
            }
        }
        
        if(oranges == 0) return 0;
        
        while(!queue.empty())
        {
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                pair<int, int> curr = queue.front();
                queue.pop();
                int curr_x = curr.first;
                int curr_y = curr.second;
                for(auto d : dirs)
                {
                    int new_x = curr_x + d.first;
                    int new_y = curr_y + d.second;
                    if(isValid(new_x, new_y, matrix))
                    {
                        matrix[new_x][new_y] = 2;
                        oranges--;
                        queue.push(make_pair(new_x, new_y));

                    }
                }
            }
            time++;
            
        }
        
        return oranges == 0 ? time : -1;
        
    }
    
    bool isValid(int i, int j, vector<vector<int>>& matrix)
    {
        int nrows = matrix.size();
        int ncols = matrix[0].size();
        if(i >= 0 and i < nrows and j >= 0 and j < ncols and matrix[i][j] == 1)
        {
            return true;
        }
        
        return false;
    }
};
        