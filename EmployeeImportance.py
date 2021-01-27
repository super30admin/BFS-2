"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
from collections import deque
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        # Time Complexity - O(N)
        # Space Complexity - O(N)
        
        # base case
        if employees == None:
            return 0
        
        output = 0
        hmap={} # Taking map to make loopup in O(1) Space time trade off
        
        for e in employees:
            hmap[e.id]=e # For a particular id, we are storing whole employee data structure for that particular id
        queue=deque()
        queue.append(id)
        
        while queue:
            cur=queue.popleft()
            output=output+hmap[cur].importance
            for sub in hmap[cur].subordinates: # Appending all the subordinates to the queue
                queue.append(sub)
                
        return output
        