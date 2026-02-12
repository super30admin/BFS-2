# Time Complexity :O(N)
# Space Complexity :O(N) 
# Did this code successfully run on Leetcode :yes 
# Any problem you faced while coding this :no 

# Your code here along with comments explaining your approach
# We perform a level-order traversal (BFS) to process nodes depth by depth.
# At each level, we check whether both x and y are present and ensure they are not siblings (same parent).
# If both are found at the same level and are not siblings, they are cousins; otherwise, they are not.

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        queue = deque([(root, None)]) 
        
        while queue:
            size = len(queue)
            x_parent = None
            y_parent = None
            
            for _ in range(size):
                node, parent = queue.popleft()
                
                if node.val == x:
                    x_parent = parent
                if node.val == y:
                    y_parent = parent
                
                if node.left:
                    queue.append((node.left, node))
                if node.right:
                    queue.append((node.right, node))

            if x_parent or y_parent:
                    return (
                        x_parent is not None and
                        y_parent is not None and
                        x_parent != y_parent
                    )
        return False
