
# DFS Approach by recursing on right side
# Time - O(N)
# Space - O(H)

def rightSideView(self, root: TreeNode) -> List[int]:
    
    self.result = []
    
    if root == None:
        return self.result
    
    self.dfs(root, 0)
    return self.result
    
    

def dfs(self, root, level):
    
    # base case
    if root == None:
        return 
    
    # logic
    if level == len(self.result):
        self.result.append(root.val)
        
    self.dfs(root.right, level + 1)
    
    self.dfs(root.left, level + 1)




# DFS Approach by recursing on left side to get right view of tree, we need to update the level at result with current val
# Time - O(N)
# Space - O(H)

def rightSideView(self, root: TreeNode) -> List[int]:
    
    self.result = []
    
    if root == None:
        return self.result
    
    self.dfs(root, 0)
    return self.result
    
    

def dfs(self, root, level):
    
    # base case
    if root == None:
        return 
    
    # logic
    if level == len(self.result):
        self.result.append(root.val)
    
    else:
        # in the case of updating when we take left view to get right view, we update the level with values accordingly
        self.result[level] = root.val
        
    self.dfs(root.left, level + 1)
    
    self.dfs(root.right, level + 1)
    
        
        
        
        
# BFS Solution
# Time - O(N)
# Space - O(N)

def rightSideView(self, root: TreeNode) -> List[int]:

        
    result = []
    if root == None:
        return result
    
    queue = []
    queue.append(root)
    
    while queue != []:
        
        size = len(queue)
        for i in range(size):
            current = queue.pop(0)
            if i == size - 1:
                result.append(current.val)
                
            if current.left != None:
                queue.append(current.left)
                
            if current.right != None:
                queue.append(current.right)
                
    return result
        
        
    