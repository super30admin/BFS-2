"""
 FAANMG Problem 61 {Medium

199. Binary Tree Right Side View

Time Complexity : O(N)


Space Complexity : O(H)


Did this code successfully run on Leetcode : Yes
  

@name: Rahul Govindkumar_RN27JUL2022
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    
    def dfs(self, root, depth):
        if not root:
            return
        
        
        # if depth is equal to the size of the result, then we append a new element to the Result , which is the root.val
        if depth == len(self.result):
            self.result.append(root.val)
        else:
            self.result[depth] = root.val
        
        # recursively call the root.right first and its right view and then left subtree
        self.dfs(root.left, depth + 1)
        self.dfs(root.right, depth + 1)
        

        return self.result
    
    
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        
        self.result = []
        
        if not root:
            return self.result
        
        
        self.dfs(root,0)
        
        
        return self.result
    
    
"""
 FAANMG Problem 61 {Medium

199. Binary Tree Right Side View

Time Complexity : O(N)


Space Complexity : O(H)


Did this code successfully run on Leetcode : Yes
  


@name: Rahul Govindkumar_RN27JUL2022
"""

    
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        
        
            
        #BFS Sol
        
        # Empty list for the result
        result = []
        
        if( root is None):
            return result
        
        q = collections.deque()
        
        
        # add the root to the queue
        q.append(root)
        
        # Traverse until the queue is not empty
        while q:
            # Maintain the size of the queue
            size = len(q)
            
            
              # for each element in the queue, we pop that element from queue and check if the element of that depth is already present, if present, then add that value to the res
            for i in range (size):
                
                curr = q.popleft()
                
                #Add the last most element
                if(i == size-1):
                    result.append(curr.val)
                 
                # Adding the left and right child of the root node
                if (curr.left is not None):
                    q.append(curr.left)
                    
                if (curr.right is not None):
                    q.append(curr.right)
                    
        return result
                    
        

