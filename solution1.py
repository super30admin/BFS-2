# time: O(n)
# space: O(n)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def rightSideView(self, root):
        # bfs and append last node of each list to result
        # bfs:
            # maintain a Q and its size
            # for size(each level)- visit the element and put its children inq
        if root is None:
            return
        result = []
        q = [root]
        while q:
            size = len(q)
            for i in range(size):
                li = []
                element = q.pop(0)
                if element.left:
                    q.append(element.left)
                if element.right:
                    q.append(element.right)
                li.append(element.val)
            result.append(li[-1])
        return result

        