from queue import Queue
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    """
    TC: O(total number of nodes in the tree) = O(n)
    SC: O(max. breadth of the tree)
    """

    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:

        if root == None:
            return None

        output = []
        queue = Queue()
        queue.put(root)

        while not queue.empty():
            size = queue.qsize()

            for i in range(size):
                front = queue.get()

                if i == size - 1:
                    output.append(front.val)

                if front.left != None:
                    queue.put(front.left)

                if front.right != None:
                    queue.put(front.right)

        return output
