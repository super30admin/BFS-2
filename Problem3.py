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
        dic = {}
        queue = deque()
        for emp in employees:
            dic[emp.id] = [emp.importance, emp.subordinates]
        queue.append([id])
        importance = 0
        while len(queue) > 0:
            myid = queue.popleft()
            for i in range(len(myid)):
                importance += dic[myid[i]][0]
                queue.append(dic[myid[i]][1])
        return importance
            
