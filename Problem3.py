
"""

    Name : Shahreen Shahjahan Psyche
    Time : O(M * N)
    Space : O(N)

    This code passed all the test cases in Leetcode

"""
from typing import List


# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        if not employees:
            return 0
        
        # creating a hashmap so that I dont have to find an employee in linear time using the employee id
        records = {}
        
        for i in range(len(employees)):
            records[employees[i].id] = employees[i]
            
        
        from collections import deque
        
        q = deque()
        value = 0
        
        q.append(id)
        
        while(q):
            tmp = q.pop()
            emp = records[tmp]
            value += emp.importance
            for i in emp.subordinates:
                q.append(i)
        
        return value