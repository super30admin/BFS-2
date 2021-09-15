# // Time Complexity :O(n) 
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach




# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
        queue=[]
        queue.append(root)
        while queue:
            size=len(queue)
            flagx=0
            flagy=0
            for i in range(size):
                
                
                val=queue.pop(0)
                if val.val==x:
                    flagx=1
                if val.val==y:
                    flagy=1
                if val.left is not None and val.right is not None:
                    if val.left.val==x and val.right.val==y:
                        return False
                    if val.left.val==y and val.right.val==x:
                        return False
                if val.left:
                    queue.append(val.left)
                if val.right:
                    queue.append(val.right)
            if flagx==1 and flagy==1:
                return True
            if flagx==1 or flagy==1:
                return False