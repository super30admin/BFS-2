class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        x_flag = False
        y_flag = False
        
        queue = collections.deque()
        
        if root == None:
            return False
        
        queue.append([root, None, 0])
        result = []
        
        while queue:
            
            node, parent, level = queue.popleft()
            
            # base condition
            
            if len(result) == 2:
                break
                
            if node.val == x or node.val == y:
                result.append((parent, level))
                
            if node.left:
                queue.append((node.left, node, level + 1))
            if node.right:
                queue.append((node.right, node, level + 1))
                
                
        node_x, node_y = result
        
        return node_x[0] != node_y[0] and node_x[1] == node_y[1]
            
            
    # BFS Approach

    # TIME COMPLEXITY: O(N) for visiting all the noes
    # SPACE COMPLEXITY: O(D) where D is the diameter of the tree. It will be N/2 in case of complete binary tree
            
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        def dfs(root, parent, level):
            nonlocal x_level
            nonlocal x_parent
            nonlocal y_level
            nonlocal y_parent
            
            if root != None:
                if root.val == x:
                    x_level = level
                    x_parent = parent
                if root.val == y:
                    y_level = level
                    y_parent = parent
                    
                dfs(root.left, root, level + 1)
                dfs(root.right, root, level + 1)
        
        x_level = 0
        y_level = 0
        x_parent = TreeNode(-1)
        y_parent = TreeNode(-1)
        dfs(root, TreeNode(-1), 0)
        
        if x_level == y_level and x_parent != y_parent:
            return True
        else:
            return False
        
        # TIME COMPLEXITY: O(N) where n is the total number of nodes 
        # SPACE COMPLEXITY: O(H) where H is the height of the tree. O(n) in worst case