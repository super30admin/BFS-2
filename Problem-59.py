# Cousins in a Binary Tree -993
# Time complexity -(N)
# Space complexity -o(N)
# Using queues, First I appended each root,depth and parent into the queue and then stored each root.val details in a hash map.



#using BFS and HAsh map
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        #using queue
        queue=[(root,0,0)]
        d={}
        while queue!=None:
            root,depth,parent=queue.pop()
            d[root.val]=(depth,parent)
            if root.left:
                queue.append((root.left,depth+1,root.val))
            if root.right:
                queue.append((root.right,depth+1,root.val))
            if x in d and y in d:
                break
        if d[x][0]==d[y][0] and d[x][1]!=d[y][1]:
            return True
        return False

#using dfs approach
#time complexity=O(N)
#space complexity =O(H)
# first we will traverse throught left side of the binary tree and if root value matches x or y then we calulate the depth and it's parent value.


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    X_parent=None
    Y_parent=None
    X_depth=-1
    Y_depth=-1
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        self.X_parent=None
        self.Y_parent=None
        self. X_depth=-1
        self. Y_depth=-1
        self.helper(root,x,y,0,None) # root doesn't have any parent
        return (self.X_depth==self.Y_depth) and (self.X_parent!=self.Y_parent)
        
    def helper(self,root,x,y,depth,parent):
        #edge case
        if not root: return 
        #base case
        if root.val==x:
            self.X_depth=depth
            self.X_parent=parent
        if root.val==y:
            self.Y_depth=depth
            self.Y_parent=parent
        self.helper(root.left,x,y,depth+1,root)
        self.helper(root.right,x,y,depth+1,root)
            
        
#level order traversal

# both x and y are at same level and both of them doesn't have same parents. We use queue for BFS, At root only we are check root.left===x and root.right ==False then we are returning False, since they should not have same parent.


from collections import deque
class Solution(object):
    
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        queue=deque()
        #edge case
        if not root: return False
        queue.append(root)
        
        while queue:
            size=len(queue)
            X_found=False
            Y_found=False
            for i in range(size):
                curr=queue.popleft()
                if curr.val==x:X_found=True
                if curr.val==y:Y_found=True
                if curr.left and curr.right:
                    if curr.left.val==x and curr.right.val==y: return False
                    if curr.left.val==y and curr.right.val==x: return False
                if curr.left: queue.append(curr.left)
                if curr.right: queue.append(curr.right)
            if X_found and Y_found: return True
        return False
                
                
                
                
                