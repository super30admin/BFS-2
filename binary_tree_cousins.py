################## Iterative solution
# Time complexity: O(n)
# Space complexity: O(maximum length of level or diameter)
# Worked on leetcode: yes
# Iterative approach: This algorithm uses a queue. Iteratively, we push the root, and its parent value in the queue. For eaach root we pop,
# we push the its children with an appended parent value as well. During each push operation, we keep on checking if they are x and y. When we find them,
# we update the values of their parents. Lastly, we compare their parents.

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
        queue.append([root, -1])  # parent of root as -1

        while (len(queue) > 0):
            size = len(queue)
            parent_x = -1
            parent_y = -1

            for i in range(size):
                front = queue.pop(0)  # get the element
                node = front[0]
                front_val = node.val
                parent = front[1]

                if front_val == x:
                    parent_x = parent
                elif front_val == y:
                    parent_y = parent

                if node.right != None: queue.append([node.right, node.val])
                if node.left != None: queue.append([node.left, node.val])

            if parent_x != -1 and parent_y != -1 and parent_x != parent_y:
                return True

        return False