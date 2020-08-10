class EmployeeImportance{
    int result;
    Map<Integer,Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() ==0){
            return 0;
        }
        map = new HashMap<>();
        for(Employee e:employees){
            map.put(e.id,e);
        }
        _dfs(id);
        return result;
    }

    private void _dfs(int id){
        Employee temp = map.get(id);
        result+=temp.importance;

        for(int i=0;i<temp.subordinates.size();i++){
            _dfs(temp.subordinates.get(i));
        }
    }
    //Time complexity : o(n) -> n is number of employees
    // space complexity : max depth of tree
}