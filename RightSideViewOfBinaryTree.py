class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        queue = collections.deque()
        result = []
        
        if root == None:
            return []
        queue.append(root)
        
        while queue:
            size = len(queue)
            
            for i in range(size):
                root = queue.popleft()
                if i == size - 1:
                    result.append(root.val)
                if root.left:
                    queue.append(root.left)
                if root.right:
                    queue.append(root.right)
                    
        return result
    
    # BFS Approach
    
    # TIME COMPLEXITY: O(N) for visiting all nodes in 
    # SPACE COMPLEXITY: O(D) where D is the diameter of the Tree. if the tree is complete binary tree then diameter will be N/2
            

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        def dfs(root, level):
            nonlocal result
            
            if root != None:
                if level == len(result):
                    result.append(root.val)
                dfs(root.right, level + 1)
                dfs(root.left, level + 1)
                
        result = []
        dfs(root, 0)
        return result
    
    # TIME COMPLEXITY: O(n) where n is the total number of nodes
    # SPACE COMPEXITY: O(H) where H is the height of the tree
    