//Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
public:
    int getImportance(vector<Employee*> employees, int id) {
        //BFS solution O(n) space and O(n) time
        map<int,Employee*> m;
        for(int i=0; i<employees.size(); i++){
            m[employees[i]->id]=employees[i];
        }
       
        int imp=0;
        queue<Employee*> q;
        q.push(m[id]);
        
        while(q.empty()==false){
            int size = q.size();
            for(int i=0; i<size; i++){
                Employee* emp = q.front();q.pop();
                imp+=emp->importance;
                vector<int> sub = emp->subordinates;
                for(int i=0; i<sub.size(); i++){
                    q.push(m[sub[i]]);
                }
                
            }
        }
        
        return imp;
    }
};