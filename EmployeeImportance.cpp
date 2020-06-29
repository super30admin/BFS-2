// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//BFS Approach

class Solution {
public:
    int getImportance(vector<Employee*> employees, int id) {
        unordered_map<int,Employee*> map;
        int result = 0;
        if(employees.size()==0)
            return result;
        for(int i=0;i<employees.size();i++){
            map[employees[i]->id] =employees[i];
        }
        queue<int> q;
        q.push(id);
        while(!q.empty()){
            int eid = q.front();
            q.pop();
            result = result + map[eid]->importance;
            for(auto it: map[eid]->subordinates){
                q.push(it);
            }
        }
        return result;
    }
};
