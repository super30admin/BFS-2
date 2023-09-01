# Problem 1

# Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)
# // Time Complexity : O(v+e) --> all the edges
# // Space Complexity : O(v+e)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
from collections import deque


class TreeNode:
    def __init__(self, val=None, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def rightSideView(self, root):
        # creating a rightSideView result list
        rightSideView = []
        # returning empty if no root
        if not root:
            return rightSideView
        # creating a queue with root as first element
        q = deque([root, ])
        # iterating till elements present in q
        while q:
            # getting level length
            size = len(q)
            for i in range(size):
                # popping the left most element
                node = q.popleft()
                # the right most element
                if i == size - 1:
                    # append it to result list
                    rightSideView.append(node.val)
                # add left child to q
                if node.left:
                    q.append(node.left)
                # add right child to q
                if node.right:
                    q.append(node.right)
        return rightSideView


sol = Solution()
root_list = [1, 2, 3, None, 5, None, 4]
# Construct the tree first
root_nodes = [None] * len(root_list)
for i, val in enumerate(root_list):
    if val is not None:
        root_nodes[i] = TreeNode(val)

for i, node in enumerate(root_nodes):
    if node:
        left_child_idx = 2 * i + 1
        right_child_idx = 2 * i + 2
        if left_child_idx < len(root_list) and root_list[left_child_idx] is not None:
            node.left = root_nodes[left_child_idx]
        if right_child_idx < len(root_list) and root_list[right_child_idx] is not None:
            node.right = root_nodes[right_child_idx]

# Call rightSideView on the root of the constructed tree
print(sol.rightSideView(root_nodes[0]))
