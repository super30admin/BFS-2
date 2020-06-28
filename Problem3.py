"""
// Time Complexity : o(n), n-> number of employess
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

BFS:
--> start from the employee whose importance has to be calculated
--> add all its subordinates to queue for processing

// Your code here along with comments explaining your approach
"""
from collections import defaultdict, deque

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
        emp = defaultdict(Employee)
        
        for e in employees: #a dictionary to access each employee in o(1)
            emp[e.id] = e
            
        q = deque()
        
        q.append(id)
        
        imp = 0
        while q:
            cur_id = q.popleft()
            
            imp = imp + emp[cur_id].importance
            
            for sub in emp[cur_id].subordinates: #adding subordinates to the queue to be processed
                q.append(sub)
                
        return imp