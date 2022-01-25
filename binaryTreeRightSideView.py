#O(n) time and O(n) space solution using bfs.
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        q = collections.deque([root])
        
        while q:
            rightView = None
            lenQ = len(q)
            for i in range(lenQ):
                node = q.popleft()
                if node:
                    rightView = node
                    q.append(node.left)
                    q.append(node.right)
                    
            if rightView:
                result.append(rightView.val)
        
        return result
        