# Time Complexity:- O(n) 
# Space Complexity:- O(n)
# Approach:- Prepare a hashmap of all the employee ids and store their importance and subordinates in a map. Do a bfs from the start id and keep adding all the importance
# and return the result
import collections

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
        q=collections.deque([])
        importance={}
        for employee in employees:
            importance[employee.id]=[employee.importance,employee.subordinates]
        q.append(id)
        res=0
        while(q):
            node=q.popleft()
            res+=importance[node][0]
            for i in importance[node][1]:
                q.append(i)
        return res
            
            
            