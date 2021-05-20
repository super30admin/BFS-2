/*
////////////////////////////////////////////////////
Intuition: This is a graph problem as it can have 2 nodes and each employee has subordinates (like parent has a child)
A tree cannot have 2 start nodes.
////////////////////////////////////////////////////
In this graph, we can do both bfs and dfs. We will require an adjacentcy list.
////////////////////////////////////////////////////
Time Complexity for both:
O(N), N = number of nodes
////////////////////////////////////////////////////
Space Complexity for both: 
O(N), N = number of nodes we will be storing in the adjacency list.
Note: In both DFS and BFS, a stack or queue will be used but the space complexity for those will be lower than space required for the Adjacency list
////////////////////////////////////////////////////

// Definition for Employee.
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};
*/


//BFS
class Solution {
public:
    int getImportance(vector<Employee*> employees, int id) {     
        if (employees.size() == 0){
            return 0;
        }
        map <int, Employee*> hashMap;
        vector <int> queue;
        queue.push_back(id);

        int result = 0;
        
        for (int i = 0; i < employees.size(); i++){
            id = employees[i]->id;
            hashMap[id] = employees[i];
        }

        for(auto i: queue){
            cout<<i<<"queue element\n";
        }
        while (queue.size() != 0){
            int currEmp = queue.front();
            queue.erase(queue.begin());
            cout <<currEmp<<"Current emp\n";
            result +=  hashMap[currEmp]->importance;
            for (auto itr:  hashMap[currEmp]->subordinates){
                queue.push_back(itr);
            }
        }
        return result;
    }
};

//DFS 
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
    int result;
    map <int, Employee*> hashMap;
    int getImportance(vector<Employee*> employees, int id) {
        if (employees.size() == 0){
            return 0;
        }
        int result = 0;
        for (auto empObj : employees){
            hashMap[empObj->id] = empObj;
        }
        return dfs(id);
    }
    
    
    int dfs(int id){
        result += hashMap[id]->importance;
        for (auto sub: hashMap[id]->subordinates){
            dfs(sub);
        
        }
        return result;
    }
};