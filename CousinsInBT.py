//BFS Approach


//Time Complexity: O(n)
//Space Complexity:O(h)
// Did the code run successfully on leet code: Yes


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        q = deque([root])
        
        while q:
            
            levVal = []
            qlen = len(q)
            x_found = None
            y_found = None
            for i in range(qlen):
                currnode = q.popleft()
                if(currnode.val == x):
                             x_found = True
                if(currnode.val == y):
                             y_found = True
                if(currnode.left != None and currnode.right !=None):
                    if(currnode.left.val == x and currnode.right.val == y): 
                        return False
                    if(currnode.left.val == y and currnode.right.val == x) :
                        return False
            
                if currnode.left:
                    q.append(currnode.left)
                    
                if currnode.right:
                    q.append(currnode.right)
                if(currnode.val == x):
                             x_found = True
                if(currnode.val == y):
                             y_found = True
            if x_found == True and y_found == True:
                     return True
        return False                   

//DFS Approach


//Time Complexity: O(n)
//Space Complexity: O(n)
// Did the code run successfully on leet code: Yes
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    
    x_depth = None
    y_depth = None
    x_parent = None
    y_parent = None
    
    x = None
    y =None
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        self.x = x
        self.y = y
        self.x_depth = None
        self. y_depth = None
        self.x_parent = None
        self.y_parent = None
        self.helper(root.left,root,1)
        self.helper(root.right,root,1)
        if(self.x_depth == self.y_depth and self.x_parent != self.y_parent):
            return True
        else:
            return False
    def helper(self,root,parent,level):
        
        if not root:
            return True
        if(root.val == self.x):
            self.x_depth = level
            self.x_parent = parent
        if(root.val == self.y):
            self.y_depth = level
            self.y_parent = parent
        self.helper(root.left,root,level+1)
        self.helper(root.right,root,level+1)
