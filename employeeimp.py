"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

# Iterative solution
# Time complexity - O(n)
# Space complexity - O(2n)
# Did this solution run on leetcode? - yes
from collections import deque
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        # create a dictionary of employees with their importance score and subordinates information.  
        # Adjacency list
        empDict = {empInfo.id: empInfo for empInfo in employees}    # space - O(n) # id - storing the object reference / id - index of the object in the array
        
        importance = 0
        q = deque([id])
        while q:    #space - O(n-1)
            currEmp = q.popleft()
            importance += empDict[currEmp].importance   # sum up the importance scores
            q.extend(empDict[currEmp].subordinates)     # add the subordinates information to the queue.
            
        return importance
            

# Recursive solution
# Time complexity - O(n)
# Space complexity - O(2n) # n for the implicit stack and n for the hash map
# Did this solution run on leetcode? - yes
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        # create a dictionary of employees with their importance score and subordinates information.            
        empDict = {empInfo.id: empInfo for empInfo in employees}
        # recursive call.
        def rec(eid):
            return empDict[eid].importance + sum(rec(emp) for emp in empDict[eid].subordinates)
        return rec(id)
        