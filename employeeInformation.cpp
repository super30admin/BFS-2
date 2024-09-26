//Time Complexity-O(N)
//Space Complexity-O(N)
//Runs successfully on Leetcode

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
        unordered_map<int,Employee*>m;
        queue<int>q;
        int sum=0;
        for(auto x:employees)
            m.insert({x->id,x});
        q.push(id);
        while(!q.empty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                auto Eid=q.front();
                q.pop();
                Employee*E=m[Eid];
                sum=sum+E->importance;
                for(auto y:E->subordinates)
                    q.push(y);
            }
        }
        return sum;
    }
};