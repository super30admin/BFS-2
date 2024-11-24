"""  
TC:O(N) Number of nodes
SP: O(N)
"""

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return
        q = deque([root])
        res = []
        while q:
            curr_len = len(q)
            for i in range(curr_len):
                r = q.popleft()
                if i == curr_len-1:
                    res.append(r.val)
                if r.left:
                    q.append(r.left)
                if r.right:
                    q.append(r.right)
        return res
