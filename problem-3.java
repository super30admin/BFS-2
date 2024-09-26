//TC:O(N)
//SC:O(N)

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
    Map<Integer,Employee> x = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
             
              for (Employee e : employees)
                  x.put(e.id,e);
   
      return  sub_imp(id);
        
    }


public int sub_imp(int id)
{ 
    int imp=0;
    imp+=x.get(id).importance;

             for(int c : x.get(id).subordinates)
             {
                 imp+=sub_imp(c);
             }

    return imp;
}
    
}