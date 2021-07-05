# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        self.emap = {e.id: e for e in employees}
        return self.dfs(id)
    
    def dfs(self, eid):
        employee = self.emap[eid]
        return (employee.importance + sum(self.dfs(eid) for eid in employee.subordinates))