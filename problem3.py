#time complexity O(v+e) number of employees+ respective subordinates
#space complexity O(v)
"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
"""
created the hash map with  employee id and employee
using bfs
adding id of parameter  in the queue then while poping i got the id and checking in the hash all the subordinates of the respective id  and adding them the queue 

"""
class Solution:
    total=0
    _hash={}
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        #bfs
      
        
        for e in employees:
            self._hash[e.id]=e
        self.total=0
        
      
        return self.dfs(id)
    def dfs(self,id):
        self.total+=self._hash[id].importance
        for sid in self._hash[id].subordinates:
            self.dfs(sid)
        return self.total
        
        
        
        
        
    """
        bfs
        _hash={}
        for e in employees:
            _hash[e.id]=e
        total=0
        queue=[]
        queue.append(id)
        while queue:
            tempid=queue.pop(0)
            total+=_hash[tempid].importance
            for sid in _hash[tempid].subordinates:
                queue.append(sid)
        return total        
                
        """