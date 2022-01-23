#  Time Complexity : O(n) where n is the number of nodes.
#  Space Complexity : O(n) where n is the number of nodes.
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : Yes.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        x_found = False
        y_found = False
        queue = deque()
        if root == None:
            return False
        queue.append(root)
        while(len(queue)!=0):
            size = len(queue)
            for i in range(len(queue)):
                node = queue.popleft()
                if node.left!= None and node.right!= None:
                    if node.left.val == x and node.right.val == y or node.left.val == y and node.right.val == x:
                        return False
                if node.val == x:
                    x_found = True
                if node.val == y:
                    y_found = True
                if node.left != None:
                    queue.append(node.left)
                if node.right != None:
                    queue.append(node.right)
            if x_found and y_found:
                return True
            if x_found or y_found:
                return False
