"""
FAANMG Problem 61 {Medium

993. Cousins in Binary Tree

Time Complexity : O(N)


Space Complexity : O(H)


Did this code successfully run on Leetcode : Yes

DFS Solution

@name: Rahul Govindkumar_RN27JUL2022
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root:
            return False

        # global variables to store the parent and depth of x and y
        self.x_parent = self.y_parent = TreeNode(0)
        self.x_depth = self.y_depth = 0

        # call dfs with the root and 0 depth
        self.dfs(root, x, y, 0, None)

        # check if the depth is same for both the elements and they do not have same parent
        return self.x_depth == self.y_depth and self.x_parent != self.y_parent

    def dfs(self, root, x, y, depth, parent):
        if not root:
            return 

        # check if root value is x, if so then assign the parent and the depth
        if root.val == x:
            self.x_parent = parent
            self.x_depth = depth
            
        # check if root value is y, if so then assign the parent and the depth
        if root.val == y:
            self.y_parent = parent
            self.y_depth = depth

        # recursively call the dfs on left and right subtree while increasing the depth by 1
        self.dfs(root.left, x, y, depth+1, root)
        self.dfs(root.right, x, y, depth+1, root)



"""
FAANMG Problem 61 {Medium

993. Cousins in Binary Tree

Time Complexity : O(N)


Space Complexity : O(H)


Did this code successfully run on Leetcode : Yes

BFS solution 

@name: Rahul Govindkumar_RN27JUL2022
""" 


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        # if tree is empty is there, then return False
        if not root:
            return False

        # add root to the queue
        q = collections.deque([root])

        # traversing until queue is not empty
        while q:
            # getting the size of the queue as we will go over all the elements of the queue
            size = len(q)
            print(size)

            # initially we define the bool of x and y found as false
            x_found = False
            y_found = False

            # Iterate over all the elements of the queue, pop the element and check if that element is x or y
            for i in range(size):
                curr = q.popleft()

                if curr.val == x:
                    x_found = True
                if curr.val == y:
                    y_found = True

                # check if x and y values are children of current nodes, if they have the same parent, then return False
                if curr.left and curr.right:
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.left.val == y and curr.right.val == x:
                        return False
                    
                    
                # if any children is there, append it to the queue, same for right
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)

            # if at the end, we find both the elements then return True, if either one is found, then return False
            # We are doing this because if even One is treu that meaneas ion the current level there is no cousin
       
            if x_found and y_found:         
                return True
            if x_found or y_found:
                return False
            
        return False