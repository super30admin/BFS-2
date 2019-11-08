class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Employee> map = new HashMap<>();
        if(employees==null||employees.size()==0) return 0;
        int result = 0;
        //Putting everything in the hashmap--> key:eid, value:list given
        for(Employee emp : employees){
            map.put(emp.id,emp);
        }
        stack.push(id);
        while(!stack.isEmpty()){
            int eid = stack.pop();
            Employee curr_emp = map.get(eid);
            result += curr_emp.importance;
            for(int sub : curr_emp.subordinates){
                stack.push(sub);
            }
        }
        return result;
    }
}
