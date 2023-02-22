# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# All TC passed on leetocde


class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        #BFS approach
        #Time complexity - O(n)
        #Space complexity - O(n)
        queue = collections.deque()
        queue.append(root)
        xfound = False
        yfound = False
        while queue:
            for i in range(len(queue)):
                cur = queue.popleft()
                if cur.val==x:
                    xfound = True
                if cur.val==y:
                    yfound = True

                if cur.left and cur.right:
                    if cur.left.val==x and cur.right.val==y:
                        return False
                    if cur.left.val==y and cur.right.val==x:
                        return False
                if cur.left:
                    queue.append(cur.left)

                if cur.right:
                    queue.append(cur.right)
            
            if xfound and yfound:
                return True
            if xfound or yfound:
                return False
        
#-----------------------------------------OR----------------------------------------

        #DFS approach
        #Time complexity - O(n)
        #Space complexity - O(h)

        self.xParent = None
        self.yParent = None
        self.xlevel = -1
        self.ylevel = -1

        def helper(root, parent, level):
            if not root:
                return
            if root.val == x:
                self.xParent = parent
                self.xlevel = level

            if root.val == y:
                self.yParent = parent
                self.ylevel = level
            
            helper(root.left, root, level+1)
            helper(root.right, root, level+1)


        helper(root, None, 0)
        if self.xParent!=self.yParent and self.xlevel==self.ylevel:
            return True
        return False