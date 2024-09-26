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
       

        hmap ={}

        for e in employees:
            hmap[e.id]=(e.id, e.importance,e.subordinates)
        #print(hmap)

        queue = []

        queue.append(id)

        output = 0

        while queue:
            curr = queue.pop(0)

            output+=hmap[curr][1]

            for sub in hmap[curr][2]:
                queue.append(sub)


        return output

# Time Complexity: O(n)
# Space Complexity : O(n+m) = O(n) 
# n for queue and m for dictionary