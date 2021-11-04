# BFS-2

## Problem 1

Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)
#Time Complexity=O(n)
#Space Complexity=O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        q=deque()
        right=[]
        q.append(root)
        while q:
            size=len(q)
            a=0
            for i in range(size):
                e=q.popleft()
                if e.left:
                    q.append(e.left)
                if e.right:
                    q.append(e.right)
                a=e.val

            right.append(a)
        return right  
        
## Problem 2

Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)
#Time Complexity=O(n)
#Space Complexity=O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q=deque()
        q.append(root)
        xf=False
        yf=False
        while q:
            siz=len(q)
            xf=False
            yf=False
            for i in range(siz):
                ele=q.popleft()
                if ele.right and ele.left:
                    if ele.right.val==x and ele.left.val==y:
                        return False
                    if ele.right.val==y and ele.left.val==x:
                        return False
                if ele.val==x:
                    xf=True
                if ele.val==y:
                    yf=True
                if ele.left:
                    q.append(ele.left)
                if ele.right:
                    q.append(ele.right)
                    
                if xf and yf:
                    return True
        return False
                    
                        
                        
                        
                        
                        
                        
                        
                        
                
            
        

