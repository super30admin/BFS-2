# Both the approaches will have same time & space complexity analysis.
# Time Complexity : O(n), where n is the number of total employees.
# Space Complexity: O(n), where n is the number of total employees.
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach
from collections import deque
class Solution(object):
    # This approach uses bfs where all subsequent employees for
    # the given employee will be processed to add their importance.
    def getImportanceBFS(self, employees, id):
        if not employees:
            return 0
        # hashmap init of adjacency list
        store = {}
        for i in employees:
            store[i.id] = i

        totalVal = 0
        queue = deque()
        queue.appendleft(id)
        # bfs for all and subsequent subordinates
        while len(queue) != 0:
            curr = queue.pop()
            e = store[curr]
            totalVal += e.importance
            for i in e.subordinates:
                queue.appendleft(i)

        return totalVal

#------------------------------------------------------x---------------------------------------------------------------#

    # this approach uses dfs where all subsequent employees are processed but
    # not at the same time and rather until one employee has no more subordinates.
    def __init__(self):
        self.store = {}
        self.retVal = 0

    def getImportanceDFS(self, employees, id):
        if not employees:
            return 0
        # hashmap init of adjacency list
        for i in employees:
            self.store[i.id] = i
        self.dfs(id)
        return self.retVal

    def dfs(self, id):
        # get employee object
        e = self.store[id]
        # add importance to total
        self.retVal += e.importance
        # recursive call for every subordinate
        for i in e.subordinates:
            self.dfs(i)
