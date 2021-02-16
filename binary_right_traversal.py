################## Iterative solution
# Time complexity: O(n)
# Space complexity: O(maximum length of level or diameter)
# Worked on leetcode: yes
# Iterative approach: This algorithm uses a queue. Iteratively, we push the root. If the queue is not empty, we keep popping out elements, and for each pop,
# we push the its children. During each push operation. We maintain the size as the length of the queue, and this size determines the number of elements in a
# level. We add the last element of a partiaular level in the output list.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if root == None:
            return []

        queue = []
        queue.append(root)  # parent of root as -1
        output = []

        while (len(queue) > 0):
            size = len(queue)

            for i in range(size):
                node = queue.pop(0)  # get the element

                if i == size - 1:
                    output.append(node.val)

                if node.left != None: queue.append(node.left)
                if node.right != None: queue.append(node.right)

        return output