# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach
"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    hMap = {}
    res = 0
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        for i in employees:
            self.hMap[i.id] = i

        # self.bfs(id)
        # self.dfs(id)
        self.dfsRec(id)
        
        return self.res

    def bfs(self, id):
        q = deque()
        q.append(id)
        while len(q) != 0:
            size = len(q)
            
            for i in range(size):
                curr = q.popleft()
                self.res += self.hMap[curr].importance
                for j in self.hMap[curr].subordinates:
                    q.append(j)
                    
    def dfs(self, id):
        stk = []
        stk.append(id)
        
        while len(stk) != 0:
            curr = stk.pop()
            self.res += self.hMap[curr].importance
            for j in self.hMap[curr].subordinates:
                stk.append(j)
                
    def dfsRec(self,id):
        self.res += self.hMap[id].importance
        
        for i in self.hMap[id].subordinates:
            self.dfsRec(i)