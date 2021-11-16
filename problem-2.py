#Time Complexity :O(n)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : yes
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = [root]
        size = 0
        
        while q:
            size = len(q)
            xflag = False
            yflag = False
            
            for i in range(size):
                node = q.pop(0)
                
                if node.left and node.right:
                    if node.left.val == x and node.right.val == y:
                        return False
                    if node.left.val == y and node.right.val == x:
                        return False

                if node.val == x:
                    xflag = True

                if node.val == y:
                    yflag = True
            
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            
            if xflag and yflag:
                return True
        
        return False