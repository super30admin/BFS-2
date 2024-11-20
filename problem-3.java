// Time Complexity :
//      N - number of employees
//      total time complexity will be O(N)
//
// Space Complexity :
//      O(N)->at a time there might be all the employees (subordinates) present in the queue in the worst case
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        //creating hashmap to add all the employee ids with their objects
        HashMap<Integer, Employee> hm  = new HashMap<>();
        if(employees==null)
            return 0;
        int empImp = 0;
        //looping through the list employees and getting each object in the list
        for(Employee emp:employees)
        {
            hm.put(emp.id, emp);
        }
        //queue shall contain the employee id whose emp importance is to be calculated
        //we shall also id to get its subordinates list and loop through it further
        Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        while(!q.isEmpty())
        {
            int val = q.poll();
            Employee e = hm.get(val);
            empImp = empImp + e.importance;
            //looping through the subordinate list by addressing employee object
            for(int subOrd:e.subordinates)
            {
                //add all the subordinates id into queue to get their emp importance as well
                q.offer(subOrd);
            }
        }
        return empImp;
    }
}