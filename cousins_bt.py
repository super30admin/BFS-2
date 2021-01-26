# Time Complexity:O(n) (where n = number of nodes)
# Space Complexity:O(n) (where n = number of nodes)
# Did this code successfully run on LeetCode?:Yes
# Problems faced while coding this:None
# Approach: cousins: if they have the same depth, but have different parents.
#           BFS - keep track of depth and parents of the nodes 

class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        
        result = []
        if root is None:
            return False
        
        queue = []
        queue.append(root)
        
        x_found = False
        y_found = False
        
        while queue is not []:
            size = len(queue)
            
            for i in range(size):
                
                curr = queue.pop(0)
                
                if curr.val == x:
                    x_found = True
                    
                if curr.val == y:
                    y_found = True
                    
                if curr.left is not None and curr.right is not None:
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    
                    if curr.left.val == y and curr.right.val == x:
                        return False
                    
                if curr.left is not None:
                    queue.append(curr.left)
                    
                if curr.right is not None:
                    queue.append(curr.right)
                    
            if x_found and y_found:
                return True
            
            if x_found or y_found:
                return False