# problem 1 : 993. Cousins in Binary Tree : https://leetcode.com/problems/cousins-in-binary-tree/
# Time Complexity : O(n) 
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        print(root)
        
        if root.val == x or root.val == y :
            return False
        
        head = root
        q = []
        q.append((root,0))
        x_l, y_l = 0,0
        x_p, y_p = TreeNode(0), TreeNode(0)
        while q :
            if x_l != 0 and y_l != 0 :
                break
            node, level = q.pop()
            if node.left:
                if node.left.val == x :
                    x_p = node
                    x_l = level + 1
                if node.left.val == y :
                    y_p = node
                    y_l = level + 1
                q.append((node.left, level + 1))
            if node.right:
                if node.right.val == x :
                    x_p = node
                    x_l = level + 1
                if node.right.val == y :
                    y_p = node
                    y_l = level + 1

                q.append((node.right, level + 1))
        if x_l == y_l and x_p is not y_p :
            return True
        return False
    
# problem 2 : 994. Rotting Oranges : https://leetcode.com/problems/rotting-oranges/
# Time Complexity : O(n) 
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not List:
            return 0
        rows, cols, count, fresh = len(grid), len(grid[0]), 0, 0
        de = deque()
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 2:
                    de.append((i,j,0))
                elif grid[i][j] == 1:
                    fresh += 1
        
        while de:
            r, c, count = de.popleft()
            d = [(-1,0), (1,0), (0,-1), (0,1)]
            for ele in d:
                if (0 <= r+ele[0] < rows) and (0 <= c+ele[1] < cols) and grid[r+ele[0]][c+ele[1]] == 1:
                    grid[r+ele[0]][c+ele[1]] = 2
                    de.append((r+ele[0],c+ele[1], count+1))
                    fresh -= 1
        
        return count if fresh == 0 else -1
        
# problem 3 : 690. Employee Importance : https://leetcode.com/problems/rotting-oranges/
# Time Complexity : O(n) 
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
    
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
        dic = {}
        if not employees:
            return 0
        for emp in employees:
            dic[emp.id] = emp
        de = deque([id])
        res = 0
        while de:
            ind = de.popleft()
            res += dic[ind].importance
            for i in dic[ind].subordinates:
                de.append(i)
        return res
        

        