#TC-o(n)
#SC-o(h)
#DFS
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        self.x_parent=None
        self.y_parent=None
        self.x_depth=0
        self.y_depth=0
        self.dfs(root,x,y,0,None)
        return ((self.x_parent!=self.y_parent) and (self.x_depth==self.y_depth))
        
        
    def dfs(self,root,x,y,depth,parent):
        #base
        if(root==None):
            return False

        
        #logic
        if(root.val==x):
            self.x_parent=parent
            self.x_depth=depth
        if(root.val==y):
            self.y_parent=parent
            self.y_depth=depth
        self.dfs(root.left,x,y,depth+1,root)
        self.dfs(root.right,x,y,depth+1,root)
        
////BFS
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if(root==None):
            return False
        q=[]
        q.append(root)

        while q:
            x=False
            y=False
            size=len(q)
            for i in range(size):
                node=q.pop()
                if(node.val==x):
                    x=True
                if(node.val==y):
                    y=True
                if((node.left!=None) and (node.right!=None)):
                    if((node.left.val==x) and (node.right.val==y)):
                        return False
                    if((node.right.val==x) and (node.left.val==y)):
                        return False
                if((node.left!=None)):
                    q.append(node.left)   
                if((node.right!=None)):
                    q.append(node.right)
            if((x) and (y)):
                return True
        return False
