"""
Problem: 690. Employee Importance
Leetcode: https://leetcode.com/problems/employee-importance/
Time Complexity: O(n), n is the size of the list, traversing once through the list
Space Complexity: O(n), as we're storing values in hashmap and queue parallely, so asymptotically it is O(n)
"""


# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates


from collections import deque


class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        # Define a hasmap for employee ids as key and object of employee class as values
        emap = {}
        queue = deque()

        for e in employees:
            emap[e.id] = e

        # Add given id to the queue
        queue.append(id)
        # Define a var to store total importance of given id and its subordinates
        output = 0

        while queue:
            # take id from queue
            curr = queue.popleft()
            # Add its importance to the output
            output += emap[curr].importance
            # Add each of its subordinates to the queue to be used in next iteration
            for sub in emap[curr].subordinates:
                queue.append(sub)

        return output
