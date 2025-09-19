# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    # tc : O(n)
    # sc : O(h)
    def isCousins(self, root, x, y):
        """
        :type root: Optional[TreeNode]
        :type x: int
        :type y: int
        :rtype: bool
        """
        # condition1 : check if the given nodes are the chikd nodes of the same root
        # condition2 : pass the depth variable for each node 
        # check if the depths of the nodes are same 

        # intution : using dfs , passing the parent node and also the depth 
        # once x and y found in the tree, check their depths are same and check parents are not same
        # for parents check i will keep cheking at a praticular node that x, y are not its childer if it is then will have a flag which will be used a checknote


        self.x_found = -1
        self.y_found = -1
        self.parent_flag = True # if have same parent then the flag is false 
    
        self.dfs(root,0,x,y)

        return self.x_found == self.y_found and self.parent_flag 


    def dfs(self, node, depth, x,y):
        if node is None :
            return  

        if node.left is not None and node.right is not None:
            if node.left.val == x and node.right.val == y:
                self.parent_flag = False
            if node.left.val == y and node.right.val == x:
                self.parent_flag = False 

        if node.val == x:
            self.x_found = depth
        
        if node.val == y:
            self.y_found = depth

        if self.parent_flag and (self.x_found == -1 or self.y_found == -1): # recurse until x and y are found
            self.dfs(node.left, depth + 1, x, y)
            self.dfs(node.right, depth + 1, x, y)
            



