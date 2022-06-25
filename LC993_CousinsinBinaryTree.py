"""
We solve using BFS and we check if the nodes have different parents and same level
APPROACH 1

DFS Recursive:
We will look for the given nodes and maintain their parents and heights

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        # check few base conditions, such as:
        # root is not None,
        # root left is None and right is not None
        # root right is None and left is not None
        # or root value is one of the x or y values
        # in all these cases the result would be False
        if (not root or (root.left is None and root.right is not None) or
          (root.right is None and root.left is not None)) or root.val in (x,y):
            return False
        
        # create empty results list and pass it to the helper and depth is 0
        res = self.helper(root,x,y,[], 0)
        # once returned from recursion, result list should have 0th index in both tuples to be
        # not equal, meaning parents not same, but 1st index should be equal meaning they are at equal depth
        return res[0][0] != res[1][0] and res[0][1] == res[1][1]
            
    def helper(self, node, x, y, results, depth):
        # base
        if not node:
            return
        
        # logic
        # if left value is one of the x or y, add current node value and depth to results
        if node.left and node.left.val in (x,y):
            results.append((node.val, depth))
        # if right value is one of the x or y, add current node value and depth to results
        if node.right and node.right.val in (x,y):
            results.append((node.val, depth))
        # if we have already discovered both x and y values and added to results, then no need to go any further
        if len(results) < 2:
            self.helper(node.left, x, y, results, depth+1)
            self.helper(node.right, x, y, results, depth+1)
        
        return results


"""
APPROACH 2 -
BFS with Queue: 
We will check the children of the node to be inserted, and compare them with x,y. if they are x,y we wont add them to the queue 
Basically when we are adding new elements to the queue, we are ensuring that they are not the children of the same parent or they are 
not on the same level

"""

from collections import deque
# BFS With Queue
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        xFlag, yFlag = False, False
        if not root:
            return False
        q = deque()
        q.append(root)
        
        while q:
            size = len(q)
            for i in range(size):
                node = q.popleft()
                
                if node and node.left and node.right:
                    if node.left.val in (x,y) and node.right.val in (x,y):
                        return False
                if node.val == x:
                    xFlag = True
                if node.val ==y:
                    yFlag= True
                
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            if xFlag and yFlag : return True
            if xFlag or yFlag : return False
        
