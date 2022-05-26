#BFS Level order approach and checking wether they belong to same level and different parents
#Time Complexity O(N)
#Space Complexity O(N)
#It successfully runs on leetcode
from collections import deque
from lib2to3.pgen2.pgen import DFAState
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q=deque()
        xfound, yfound= False,False
        if not root: return False
        q.append(root)
        while q:
            for _ in range(len(q)):
                cur= q.popleft()
                
                if x== cur.val: xfound = True
                if y== cur.val: yfound=True
                
                if cur.left and cur.right:
                    if cur.left.val == x and cur.right.val==y or cur.right.val == x and cur.left.val==y: 
                        return False
            
                if cur.left: q.append(cur.left)
                if cur.right: q.append(cur.right)
                
            if xfound and yfound:
                return True
            if xfound or yfound: return False
        return True
    
        
#Space O(N) + O(N)            
#Using another queue to track parents
from collections import deque
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q=deque()
        p=deque()
        xfound, yfound= False,False
        xparent, yparent = None, None
        if not root: return False
        q.append(root)
        p.append(None)
        while q:
            for _ in range(len(q)):
                cur= q.popleft()
                parent = p.popleft()
                if cur.left: 
                    q.append(cur.left)
                    p.append(cur)
                if cur.right:
                    q.append(cur.right)
                    p.append(cur)
                if x== cur.val:
                    xfound = True
                    xparent= parent
                if y== cur.val:
                    yfound=True
                    yparent= parent
            if xfound and yfound:
                return xparent.val != yparent.val
            if xfound or yfound: return False
        return True


#Approach: DFS
#DFS Level order approach along with maintaining parent and depth at each level
#Time Complexity O(N)
#Space Complexity O(h)
#It successfully runs on leetcode
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.xparent, self.yparent = None, None
        self.xlevel, self.ylevel = -1,-1
        if not root: return False
        self.dfs(root,0, None,x,y)
        return self.xparent!=self.yparent and self.xlevel==self.ylevel
          
        
    def dfs(self,root,level,parent,x,y):
        if not root: return
        if root.val==x:
            self.xparent= parent
            self.xlevel= level
        if root.val==y:
            self.yparent= parent
            self.ylevel= level
        self.dfs(root.left,level+1,root.val,x,y)
        self.dfs(root.right,level+1,root.val,x,y)