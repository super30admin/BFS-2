##Time Complexity - O(n)
#Space Complexity - O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []
        q = deque([root])
        result = [root.val]
        
        while len(q) != 0:
            curr = deque([])
            
            while len(q) != 0:
                node = q.popleft()
                if node.left != None:
                    curr.append(node.left)
                if node.right != None:
                    curr.append(node.right)
            
            if len(curr) != 0:
                result.append(curr[len(curr)-1].val)
            
            q = curr
        
        return result 