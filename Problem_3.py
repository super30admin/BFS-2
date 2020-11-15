"""
Time Complexity : O(v+e) - as its a graph
Space Complexity : O(v+e)- Here v stands for space of hashmap and e stands for the queue
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


I have done both BFS and DFS here and commented the BFS one. For both the solutions, we need to create a hashmap
which acts as an adjacency matrix storing id of employee as a key and its reference as value.For BFS, we 
put the id given inside the queue and start iterating the loop on all its children one by one and keep adding 
them to the queue. Side by side, we increment the importance value. For DFS, we call the recursive function on 
its children
"""

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
        if not employees:
            return 0
        self.d = {}
        for e in employees:
            self.d[e.id] = e
        self.imp = 0
        self.dfs(id)
        return self.imp

    def dfs(self, ids):

        self.imp += self.d[ids].importance
        children = self.d[ids].subordinates
        for c in children:
            self.dfs(c)
# from collections import deque
# class Solution:
#     def getImportance(self, employees: List['Employee'], id: int) -> int:
#         if not employees:
#             return 0
#         d={}
#         for e in employees:
#             d[e.id]=e
#         imp=0
#         q=deque()
#         q.append(id)
#         while q:
#             curr=q.popleft()
#             imp+=d[curr].importance
#             children=d[curr].subordinates
#             for c in children:
#                 q.append(c)
#         return imp
