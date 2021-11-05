# Leetcode 993: Cousins in a Binary Tree
# Time -> O(n)
# Space -> O(n)

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
        q = [root]
        
        while(len(q) != 0):
            
            size = len(q)
            
            found_x = False
            found_y = False
            
            for i in range(size):
                
                element = q.pop(0)
                
                if element.val == x:
                    
                    found_x = True
                    
                if element.val == y:
                    
                    found_y = True
                
                if element.left != None and element.right != None:
                    
                    if element.left.val == x and element.right.val == y:
                        return False
                    
                    if element.left.val == y and element.right.val == x:
                        return False
                
                # new level starts
                if element.left != None:
                    q.append(element.left)
                    
                if element.right != None:
                    q.append(element.right)
            
            if found_x and found_y:
                
                return True
        
        return False