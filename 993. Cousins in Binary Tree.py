#Time Complexity:O(n)
#Space Complexity:O(n)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def checkChild(self,root,x,y,level):
        if root.val==x:
            self.node1=True
            self.pos1=level
        if root.val==y:
            self.node2=True
            self.pos2=level 
        return

    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        if not root:
            return False
        if x==root or y==root:
            return False
        dq=collections.deque()
        self.node1=False
        self.node2=False
        self.pos1=None
        self.pos2=None
        level=0
        dq.append(root)
        while dq:
            level+=1
            size=len(dq)
            for i in range(size):
                parent=dq.popleft()
                if parent.left:
                    self.checkChild(parent.left,x,y,level)
                    dq.append(parent.left)
                if parent.right:
                    self.checkChild(parent.right,x,y,level)
                    dq.append(parent.right)
                if parent.right and parent.left:    
                    if (parent.right.val==x and parent.left.val==y) or (parent.right.val==y and parent.left.val==x):
                        return False
            if self.node1!=self.node2 or self.pos1!=self.pos2:
                return False     
        return True
                
                    
                
