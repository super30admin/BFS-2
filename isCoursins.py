'''
time complexity: O(n)
space complexity: O(n)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        xFound = False
        yFound = False
        q = deque([])
        q.append(root)
        while(len(q)!=0):
            n = len(q)
            xFound = False
            yFound = False
            
            for i in range(n):
                curr = q.popleft()
                

                if(curr.val==x):
                    xFound=True
                if(curr.val==y):
                    yFound=True
                if(curr.left!=None and curr.right!=None):
                    if(curr.left.val==x and curr.right.val==y): return False
                    if(curr.left.val==y and curr.right.val==x): return False
                    
                if(curr.left!=None):
                    q.append(curr.left)
                if(curr.right!=None):
                    q.append(curr.right)
            if(xFound and yFound): return True
            if(xFound or yFound): return False
        return False
                