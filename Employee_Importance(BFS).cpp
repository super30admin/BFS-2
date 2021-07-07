Time Complexity-O(n)
Space Complexity-O(n)
Did the code run on Leetcode? yes

class Solution {
public:
    int getImportance(vector<Employee*> employees, int id) {
        int res=0;
        unordered_map<int,Employee*>m;
        for(int i=0;i<employees.size();i++)
        {
            m[employees[i]->id]=employees[i];
        }
        queue<int>k;
        k.push(id);
        while(!k.empty())
        {
            int size=k.size();
            while(size!=0)
            {
                int temp=k.front();
                k.pop();
                if(m.find(temp)!=m.end())
                {
                    res+=m[temp]->importance;
                    for(int i=0;i<m[temp]->subordinates.size();i++)
                    {
                        k.push(m[temp]->subordinates[i]);
                    }
                }
                size--;
            }
        }
        return res;
    }
};
