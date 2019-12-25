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


/**
Leet Code Submitted : YES
Space Complexity : O(N)
Time Complexity : O(N)

The idea is to iterate the employee data and then recursively calculate the importance score .
I used HashMAP to store the Employee Data which can be avoided.

**/
class Solution {
    int impscore = 0;
    public int getImportance(List<Employee> employees, int id) {
     
        //HashMap<Integer,List<Integer>> hm1 = new HashMap<>();
        //HashMap<Integer,Integer> hm2  =  new HashMap<>();
        HashMap<Integer,Employee> hm3 = new HashMap<>(); 
        
       /* //HashMap 1
        for(Employee e : employees){
            if(!hm1.containsKey(e.id) && !hm2.containsKey(e.id)){
                List<Integer> l = new ArrayList<>();
                hm1.put(e.id,e.subordinates);
                hm2.put(e.id,e.importance);
                
            }
        }*/
        
        for(Employee e : employees){
            if(!hm3.containsKey(e.id)){
                hm3.put(e.id,e);
            }
        }
        
        
        
        if(hm3.containsKey(id))
                impscore += hm3.get(id).importance;
        
        calculateScore(hm3, id);
        return impscore;
        
        
        
    }
    
    private void calculateScore(HashMap<Integer,List<Integer>> hm1, HashMap<Integer,Integer> hm2, int id){
        //calculate Importance score for the ID
        if(hm1.containsKey(id)){
            List<Integer>  subordinates = hm1.get(id);  
            for(Integer i : subordinates){
                if(hm2.containsKey(i)){
                    impscore += hm2.get(i);
                }
                
                calculateScore(hm1,hm2,i);
            }
            
        }
        
    }
    
     
    private void calculateScore(HashMap<Integer,Employee> hm, int id){
        //calculate Importance score for the ID
        if(hm.containsKey(id)){
            Employee e   = hm.get(id);  
            for(Integer i : e.subordinates){
                if(hm.containsKey(i)){
                    impscore += hm.get(i).importance;
                }
                
                calculateScore(hm,i);
            }
            
        }
        
    }
}
