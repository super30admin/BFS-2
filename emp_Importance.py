# Leetcode 690. Employee Importance

# Time Complexity :  O(n) where n is the number of the emplyees

# Space Complexity : O(n) where n is the number of the emplyees for hashmap

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Add the employee ID as key and employee object as value in hashmap
# DFS :: Get the employee details from hashmap for every employee. Update the result with the importance
# score and recursively call the dfs on subordinates.
# BFS :: Use a queue to store next level employee IDs. As long as the queue is not empty, pop the left ID
# update the importance score and add the subordinate IDs to the queue for next level.

# Your code here along with comments explaining your approach

# Definition for Employee.
from collections import deque

# class Employee:
#     def __init__(self, id: int, importance: int, subordinates: List[int]):
#         self.id = id
#         self.importance = importance
#         self.subordinates = subordinates

# DFS Solution


class Solution:

    result = 0
    eMap = dict()

    def getImportance(self, employees: List['Employee'], id: int) -> int:
        # Storing (empID, employee obj) in hashmap aka adjacency list
        for emp in employees:
            self.eMap[emp.id] = emp
        self.result = 0
        self.dfs(id)
        return self.result

    def dfs(self, id):
        # Getting the details of an employee from ID
        employee = self.eMap[id]
        # Updating global importance score sum
        self.result += employee.importance
        # recurrsive call for subordinate employees
        for empID in employee.subordinates:
            self.dfs(empID)


# BFS Solution
class Solution:

    def getImportance(self, employees: List['Employee'], id: int) -> int:
        # hashmap to store (empID, employee obj)
        eMap = dict()
        result = 0
        # Storing (empID, employee obj) in hashmap aka adjacency list
        for emp in employees:
            eMap[emp.id] = emp
        # Queue to initate BFS on given ID and store IDs
        q = deque()
        # Appending given ID to queue
        q.append(id)
        # While q is not empty
        while q:
            # GEt the left most ID
            eID = q.popleft()
            # Fetching employee object from hashmap for the ID from queue
            employee = eMap[eID]
            # Updating importance score sum
            result += employee.importance
            # Adding the subordinate employee IDs from the employee object to queue for further processing
            for empID in employee.subordinates:
                q.append(empID)
        # Returning result after all the eIDs in queue are visited
        return result
