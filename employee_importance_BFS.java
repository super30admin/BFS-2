class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Employee> map = new HashMap<>();
        if(employees==null||employees.size()==0) return 0;
        int result = 0;
        //Putting everything in the hahsmap
        for(Employee emp : employees){
            map.put(emp.id,emp);
        }
        queue.add(id);
        while(!queue.isEmpty()){
            int eid = queue.poll();
            Employee curr_emp = map.get(eid);
            result += curr_emp.importance;
            for(int sub : curr_emp.subordinates){
                queue.add(sub);
            }
        }
        return result;
    }
}
