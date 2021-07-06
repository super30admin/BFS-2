# Time Complexity: O(N)
# Space Complexity: O(N)
# Passed Leetcode

from collections import deque
"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        adj_list = {}
        
        for employee in employees:
            
            adj_list[employee.id] = (employee.importance, employee.subordinates)
            
        queue = deque([id])
        total = 0
        
        while len(queue) > 0:
            
            curr_id = queue.popleft()
        
            importance, subordinates = adj_list[curr_id]
            
            total += importance
            
            for subordinate in subordinates:
                
                queue.append(subordinate)
        return total
            