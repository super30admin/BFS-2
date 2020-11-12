"""
BFS Solution 
Space complexity O(N)+O(N) [O(V)+O(E)] [dictionary+queue]

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

class Solution_Imp_BFS:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if employees is None or len(employees)==0:
            return 0
        emp={e.id: e for e in employees}
        q=[]
        q.append(id)
        res=0
        while q:
            id=q.pop(0)
            e=emp[id]
            
            res+=e.importance
           
            for sid in e.subordinates:
                q.append(sid)
        
        return res
        
        
        
        