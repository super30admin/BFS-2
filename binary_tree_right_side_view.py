# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    '''
    Time Complexity: O(n)
    Space Complexity: O(h) where h is the height of the tree
    '''
    def rightSideView(self, root: TreeNode) -> List[int]:
        # you can complete a DFS search
        
        if root is None: return []
        
        right = []
        
        def traversal(node, level: int):
            if level == len(right):
                right.append(node.val)
            
            for c in [node.right, node.left]:
                if c: traversal(c, level + 1)
        
        traversal(root, 0)
        return right