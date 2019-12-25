# Time Complexity : O(m*n)
# Space Complexity : O(m*n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Traversal

"""
# Employee info
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        # It's the unique id of each node.
        # unique id of this employee
        self.id = id
        # the importance value of this employee
        self.importance = importance
        # the id of direct subordinates
        self.subordinates = subordinates
"""
class Solution:
    def helper(self, graph, key):
        return graph[key][1] + sum(self.helper(graph, new_key) for new_key in graph[key][0])

        
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        graph = {}
        for emp in employees:
            if emp.id not in graph:
                graph[emp.id] = (emp.subordinates, emp.importance)
        return self.helper(graph, id)
    
   