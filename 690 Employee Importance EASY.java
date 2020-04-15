//690. Employee Importance EASY.java
//https://leetcode.com/problems/employee-importance/
//Time Complexity:O(n)
//Space Complexity:O(n) for map
//Time Taken to code: 7 mins
/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        
        
        //getting the currentEMp
        int netWorth = 0;
        Employee currentEmp = null;
        HashMap<Integer, Employee> map = new HashMap<>();
        for( Employee e: employees){
            if(e.id == id){
                currentEmp = e;
            }
            map.put(e.id,e);
        }   
        
        //add his own value
        netWorth += getValue(currentEmp, map);
        return netWorth;
    }
    public int getValue(Employee e, HashMap<Integer, Employee> map){
        
        int netWorth = 0;
        netWorth += e.importance;
        
        //adding each subordinates
        for(int i: e.subordinates){
            
            netWorth += getValue(map.get(i),map);
        }
        return netWorth;
    }
}