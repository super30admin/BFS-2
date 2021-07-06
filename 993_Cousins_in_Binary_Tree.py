from collections import deque
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        
        q = deque([(None, -1, root)])
        found_x, found_y = False, False
        x_level, y_level = -1, -1
        x_parent, y_parent = None, None
        while q and (not found_x or not found_y):
            parent, depth, node = q.popleft()
            if node.val == x:
                x_level = depth
                x_parent = parent
                found_x = True
            if node.val == y:
                y_level = depth
                y_parent = parent
                found_y = True
            
            if node.left:
                q.append((node, depth+1, node.left))
            
            if node.right:
                q.append((node, depth+1, node.right))
        
        if x_level == -1 or  y_level==-1 or x_level != y_level or not x_parent or not y_parent or x_parent.val == y_parent.val:
            return False
        return True