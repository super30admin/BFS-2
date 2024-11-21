# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
        q = deque()
        q.append(root)
        
        while q:
            l = len(q)
            xfound, yfound = False, False
            while l > 0:
                cur = q.popleft()

                if cur.val == x: xfound = True
                if cur.val == y: yfound = True
                
                if cur.left and cur.right:
                    if cur.left.val == x and cur.right.val == y:
                        return False
            
                    if cur.left.val == y and cur.right.val == x:
                        return False

                if cur.left: q.append(cur.left)
                if cur.right:q.append(cur.right)
                l -= 1

                
            if xfound and yfound:
                return True
            if xfound or yfound:
                return False
            
        return False

