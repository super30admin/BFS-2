# Time Complexity :
# TC: O(N)

# Space Complexity :
# SC: O(N) --> N is number of root nodes (N/2)

# Did this code successfully run on Leetcode :
# Yes

# Any problem you faced while coding this :
# No

# Your code here along with comments explaining your approach
# Here i have used BFS approach using queue.
# I have maintained a size variable to keep track of level.
# I have appeneded the last element of each level in the result array.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    # BFS
    # TC: O(N)
    # SC: O(N) --> N is number of root nodes (N/2)
    
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        result = []
        
        if (root == None):
            return result
        
        import queue
        q = queue.Queue()
        q.put(root)
        
        while (not q.empty()):
            
            size = q.qsize()
            
            for i in range(size):
                
                currRoot = q.get()
                
                if (currRoot.left != None):
                    q.put(currRoot.left)
                    
                if (currRoot.right != None):
                    q.put(currRoot.right)
                    
                if (i == size-1):
                    result.append(currRoot.val)
        
        return result