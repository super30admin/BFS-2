# Time Complexity: O(N)
# Space Complexity: O(N)
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        queue=deque()
        right=[]
        queue.append(root)
        while queue:
            a=0
            for i in range(len(queue)):
                popped=queue.popleft()
                if popped.left:
                    queue.append(popped.left)
                if popped.right:
                    queue.append(popped.right)
                a=popped.val
            right.append(a)
        return right