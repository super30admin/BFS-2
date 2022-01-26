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
# For each node coming out of queue i have checked if the childs of the node are x and y.
# If it is true return False right away. As both x and y will have same parent.
# At the end of each level if we find only one out of x and y that means x and y are not at same level. Hence, we return True.
# At the end of each level if we find both x and y that means x and y are at same level and not child of same parent. 
# Hence, we return True.


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    # Optimized BFS
    # TC: O(N)
    # SC: O(N) --> number of leaf nodes in queue
    
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
        import queue
        q = queue.Queue()
        q.put(root)
        
        while (not q.empty()):
            
            size = q.qsize()
            x_found = False
            y_found = False
            
            for i in range(size):

                currNode = q.get()
                if (currNode.val == x): x_found = True
                if (currNode.val == y): y_found = True

                if (currNode.left != None and currNode.right != None):
                    if (currNode.left.val == x and currNode.right.val == y): return False
                    if (currNode.left.val == y and currNode.right.val == x): return False
                    
                if (currNode.left != None):
                    q.put(currNode.left)
                    
                if(currNode.right != None):
                    q.put(currNode.right)
                    
            if (x_found and y_found): return True
            if (x_found or y_found): return False