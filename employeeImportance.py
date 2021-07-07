"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
"""
// Time Complexity : O(N)
// Space Complexity : O(N)
// Leetcode passes: yes
// Any problems while solving this problem : no
"""

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        output = 0
        graph = {}
        for employee in employees:
            graph[employee.id] = employee
            
        queue = []
        queue.append(id)
        
        while queue:
            
            curr = queue.pop(0)
            output += graph[curr].importance
            for j in graph[curr].subordinates:
                queue.append(j)
                
        return output
        