#Solution for left side view in a Binary Tree

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        if not root:
            return  
        q = deque()
        q.append(root)
        
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if (i == 0):
                    res.append(curr.val)
                    
                if curr.left is not None:
                    q.append(curr.left)
                
                if curr.right is not None:
                    q.append(curr.right)
        return res
