"""
Problem:
https://leetcode.com/problems/cousins-in-binary-tree/

Approach: BFS Solution

1. Maintain a queue
2. push the root node to the queue. 
3. while popping the nodes from each level the que, check if x and y are the children of popped element, if yes, return False
4. if x and y do not have same parent, and they belong to the same level, then return True

"""

# Time Complexity : O(n) where n is the no of nodes in the tree
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


from collections import deque
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if root==None:
            return False
        
        que = deque()
        que.append(root)
        
        while(que):
            size = len(que)
            xFound,yFound = False, False
            for i in range(size):
                cur = que.popleft()
                if (cur.left != None and cur.right!=None):
                    if((cur.left.val == x and cur.right.val == y) or\
                       (cur.left.val == y and cur.right.val == x)):
                        
                        return False
                if (cur.left!=None):
                       que.append(cur.left)
                if (cur.right!=None):
                       que.append(cur.right)
                if(cur.val==x):
                       xFound=True
                if(cur.val==y):
                       yFound=True
            if (xFound==True and yFound==True):
                       return True
        return False


"""
Problem:
https://leetcode.com/problems/binary-tree-level-order-traversal/

Approach: DFS Solution

1. For each node in the tree, store the level information as well as the parent information in teh recursive stack
2. Maintain gloabl variables xLevel, yLeve, xParent, yParent
3. Traverse the tree in pre-order fashin and set xLevel,xParent if x is found , yLevel and yParent if y is found

"""

# Time Complexity : O(n) where n is the no of nodes in the tree
# Space Complexity : O(H) where H is the  height of the tree
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No

class Solution:
    xLevel,yLevel,xParent,yParent= None,None,None,None
    
    def dfs(self,root,level,parent,x,y):
        if root==None:
            return 
        
        if(root.val==x):
            self.xLevel = level
            self.xParent = parent
        if(root.val==y):
            self.yLevel= level
            self.yParent = parent
        
        self.dfs(root.left,level+1,root,x,y)
        self.dfs(root.right,level+1,root,x,y)
    
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if root==None:
            return False
        xLevel,yLevel,xFound,yFound = 0,0,False,False
        
        self.dfs(root,0,None,x,y)
        
        return ((self.xParent!=self.yParent) and (self.xLevel==self.yLevel))