"""
DFS Solution 
Space complexity O(V)+O(E)  [dictionary+stack]

Time complexity O(N) ie O(V+E) -->all employees

"""


"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution_Imp_DFS:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if employees is None or len(employees)==0:
            return 0
        self.res=0
        self.emp={e.id: e for e in employees}
        self.dfs(id)
        return self.res
    
    def dfs(self,id):
        e=self.emp[id]
        self.res+=e.importance
        for sid in e.subordinates:
            self.dfs(sid)
           
            
        
        
        
        