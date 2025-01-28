# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        # BFS approach
        # TC : O(n)
        # SC : O(n)
        if root is None:
            return False
        x_found,y_found = False,False
        q = deque()
        q.append(root)
        while q:
            cursize = len(q)
            
            while cursize > 0:
                curNode = q.popleft()
                cursize -= 1
                if curNode.left != None and curNode.right != None:
                    if (curNode.left.val == x and curNode.right.val == y) or (curNode.left.val == y and curNode.right.val == x):
                        return False
                if curNode.val == x:
                    x_found = True
                if curNode.val == y:
                    y_found = True
                if curNode.left !=None:
                    q.append(curNode.left)
                if curNode.right != None:
                    q.append(curNode.right
                    )
            if x_found == True and y_found == True:
                return True
            if x_found ==True or y_found:
                return False
        return (x_found and y_found)