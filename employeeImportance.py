#Time Complexity : O(n) where n is number of employees
#Space Complexity :  O(n) where n is number of employees

#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: First we iterate through the employees list and make two dictionaries of importance and subordinates. Now doing dfs, keep a result variable and pass the id of the employee to the helper dfs function of  who you want to find the result for and iterate through it's subordinates, adding their importance in the result and further going children of subordinates doing the same thing recursively.


"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    def helper(self, emp):
        for sub in self.emps[emp].subordinates:
            self.result += self.emps[sub].importance
            self.helper(sub)

    def getImportance(self, employees: List['Employee'], id: int) -> int:
        self.emps = {}
        for emp in employees:
            self.emps[emp.id] = emp

        self.result = self.emps[id].importance
        self.helper(id)
        return self.result
