//Time Complexity-O(no. of employees + no. of subordinates)
//Space Complexity-O(no. of employees + no. of subordinates)
//Ran successfully on leetcode
//3 point algo-
	//1.We create a hasmap where each unique id maps to the employee object
	//2a.In the dfs approach, we get the employee corresponding to the target id in O(1) uisng the map,
	//2b)In the bfs approach, we maintain a queue of the ids, and push the subordinate object ids into it using the hashmap.
	//3)For every id we encounter, we add the importance and finally return it.

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
    int sum=0;
public:
	/*dfs
    int getImportance(vector<Employee*> employees, int id) {
        unordered_map<int,Employee*>m;
        for(auto x:employees)
            m.insert({x->id,x});
        dfs(m,id);
        return sum;
    }
    void dfs(unordered_map<int,Employee*>m,int id)
    {
        sum=sum+m[id]->importance;
        for(auto i:m[id]->subordinates)
            dfs(m,m[i]->id);
    }*/
    
	//bfs
    int getImportance(vector<Employee*> employees, int id) {
        unordered_map<int,Employee*>m;
        queue<int>q;
        int sum=0;
        for(auto x:employees)
            m.insert({x->id,x});
        q.push(id);
        while(!q.empty())
        {
            int n=q.size();
            for(int i=0;i<n;i++)
            {
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