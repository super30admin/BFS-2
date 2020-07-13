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
        queue<Employee*> Q;
        unordered_map<int, Employee*>m;
        for(auto x: employees) m[x->id] = x;
        int importance=0;
        Q.push(m[id]);
        while(!Q.empty()){
            Employee* temp = Q.front();
            importance+=temp->importance;
            Q.pop();
            for(int i:temp->subordinates){
                Q.push(m[i]);
            }
        }
        return importance;
    }
};