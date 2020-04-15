"""
// Time Complexity : O(m + n) m-> number of employees, n-> no of suboordinates
// Space Complexity : O(m + n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Probably missing some edge cases
// Your code here along with comments explaining your approach
Algorithm explanation
    DFS on the given employee obj
"""
"""
# Employee info
class Employee(object):
    def __init__(self, id, importance, subordinates):
        #################
        :type id: int
        :type importance: int
        :type subordinates: List[int]
        #################
        # It's the unique id of each node.
        # unique id of this employee
        self.id = id
        # the importance value of this employee
        self.importance = importance
        # the id of direct subordinates
        self.subordinates = subordinates
"""

class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        def create_graph(employees):
            graph = {}
            for emp in employees:
                emid = emp.id
                if emid not in graph:
                    graph[emid] = emp
            return graph
        
        
        emp_graph = create_graph(employees)
        print(emp_graph)
        #run bfs
        total_importance = 0
        q = [id]
        visited = set()
        while q:
            emp_id = q.pop(0)
            empobj = emp_graph[emp_id]
            total_importance+=empobj.importance
            for empid in emp_graph[emp_id].subordinates:
                if empid not in visited:
                    q.append(empid)
                    visited.add(empid)
                    total_importance+=empobj.importance
        return total_importance