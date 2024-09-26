# // Time Complexity : O(E+V)
# // Space Complexity : O(E+V)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No 

# Definition for Employee.
# class Employee:
#     def __init__(self, id: int, importance: int, subordinates: List[int]):
#         self.id = id
#         self.importance = importance
#         self.subordinates = subordinates

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        
        hashmap = {}
        
        for i in employees:
            hashmap[i.id] = i #O(V)
        
        q = deque() #O(E)
        q.append(id)
        res = 0 
        while q:
            cur = q.popleft()
            res += hashmap[cur].importance
            k=hashmap[cur].subordinates
            for i in k:
                q.append(i)
        
        return res
