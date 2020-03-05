'''
Iterative:
Time Complexity: O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Add all the elements to the hashmap and use bfs using queue to iterate through the hashmap and add importance
'''



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
    def getImportance(self, employees: List['Employee'], id1: int) -> int:
        mydict = {}

        for i in employees:
            mydict[i.id] = [i.id, i.importance, i.subordinates]

        queue = [(mydict[id1])[0]]
        total = 0
        while len(queue) != 0:
            current = queue[0]

            queue = queue[1:]

            total = mydict[current][1] + total

            for i in range(0, len(mydict[current][2])):
                queue.append(mydict[current][2][i])

        return total

