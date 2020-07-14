// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//DFS technique is used to traverese through the employee list and calculate the importance accordingly
/*
// Employee info
class Employee {
public:
    // It's the unique ID of each node.
    // unique id of this employee
    int id;
    // the importance value of this employee
    int importance;
    // the id of direct subordinates
    vector<int> subordinates;
};
*/

class Solution {
public:
    unordered_map<int, Employee*> mymap;
    int calc_imp;
    int getImportance(vector<Employee*> employees, int id) {
        //base case
        if(employees.size() == 0){
            return 0;
        }
        //logic
        for(int i =0; i<employees.size(); i++){
            mymap[employees[i]->id] = employees[i];
        }
        
        helper(id);
        return calc_imp; 
        
    }
    
    private:
    void helper(int id){
        //return condition
        if(mymap[id]->subordinates.size()==0){
            calc_imp = calc_imp + mymap[id]->importance;
            return ;
        }
        Employee* emp= mymap[id];
        calc_imp = calc_imp + emp->importance;
        for(int i=0; i<emp->subordinates.size(); i++){
            helper(emp->subordinates[i]);
        }
    }
};
