/*
 * #690. Employee Importance
 * 
 * You are given a data structure of employee information, which includes the employee's unique id, their importance value and their direct subordinates' id.

For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.

Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all their subordinates.

Example 1:

Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
Output: 11
Explanation:
Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
 

Note:

1. One employee has at most one direct leader and may have several subordinates.
2. The maximum number of employees won't exceed 2000.

 */


/*
 * Time Complexity: O (N) + O (N) = O (2N) = O (N) -> // O (N) - Time to traverse through 'N' employee objects and add ID as key and employee object as value in to HashMap
 * 													 //  O (N) - To traverse through the elements in queue
 * Space Complexity: O (N) -> To store 'N' employee objects in HashMap, Also we are storing the employee ID's in a queue but not all at the same time so it will be around O (N), total space complexity will be O (N)
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.BFS2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Definition for Employee.
class Employee {
 public int id;
 public int importance;
 public List<Integer> subordinates;
};

public class EmployeeImportance {
	public int getImportance(List<Employee> employees, int id) {
        
        // #1. Create a queue using LL
        Queue<Integer> queue = new LinkedList<>();
        
        // #2. Create a HashMap to store 'id' as a key and 'emp object' as a value
        HashMap<Integer,Employee> map = new HashMap<Integer,Employee>();
        
        // #3. Fill the Hashmap with key and value pairs
        // key -> Employee ID
        // value -> whole Employee object
        for(Employee emp : employees){
            map.put(emp.id, emp);
        }
        
        // #4. Initiate queue with given ID
        queue.add(id);
        
        // #5. Initialize the output variable
        int output = 0;
        
        // #6. Regular BFS
        while(!queue.isEmpty()){
            // Remove the front element from queue
            int front = queue.poll();
            
            // Add the removed employee id's importance value to output
            // Get the importance value of an employee from HashMap
            //         key           value
            //          1            [1, 5, [2, 3]]
            //          2            [2, 3, []]
            //          3            [3, 3, []]
            output += map.get(front).importance;
            
            // Add the subordinates of removed element in queue
            // Since, the subordinate values is a list, add each subordinate to queue in a for loop
            for(int x : map.get(front).subordinates){
                queue.add(x);
            }
        }
        
        return output;    // return total importance value for given employee ID and all its subordinates 
        
    }
    
}
