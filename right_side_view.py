# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity: O(n)
# Space Complexity: O(h)
from collections import deque


class Solution(object):
    result_arr = []

    def BFSFind(self, root):
        #         Initializing the output list
        result = []
        #     base case
        if not root:
            return result
        #         initialize two queue one for current level and another for next level
        currq = deque()
        nextq = deque()
        #
        #       next level queue , we will append root
        nextq.append(root)
        # result.append(root.val)
        #         we will iterate till next level is null and assign current level to next level and next to null
        # and till curren queue is not empty we will pop the element and and check if left and right child is present if so then add it to next level queue

        while nextq:
            currq = nextq
            nextq = deque()
            curr_root = root
            while currq:
                curr_root = currq.popleft()

                if curr_root.left:
                    nextq.append(curr_root.left)

                if curr_root.right:
                    nextq.append(curr_root.right)
            #           append to the output list
            result.append(curr_root.val)
        return result

    def DfsFind(self, root, level):
        #     Base condition
        if not root:
            return
        #     Logic
        #       if length of result array and current level is same then add to the result array
        # if not then as we are traversing left side first current level is already filled so we will update it with right side
        if len(self.result_arr) == level:
            self.result_arr.append(root.val)
        else:
            self.result_arr[level] = root.val

        #         we will call same function on left and then on right
        self.DfsFind(root.left, level + 1)

        self.DfsFind(root.right, level + 1)

    def DfsFindMain(self, root):
        self.result_arr = []
        #         checking if root is present or not
        if not root:
            return self.result_arr
        #         calling dfs solution with root and currentlevel as 0
        self.DfsFind(root, 0)
        return self.result_arr

    def rightSideView(self, root):

        # return self.BFSFind(root)
        return self.DfsFindMain(root)

        """
        :type root: TreeNode
        :rtype: List[int]
        """
