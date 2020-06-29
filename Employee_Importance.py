---------------------------------- Cousins Iterative ---------------------------------------------
# Time Complexity : O(N) N is the list of employees
# Space Complexity : O(N) worst case
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here we can iterate through the employees array and prepare the dictionary by storing the employee id , importance and subordinates.
#We can use queue to fnd the direct and indirect suboridinates. First we will start with id and add the importance of his subordinates.
#Then we can take their subordinates and add the importance and return result variable.

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if not employees:
            return 0
        
        imp = collections.defaultdict(list)
        for p in employees:
            imp[p.id] = [p.subordinates , p.importance]
        res = 0
        queue = collections.deque()
        queue.append(id)
        while queue:
            curr = queue.popleft()
            
            res += imp[curr][1]
            for i in imp[curr][0]:
                queue.append(i)
        return res