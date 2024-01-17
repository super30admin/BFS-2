class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return root
        q = deque([root])
        res = []
        
        while q:
            for i in range(len(q)):
                node = q.popleft()
                if i == 0:
                    res.append(node.val)
                if node.right:
                    q.append(node.right)
                if node.left:
                    q.append(node.left)
        return res

# Time complexity : O(N)
# Space complexity : O(N)
