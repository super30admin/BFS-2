'''
PROBLEM 1

TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(N)

- traverse the nodes in the tree checking the values of their children with values of x and y
- if either left or right children is equal to x, update X_found=True and X_parent as value of the node
- at the end of processing nodes at each level, if one of the x and y is found and other is not, return False, if both are found, compare parents of x and y
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        X_parent=None
        Y_parent=None
        X_found=False
        Y_found=False
        
        queue=deque()
        queue.append(root)
        
        while(len(queue)!=0):
            size=len(queue)
            

            
            for i in range(size):
                popped=queue.popleft()
               

                if popped.left!=None:
                    queue.append(popped.left)
                    if popped.left.val==x:
                        X_parent=popped.val
                        X_found=True
                    elif popped.left.val==y:
                        Y_parent=popped.val
                        Y_found=True
                if popped.right!=None:
                    queue.append(popped.right)
                    if popped.right.val==y:
                        Y_parent=popped.val
                        Y_found=True
                    elif popped.right.val==x:
                        X_parent=popped.val
                        X_found=True
                    
            if (X_found==True and Y_found==False) or (X_found==False and Y_found==True):
                return False
            
            if X_found==True and Y_found==True:
                if X_parent==Y_parent:
                    return False
                else:
                    return True


'''
PROBLEM 2

TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(N)

- traverse the matrix and add all the rotten orange coordinates in the queue
- process all the elements in the queue at a time and add their neighbours in queue if they are fresh  oranges
- at the end of each iteration, if queue is not empty, then increment the time variable
'''

from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if len(grid)==0:
            return 0
        self.time=0
        queue=deque()
        dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==2:
                    queue.append([i,j])
                    
        while(len(queue)!=0):
            size=len(queue)
            
            for k in range(size):
                popped=queue.popleft()

                for d in dirs:
                    row=popped[0]+d[0]
                    col=popped[1]+d[1]

                    if row>=0 and row<len(grid) and col>=0 and col<len(grid[0]) and grid[row][col]==1:
                        grid[row][col]=2
                        queue.append([row,col])
            if len(queue)!=0:
                self.time+=1
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==1:
                    return -1
        return self.time
        
'''
PROBLEM 3

TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(N)

- traverse the list and add each employee into the hashmap with employee id as key and entire employee object as value
- for a given employee, add it to the queue
- processing each element in queue, keep adding its importance and keep adding the subordinates in the queue
'''

"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

from collections import deque
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        importance=0
        hashmap={}
        for i in employees:
            hashmap[i.id]=i
        # print(hashmap)
        
        queue=deque()
        queue.append(id)
        
        while(len(queue)!=0):
            popped=queue.popleft()
            importance+=hashmap[popped].importance
            for i in hashmap[popped].subordinates:
                queue.append(i)
        return importance