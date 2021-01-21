# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        
        # BFS Solution
        '''
        Time Complexity: O(n)
        Space Complexity: O(n)
        '''
        def bfs(root,x,y):
            q = deque([root])

            while(len(q)>0):
                size = len(q)

                j=0
                c = 0
                while(j<size):
                    i  = q.popleft()
                    # check for sibiling
                    if(i.left!=None and i.right!=None):
                        if(i.left.val==x or i.left.val==y) and (i.right.val==x or i.right.val==y):
                            # siblings
                            return False
                    if(i.val==x or i.val==y):
                        c+=1
                    if(i.left!=None):
                        q.append(i.left)
                    if(i.right!=None):
                        q.append(i.right)
                    j+=1


                if(c==2):
                    return True
                if(c==1):
                    return False
        
        
        '''
        Time Complexity: O(n)
        Space Complexity: O(n)
        ''' 
        # DFS solution
        x_parent = None
        y_parent = None
        x_height = None
        y_height = None
        def dfs(root, height, parent):
            nonlocal x_parent, y_parent, x_height, y_height
            if(root==None):
                return
            if(root.val==x):
                x_parent = parent
                x_height = height
            if(root.val==y):
                y_parent = parent
                y_height = height
            dfs(root.left, height+1, root)
            dfs(root.right, height+1, root)

        
        dfs(root, 1, None)
        if(x_parent==y_parent):
            return False
        if(x_height!=y_height):
            return False

        return True
        
        #return bfs(root,x,y)
