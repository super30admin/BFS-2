// Time Complexity : O(V+E) - V number of nodes-employees, E number of edges-total number of subordinates 
// Space Complexity : O(n); 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Note: An input like 2 and 3 are subordinates of 1 and 2 is also a subordinate of 3 is also psbl

// 1. BFS iteration, don't maintain visited since consider above eg. here importance of 2 needs to added twice
// 2. Maintain a queue and add employees to it. Pop it, add importance and add subordinates
// 3. Note that subordinates are given as int and note Employee* so we would need to find them in the input vector making it O(n^2)
// 4. To avoid it, create a map of employee id and Employee* to make it O(n) totally

/*
// Definition for Employee.
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};
*/

class Solution {
public:
    int getImportance(vector<Employee*> employees, int id) {
        if(employees.size() == 0)
            return 0;
        queue<Employee*> q;
        map<int, Employee*> record;
        for (auto employee: employees)
            record[employee->id] = employee;
        int imp = 0;
        q.push(record[id]);
        while(!q.empty()){
            auto employee = q.front(); q.pop();
            imp += employee->importance;
            for(int subord: employee->subordinates)
                q.push(record[subord]);
        }
        return imp;
    }
};

// DFS
// Time Complexity : O(V+E) - V number of nodes-employees, E number of edges-total number of subordinates 
// Space Complexity : O(n); 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Note: An input like 2 and 3 are subordinates of 1 and 2 is also a subordinate of 3 is also psbl

// 1. DFS traversal: pass importance by reference to recursive function
// 2. In recursive function, add importance and recursively call for all subordinates
// 3. Keep map global or pass by reference both take similar time while passing by value takes huge time and space

class Solution {
public:
    map<int, Employee*> record;
    int getImportance(vector<Employee*> employees, int id) {
        if(employees.size() == 0)
            return 0;
        // map<int, Employee*> record;
        for (auto employee: employees)
            record[employee->id] = employee;
        int imp = 0;
        dfs(id, imp);
        return imp;
    }
    
    void dfs(int id, int& imp){
        // base
        // nothing since we iterate over for loop so won't overrrun
        // logic
        auto emp = record[id];
        imp+=emp->importance;
        for(int subord: emp->subordinates)
            dfs(record[subord]->id, imp);
    }
};

