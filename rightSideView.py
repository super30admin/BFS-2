# TC: O(n)
# SC: O(n)
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        q=deque([])
        q.append(root)
        result=[]

        while q:
            size=len(q)
            for i in range(size):
                curr=q.popleft()
                if i==size-1:
                    result.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            
        
        return result