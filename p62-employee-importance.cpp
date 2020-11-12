/*
// Definition for Employee.
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};
*/
// Using BFS
// Time complexity is O(V+E) - V = #employees; E = #edges to subordinates
// Space complexity is O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
public:
    int getImportance(vector<Employee*> employees, int id) {
        if(employees.size() == 0) return 0;
        unordered_map<int, Employee*> map;
        int totImp = 0;
        for(int i = 0; i < employees.size(); i++) { // O(V)
            map[employees[i]->id] = employees[i];
        }
        queue<int> q;
        q.push(id);
        
        while(!q.empty()) {
            int currID = q.front();
            q.pop();
            Employee* emp = map[currID];
            totImp += emp->importance;
            for(int i = 0; i < emp->subordinates.size(); i++) { // O(E)
                q.push(emp->subordinates[i]);
            }
         }
        
        return totImp;
    }
};


// using DFS
// Time complexity is O(V+E) - V = #employees; E = #edges to subordinates
// Space complexity is O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
public:
    unordered_map<int, Employee*> map;
    int totImp = 0;
    void dfs(int id) {
        Employee* emp = map[id];
        totImp += emp->importance;
        for(int i = 0; i < emp->subordinates.size(); i++) { // O(E)
            dfs(emp->subordinates[i]);
        }
    }
    int getImportance(vector<Employee*> employees, int id) {
        if(employees.size() == 0) return 0;
        
        for(int i = 0; i < employees.size(); i++) { // O(V)
            map[employees[i]->id] = employees[i];
        }
        dfs(id);
        
        return totImp;
    }
};
