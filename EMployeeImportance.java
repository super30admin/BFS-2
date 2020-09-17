//Time Complexity: O(n*m) where n is the number of employees to iterate and m is the subordinate list
//Space Complexity: O(m) where m is the list of all sub orinates 

import java.util.*;

public class EMployeeImportance {
    public static int getImportance(List<Employee> employees, int id) {
        helper(employees, id);
        return sum;
    }
    //Q to keep trak of the sub ordinates
    static Queue<Integer> q = new LinkedList<Integer>();
    static int sum = 0;
    public static void helper(List<Employee> employees, int id){
        for(Employee e : employees){
            if(e.id == id){
                sum += e.importance;
                //Adding the subordinates to the Q
                for(Integer i : e.subordinates){
                    q.add(i);
                }
            }            
        }
        //Recursing the subordinates until the Q is empty
        while(!q.isEmpty()){
            helper(employees, q.remove());
        }
    }
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
}