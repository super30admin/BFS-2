from queue import Queue
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    """
    TC: O(total number of nodes)
    SC: O(max breadth of the tree)
    """

    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root == None:
            return False

        queue = Queue()

        # (node, parent) [-1 means no parent]
        queue.put((root, -1))

        while not queue.empty():
            size = queue.qsize()
            parent_x = -1
            parent_y = -1

            for i in range(size):
                front = queue.get()

                # check for both x and y values
                if front[0].val == x:
                    parent_x = front[1]

                if front[0].val == y:
                    parent_y = front[1]

                if front[0].left != None:
                    queue.put((front[0].left, front[0].val))

                if front[0].right != None:
                    queue.put((front[0].right, front[0].val))

            # if both parents are not -1 and not equal
            if parent_x != -1 and parent_y != -1 and parent_x != parent_y:
                return True
            # if either one of the parents is -1 and the other has a diff. value
            elif parent_x != -1 and parent_y == -1 or parent_x == -1 and parent_y != -1:
                return False
        # nodes are not present in the tree
        return False
