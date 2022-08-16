#993. Cousins in Binary Tree
"""
Time Complexity : O(n)
Space Complexity : O(n)
"""
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
        result = []
        
        while q :
            size = len(q)
            #print(size)
            hs = set() #if x and y are in hs then they are at saem level
            for i in range(0, size) :
                n = q.popleft()
                
                if n.left != None and n.right != None :
                    if n.left.val in [x, y] and n.right.val in [x, y]:
                        return False
                
                if n.left != None :
                    hs.add(n.left.val)
                    q.append(n.left)
                
                if n.right != None :
                    hs.add(n.right.val)
                    q.append(n.right)       
            
            if x in hs and y in hs:
                return True
                    
        return False
