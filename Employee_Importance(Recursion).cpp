Time Complexity-O(n)
Space Complexity-O(1) if the recursive stack space is not considered or else it is O(n)
Did the code run on Leetcode? Yes

class Solution {
public:
    int getImportance(vector<Employee*> employees, int id) {
        int res=0;
        unordered_map<int,Employee*>m;
        for(int i=0;i<employees.size();i++)
        {
            m[employees[i]->id]=employees[i];
        }
        eval(res,m,id);
        return res;
    }
     
    void eval(int &res,unordered_map<int,Employee*>m,int &id)
    {
            if(m.find(id)==m.end())
            {
                return;
            }
            res+=m[id]->importance;
            vector<int>k=m[id]->subordinates;
            for(int i=0;i<k.size();i++)
            {
                eval(res,m,k[i]);
            }
    }
};
