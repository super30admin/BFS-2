"""
Time complexity: O(N)
Space complexity: O(N)
Compiled on leetcode: Yes
Difficulties faced: No
"""
from collections import deque
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        total = 0
        importanceDictionary = {}
        
        for employee in employees:
            importanceDictionary[employee.id] = employee
        
        queue = deque()
        queue.append(importanceDictionary[id])
        
        while queue:
            currentEmployee = queue.popleft()
            total += currentEmployee.importance
            if len(currentEmployee.subordinates) > 0:
                for subordinate in currentEmployee.subordinates:
                    queue.append(importanceDictionary[subordinate])
        return total            
        