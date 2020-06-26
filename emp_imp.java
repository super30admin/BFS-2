/**
 * Time: O(n) n- no of employees
 * Space: O(n)
 *
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer, Employee> hmap;
    int imp;
    public int getImportance(List<Employee> employees, int id) {
        hmap = new HashMap<Integer,Employee>();
        for(Employee e: employees){
            hmap.put(e.id,e);
        }
        helper(id);
        return imp;
    }
    public void helper(int id){
        Employee e = hmap.get(id);
        imp += e.importance;

        List<Integer> sub = e.subordinates;
        for(int i: sub){
            helper(i);
        }
    }
}