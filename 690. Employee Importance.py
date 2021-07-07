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
        
        hm = {e.id:e for e in employees}
        def helper(id):
            return hm[id].importance + sum(helper(e) for e in hm[id].subordinates )
            
        return(helper(id))
Time: O(n) Worst Case
Space: O(n)