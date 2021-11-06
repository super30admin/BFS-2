# 993. Cousins in Binary Tree
# https://leetcode.com/problems/cousins-in-binary-tree/

# Time Complexiety: O(n)
# Space Complexiety: O(1)

# Logic: We do level order traversal. 
# For each level we see if the target elements exist or not. 
# For the same parent we check the child node values with targets. 
# If they match we return false.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = [root]
        size = 0
        
        while q:
            size = len(q)
            xflag = False
            yflag = False
            
            for i in range(size):
                node = q.pop(0)
                
                if node.left and node.right:
                    if node.left.val == x and node.right.val == y:
                        return False
                    if node.left.val == y and node.right.val == x:
                        return False

                if node.val == x:
                    xflag = True

                if node.val == y:
                    yflag = True
            
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            
            if xflag and yflag:
                return True
        
        return False
            