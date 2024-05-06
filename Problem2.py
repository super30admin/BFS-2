## Problem 2

# Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)

# Approach
# Create 2 Queues, 1 for kid and other for parent. While kid queue is not eempty, check if the popped node from kid queue matches either x or y
# If yes, append value of respective parent node to x/y parent variable
# if both x and y are found and they are in the same level, check if parents are different. if yes, return True,else return False


# Time Complexity: O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q_kid = deque([root])
        q_parent = deque([None])
        

        while q_kid:
            size = len(q_kid)
            print(size)
            x_found = False
            y_found = False
            x_parent = None
            y_parent = None
            for i in range(size):
                
                kid = q_kid.popleft()
                parent = q_parent.popleft()
                if kid.val == x:
                    x_found = True
                    x_parent = parent
                if kid.val == y:
                    y_found = True
                    y_parent = parent
                if kid.left:
                    q_kid.append(kid.left)
                    q_parent.append(kid)
                if kid.right:
                    q_kid.append(kid.right)
                    q_parent.append(kid)
                
            # print(x_found,y_found)
            if x_found == True and y_found == True:
                if x_parent != y_parent:
                    return True
                else:
                    return False
            if x_found == True or y_found == True:
                return False
        return False




        