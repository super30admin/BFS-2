#Time Complexity:O(n)
#Space Complexity:O(1)

#DFS approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    x_parent=y_parent=None                                                      #Nodes tohold parent details
    x_depth=y_depth=0                                                           # check if the levels 
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        self.dfs(root,None,0,x,y)                                               #call recursive dfs function
        return self.x_parent!=self.y_parent and self.x_depth==self.y_depth      #check if parents are not same and levels are same and return booleand value
    
    def dfs(self,root:TreeNode,parent:TreeNode,depth:int,x:int,y:int)->None:
        if not root:                                                            #if root is null return
            return                                                              
        if root.val==x:                                                         #if x is encountered in tree, update its parent and level
            self.x_parent=parent
            self.x_depth=depth
        if root.val==y:                                                         #if y is encountered in tree update its parent and level
            self.y_parent=parent
            self.y_depth=depth
        self.dfs(root.left,root,depth+1,x,y)                                    #call dfs on left subtree
        self.dfs(root.right,root,depth+1,x,y)                                   #call dfs on right subtree

#BFS approach
#Time Complexity:O(n)
#Space Complexity:O(n)
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        d=deque()                                                   #declare a queue
        d.append(root)                                              #append the root into the queue
        xfound=yfound=False                                         #declare two boolean variable to check if x and y are found
        while d:                                                    #until the queue is empty
            l=len(d)                                                #find the length of queue
            for r in range(l):                                      #for every element in the queue at this point only
                curr=d.popleft()                                    #pop the leftmost node
                if curr.val==x:                                     #if the current element value is same as x or y set their boolean variable to true
                    xfound=True
                if curr.val==y:
                    yfound=True
                if curr.left and curr.right:                        
                    if (curr.left.val==x and curr.right.val==y):   # if the x and y values are found to  be under same parent return false
                        return False
                    if (curr.left.val==y and curr.right.val==x):
                        return False
                if curr.left:                                       #append the left node to queue if it exists
                    d.append(curr.left)
                if curr.right:                                      #append the right node to queu if it exists
                    d.append(curr.right)
            if xfound and yfound:                                   #if at this level both are found return true
                return True
            if xfound or yfound:                                    #if at this level if only one of the elements are found return false
                return False
        return False