// 690.

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

//return the sum of importance of given employee and all his subordinates
//time - O(n)
//space - O(n)
class Solution {
    int companyImportance = 0;
    HashMap<Integer, Employee> map; //to get constant lookup of all subordiantes of the given employee
    
    public int getImportance(List<Employee> employees, int id) {
        
        //populate map
        map = new HashMap<>();
        for(int i = 0; i < employees.size(); i++)
        {
            Employee current = employees.get(i);
            map.put(current.id, current);
        }
        
        //dfs(id);
        bfs(id);
        
        return companyImportance;
    }
    
    //time - O(n) n -> # of employees, maximum time when given id is at the top of hierarchy
    //space - O(n) n -> # of employees
    private void dfs(int id) {
        
        //similar to preorder - add importance of the given employee to result and recurse on all his subordinates(neighbous or children)
        companyImportance += map.get(id).importance;
        List<Integer> subOrdinates = map.get(id).subordinates;
        if(subOrdinates == null)
        {
            return;
        }
        for(Integer sub: subOrdinates)
        {
            dfs(sub);
        }
        return;
    }
    
    //time - O(n)
    //space - O(n)
    private void bfs(int id) {
        //go level by level and add the importance of each employee in the graph
        Queue<Integer> support = new LinkedList<>();
        support.offer(id);
        
        while(!support.isEmpty())
        {
            Integer current = support.poll();
            companyImportance += map.get(current).importance;
            List<Integer> subOrdinates = map.get(current).subordinates;
            if(subOrdinates == null)
            {
                return;
            }
            for(Integer sub: subOrdinates)
            {
                support.offer(sub);
            }
        }
        
        return;
    }
}
