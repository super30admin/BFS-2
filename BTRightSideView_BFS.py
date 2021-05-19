# TC: O(N) since we are processing all the nodes
# SC: O(N) where N is the size of the queue at any instance

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        self.final = []
        
        if not root:
            return self.final
            
        queue = collections.deque()
        queue.append(root)
        while queue:
            size = len(queue)
            for i in range(size):
                curr = queue.popleft()
                if i == size - 1:
                    self.final.append(curr.val)
                
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
        
        return self.final
