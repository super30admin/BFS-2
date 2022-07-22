# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity => O(N)
# Space Complexity => O(H) Height of the tree
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if(root is None):
            return []
        queue1 = []
        height = 0
        def traverse(root,height):
            if(root is None):
                return
            if(height == len(queue1)):
                queue1.append(root.val)
            traverse(root.right, height+1)
            traverse(root.left, height+1)
        traverse(root,height)
        return queue1
            
        