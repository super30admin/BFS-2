"""
993. Cousins in Binary Tree
Time Complexity = O(n)
Space Complexity = O(max nodes in same level)
Using a queue append (root,parent) in queue , execute while loop until queue doesnt gets empty,then implementing level wise traversal in tree by pushing elements  same level and verify for each level if value of node matched given input and store parent value after level traversal completes verify if parent_x and parent_y is not -1 and parent_x != parent_y then return True, else if parent_x != -1 and parent_y == -1 or parent_x == -1 and parent_y != -1 return False atlast after completing entire queue if we still do not get output return False
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if root == None:
            return False
        queue = []
        queue.append((root,-1))
        parent_x = -1
        parent_y = -1

        while(queue):
            size = len(queue)
            for i in range(size):
                front = queue.pop(0)
                loop_root = front[0]
                parent = front[1]
                
                if loop_root.val == x:
                    parent_x = parent
                elif loop_root.val == y:
                    parent_y = parent
                    
                if loop_root.left != None:
                    queue.append((loop_root.left,loop_root))
                if loop_root.right != None:
                    queue.append((loop_root.right,loop_root))
                    
            if parent_x != -1 and parent_y != -1 and parent_x != parent_y:
                return True
            elif parent_x != -1 and parent_y == -1 or parent_x == -1 and parent_y != -1:
                return False
            
        return False
                    