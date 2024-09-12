"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
#Time Complexity:O(v+e)
#Space Comlexity:O(n)

#DFS Solution:

#Algorithm:
# 1. Create a hashmap to store the employees and their objects.
# 2. write a helper function to add the importance of the employee and their subordinates by calling them recursively. 
# 3. return the result.
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if not employees: return 0
        hashMap={e.id:e for e in employees}
        def helper(id):
            result=hashMap[id].importance
            for sub in hashMap[id].subordinates:
                result+=helper(sub)
            return result
        return helper(id)
#         if not employees: return 0
#         hashMap={e.id:e for e in employees}
#         def helper(id):
#             result=hashMap[id].importance
#             for sub in hashMap[id].subordinates:
#                 result+=helper(sub)
#             return result
#         return helper(id)
        
