// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

var GetImportance = function(employees, id) {
    if(employees == null || employees.length == 0) return 0;
    let map = new Map();
    employees.forEach(({id, importance, subordinates}) => {
        map[id] = {importance, subordinates}
    })
    
    let q = [];
    q.push(id)
    let res = 0;
    
    while(q.length > 0){
        let currEmp = map[q.shift()]
        res += currEmp.importance
            q.push(...currEmp.subordinates)
    } 
    return res   
};