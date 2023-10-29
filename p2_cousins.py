# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        """
        Time Complexity: O(n)
        Space Complexity: O(n)
        Did this code successfully run on Leetcode: Yes 

        Any problem you faced while coding this: No
        Your code here along with comments explaining your approach:
        The approach: 
            - BFS without tracking the parent node
            - we will add the nodes to the queue 
            - we check if the child of the node are not equal to x and y or vice-versa
                - if they are then return False
            - else add them to the queue 
            - if we found them then return True
            - if one is found and another is not found then return False            
        """      

        q = [root]
        bool_x = False; bool_y = False
        while (len(q) > 0):
            size = len(q)
            for i in range(0, size):
                node = q.pop(0)
                if node != None:
                    if node.val == x:
                        bool_x = True
                    if node.val == y:
                        bool_y = True
                    if node.left != None and node.right != None:
                        if node.left.val == x and node.right.val == y:
                            return False
                        if node.left.val == y and node.right.val == x:
                            return False
                    if node.left != None:
                        q.append(node.left)
                    if node.right != None:
                        q.append(node.right)
            if bool_x == True and bool_y == True:
                return True
            if bool_x == True or bool_y == True:
                return False
        return False

    # def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
    #     """
    #     Time Complexity: O(n)
    #     Space Complexity: O(n)
    #     Did this code successfully run on Leetcode: Yes 

    #     Any problem you faced while coding this: No
    #     Your code here along with comments explaining your approach:
    #     The approach: 
    #         - BFS by tracking the parent node
    #         - we will add the nodes left and right child to the q queue 
    #         - we will add the node to the parent queue
    #         - if x is found in node.val then turn the flag x to True
    #         - if y is found turn the flag y to True
    #         - at the end of each level
    #             - check if both the node's are found or not
    #                 - if yes, and there parent's are different return True
    #                 - if no, return false
    #     """      
    #     q = [root]
    #     parent = [None]
    #     level = 0
    #     bool_x = False; bool_y = False
    #     par_x  = None; par_y = None
    #     while (len(q) > 0):
    #         size = len(q)
    #         for i in range(0, size):
    #             node = q.pop(0)
    #             p_node = parent.pop(0)
    #             if node != None:
    #                 if node.val == x:
    #                     par_x = p_node
    #                     bool_x = True
    #                 if node.val == y:
    #                     par_y = p_node
    #                     bool_y = True
    #                 if node.left != None:
    #                     parent.append(node)
    #                     q.append(node.left)
    #                 if node.right != None:
    #                     parent.append(node)
    #                     q.append(node.right)
    #         if bool_x == True and bool_y == True:
    #             return par_x != par_y
    #         if bool_x == True or bool_y == True:
    #             return False
    #         level += 1
    #     return False

    # def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        # """
        # Time Complexity: O(n)
        # Space Complexity: O(h)
        # Did this code successfully run on Leetcode: Yes 

        # Any problem you faced while coding this: No
        # Your code here along with comments explaining your approach:
        # The approach: 
        #     - if root is None -> return False
        #     - Take Recursive Stack approach
        #     - if node.val == x or node.val == y then add it to the list
        #     - if list == 2 -> stop the recursion stack 
        #     - once out of the stack 
        #     - check if the level of both the node is same
        #         and check if the parent is different
        #         - return True if conditions are met
        #     - return False if conditions are not met
        # """      

    #     if root == None:
    #         return False
    #     self.areCousins = list()
    #     self.x = x; self.y = y
    #     self.helper(root, 0, self.x, self.y, None)
    #     if (self.areCousins[0][0] != self.areCousins[1][0] and self.areCousins[0][1] == self.areCousins[1][1]):
    #         return True
    #     return False
    
    # def helper(self, node, level, x, y, parent):
    #     if node == None:
    #         return
    #     if node.val == x or node.val == y:
    #         self.areCousins.append([parent, level])
    #     if len(self.areCousins) != 2:
    #         self.helper(node.left, level+1, x, y, node)
    #     if len(self.areCousins) != 2:
    #         self.helper(node.right, level+1, x, y, node)