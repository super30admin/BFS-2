# // Time Complexity : O(n), n is the number of employees
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach: 

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
        
        hMap = {}
        
        #add employees to the hashmap-> O(n)
        for emp in employees:
            hMap[emp.id] = emp
        
        output = 0 
        
        queue = []
        #Implementing BFS
        #add root to queue
        queue.append(id)
        
        while queue:
            front = queue.pop(0)
            output += hMap[front].importance
            #go through all the subordinates of the employee
            for sub in hMap[front].subordinates:
                queue.append(sub)
                
        return output
            
        
        
        
        