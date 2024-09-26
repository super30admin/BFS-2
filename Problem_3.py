# 690. Employee Importance
# 



# Code
# Approach: BFS

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
        emap = {e.id: e for e in employees}
        
        q = collections.deque()
        
        q.append(emap[id])
        
        res = 0
        
        while q:
            curr = q.popleft()
            res+=curr.importance
            
            for sub in curr.subordinates:
                q.append(emap[sub])
        
        return res

                
# Time Complexity: O(N)
# Space Complexity: O(N)
# Accepted on Leetcode: Yes.