"""
Input: root = [1,2,3,4], x = 4, y = 3
Output: false
TC:O(n)
Sc:O(n)
Approach: We will traverse level by level and every parent we encounter we will check if their child are not x and y
and every child we encounter we will check if they don;t belong to the same parent, we will approach this way to find
the two values and update a flag if found, flag is the output of the program
Ran on leetcode: yes
Time-O(n)
Space-O(n)
:return

"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


from collections import deque
class Solution:
    def isCousins(self, root, x: int, y: int) -> bool:
        q = deque()
        q.append(root)
        while q:
            size = len(q)
            x_found = False
            y_found = False
            for i in range(size):
                currentValue = q.popleft()
                if currentValue.val == x:
                    x_found = True
                elif currentValue.val == y:
                    y_found = True
                if currentValue.left and currentValue.right:
                    ##here we will check the condition of
                    if (currentValue.left.val == x and currentValue.right.val == y) or (
                            currentValue.left.val == y and currentValue.right.val == x):
                        return False
                        ##x and y are siblings and have the same parent currentValue
                # print(currentValue.val)
                if currentValue.left != None:
                    q.append(currentValue.left)
                if currentValue.right != None:
                    q.append(currentValue.right)

            ##after level traversal we just check if x_found and y_found are True or not
            if x_found and y_found:
                return True

#                     if flag==0 and (currentValue==x or currentValue==y):
#                         flag=1
#                         siblings[currentValue]=True
#                         cousins[currentValue]






