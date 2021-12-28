# pass on Leetcode?: Yes
# Aproach: Iterative BFS
# TC: O(N), SC: O(n/2) -> O(N)
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root == None: return []
        q = deque([root])
        res = []
        
        while len(q) != 0:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if i == size - 1:
                    res.append(curr.val)
                
                if curr.left: q.append(curr.left)
                if curr.right: q.append(curr.right)
        return res