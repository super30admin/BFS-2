# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        q = deque()
        result  = []

        q.append(root)

        if root == None:
            return result

        while q:

            length = len(q)

            for i in range(0, length):
                curr = q.popleft()
                if i == length - 1:
                    result.append(curr.val)
                
                if curr.left:
                    q.append(curr.left)
                
                if curr.right:
                    q.append(curr.right)
            
        return result

# Time complexity: O(n), we visist all the nodes once.
# Space complexity: O(n/2) = O(n), the leaf nodes (for a balance binary tree). N is the width of the tree. 
            



