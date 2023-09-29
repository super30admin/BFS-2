# Time Complexity: O(n) where n is the number of nodes
# Space Complexity:  O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root == None:
            return False
        q = deque()
        q.append(root)
        while(len(q) > 0):
            x_found = False
            y_found = False
            size = len(q)
            for _ in range(size):
                node = q.popleft()
                if node.val == x:
                    x_found = True
                if node.val == y:
                    y_found = True
                
                if node.left != None and node.right != None :
                    if (node.left.val == x and node.right.val == y ) or (node.left.val == y and node.right.val == x ):
                        return False
                if node.left != None:
                    q.append(node.left)
                if node.right != None:
                    q.append(node.right)
            if x_found and y_found:
                return True
            if x_found  or y_found:
                return False
                
        return False
################################################


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.x_parent = None
        self.y_parent = None
        self.x_height = 0
        self.y_height = 0
        def findheightandparent(root,level,x,y):
            if root == None:
                return
            if self.x_parent == None and (( root.left != None and root.left.val == x) or (root.right != None and root.right.val == x)):
                self.x_parent = root
                self.x_height = level
                return
            if self.y_parent == None and (( root.left != None and root.left.val == y) or (root.right != None and root.right.val == y)):
                self.y_parent = root
                self.y_height = level
                return
            findheightandparent(root.left,level + 1, x,y)
            findheightandparent(root.right,level + 1, x,y)
        
        findheightandparent(root,0,x,y)
        if self.x_parent != None and self.y_parent != None and self.x_parent != self.y_parent and self.x_height == self.y_height:
            return True
        return False
