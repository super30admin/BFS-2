# Time Complexity - O(n)
# Space Complecity - O(n)

from collections import deque
class Solution:
    
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root==None:
            return 
        q = deque()
        q.append(root)
        result = []
        while len(q)!=0:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if i==size-1:
                    result.append(curr.val)
                if curr.left!=None:
                    q.append(curr.left)
                if curr.right!=None:
                    q.append(curr.right)
        return result
