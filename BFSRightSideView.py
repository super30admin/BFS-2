#Time Complexity O(n)
#Space Complexity O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def helper(self, root, depth):
        #left side
        if not root:
            return  
        
        if len(self.result) == depth:
            self.result.append(None)
         
        self.result[depth] = root.val
            
        
        self.helper(root.left, depth+1)
        self.helper(root.right, depth+1)

        
        #Right side
        if not root:
            return  
        
        if len(self.result) == depth:
            self.result.append(root.val)          
        
        self.helper(root.right, depth+1)
        self.helper(root.left, depth+1)
    
    
    def rightSideView(self, root: TreeNode) -> List[int]:
        
        
        self.result = []
        output = []
        
        self.helper(root, 0)
        
        return self.result
        
############################################################

#         result = []
        
#         stack = []
        
#         output = []
        
#         depth = 0
        
#         while root or stack:
#             while root:
#                 if len(result) == depth:
#                     result.append([])
#                 result[depth].append(root.val)
#                 depth = depth + 1
#                 stack.append((root, depth))
#                 root = root.left
                
#             root, depth = stack.pop()
#             root = root.right
            
#         print(result)
        
#         for level in result:
            
#             output.append(level[-1])
            
#         return output
        
        
#         result = []
#         queue = collections.deque()
        
#         queue.append(root)
        
        
#         while queue:
            
#             size = len(queue)
#             temp = []
            
#             for i in range(size):
                
#                 node = queue.popleft()
#                 temp.append(node.val)

#                 if node.left:
#                     queue.append(node.left)
#                 if node.right:
#                     queue.append(node.right)
                
#             result.append(temp)
            
            
#         print(result)
        
        
