"""
Approach 1 BFS 
TC - O(n)
SC - O(n)
""" 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        
        result = []
        queue = []
        # add root to the queue
        queue.append(root)
        
        # traverse till the queue is empty
        while queue:
            # get the current queue's size
            size = len(queue)
            
            # for size of queue i.e length of each level
            for i in range(size):
                current = queue.pop(0)
                
                if (i == size - 1):
                    result.append(current.val)
                if current.left:
                    queue.append(current.left)
                if current.right:
                    queue.append(current.right)
                    
                
                    
                    
        return result

    
"""
Approach 2 DFS
TC - O(n)
SC - O(h)
"""
    # Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def __dfs(self, root: TreeNode, level: int):
        # base
        if not root:
            return 
        
        # logic
        if level == len(self.result):
            self.result.append(root.val)
        else:
            self.result[level] = root.val
            
        self.__dfs(root.left, level + 1)
        self.__dfs(root. right, level + 1)
        
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        
        self.result = []
        
        self.__dfs(root, 0)
        return self.result
               
        