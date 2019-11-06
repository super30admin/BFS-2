# This solution is not passing on leetcode, tried to debug a lot and found that for example:
# [1,2,3,null,4]
# 2
# when y is not given , it automatically assigning value. No idea how to resolve it. Let me know if there is any fault in my code.
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        # base case
        print(x, y)
        if not root: return False
        queue = []
        queue.append(root)
        while queue:
            size = len(queue)
            # take 2 variable to check if x and y are found or not.
            x_found = False
            y_found = False
            for i in range(size):
                curr = queue.pop(0)
                # check both x and y with curr value.
                if curr.val == x:
                    print("x: ", x)
                    x_found = True
                if curr.val == y:
                    print("y: ", y)
                    y_found = True
                # check both x and y with left and right child of the same parent, if true return False.
                if curr.left and curr.right:
                    if curr.left == x and curr.right == y:
                        print('gfhf')
                        return False
                    if curr.left == y and curr.right == x:
                        return False
                # append left and right child to queue
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            if x_found and y_found:
                print(x_found, y_found)
                return True

        return False