# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#Time Complexity : O(n)
#Space Complexity : O(n)
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        queue = []
        queue.append(root)
        
        while(queue):
            found_x = False
            found_y = False
            count = len(queue)
            for i in range(len(queue)):
                currNode = queue.pop(0)
                if(currNode.left != None and currNode.right != None and ((currNode.left.val == x and currNode.right.val == y) or(currNode.left.val ==y and currNode.right.val == x))):
                    return False
                else:
                    if(currNode.left != None):
                        queue.append(currNode.left)
                    if(currNode.right != None):
                        queue.append(currNode.right)
            for node in queue:
                if(node.val == x):
                    found_x = True
                if(node.val ==y):
                    found_y = True
            if(found_x and found_y):
                return True
        return False
