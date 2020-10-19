//time complexity:O(n)
//space complexity:O(n)
//executed on leetcode: yes
//approach:using bfs
//any issues faced? yes, but understood it

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
        int res=0;
        map<int,Employee*>map;
        for(Employee* e:employees)
        {
            map[e->id]=e;
        }
        queue<int>q;
        q.push(id);
        while(!q.empty())
        {
            int curr=q.front();
            q.pop();
            res=res+map[curr]->importance;
            for(int sub: map[curr]->subordinates)
            {
                q.push(sub);
            }
        }
        return res;
    }
};