# Time Complexity: O(n)
# Space Complexity: O(n)
# Approach: use BFS
# create a queue, set xfound and yfound as false initially
# in a loop of size of queue:
# check if the node's value is equal to x or y and set found values accordingly
# check for children of the node, if both node exists and the children are equal to the target values, return false
# in the same loop, if both xfound and yfound are True, return True
# if only one of them is true after exiting inside loop, return false.





# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        from queue import Queue
        q = Queue()
        q.put(root)
        while not q.empty():
            size = q.qsize()
            xfound = False
            yfound = False
            for i in range(0,size):
                node = q.get()
                if node.val == x:
                    xfound = True
                if node.val == y:
                    yfound = True
                if node.left != None and node.right != None:
                    if node.left.val == x and node.right.val == y:
                        return False
                    if node.left.val == y and node.right.val == x:
                        return False
                if node.left != None:
                    q.put(node.left)
                if node.right != None:
                    q.put(node.right)
            if xfound == True and yfound == True:
                return True
            if xfound == True or yfound == True:
                return False
        return False
        
            
            
                    
        