// Time Complexity: O(n)
// Space Complexity: O(max width of binary tree)
// Passed all test cases on Leetcode: Yes

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
        if(root==None):
            return(False)
            
        q=[]
        q.append((root,-1))
        
        while(q):
            size= len(q)
            parent_x=-1
            parent_y=-1
            
            for i in range(size):
                popped=q.pop(0)
                node=popped[0]
                parent=popped[1]
                
                if(node.left):
                    q.append((node.left,node.val))
                
                if(node.right):
                    q.append((node.right,node.val))
                
                if(node.val == x):
                    parent_x = parent
                if(node.val ==y):
                    parent_y= parent
                
            if(parent_x!=-1 and parent_y!=-1 and parent_x!=parent_y):
                return(True)
                
            elif((parent_x==-1 and parent_y!=-1) or (parent_x!=-1 and parent_y==-1)):
                return(False)
        
        return(False)
                
        