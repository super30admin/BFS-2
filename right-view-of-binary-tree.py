# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def rightSideView(self, root):
        """
        # :type root: TreeNode
        # :rtype: List[int]
        # """

        # # Approach 1: BFS

        # queue = [] # SC: O(n)

        # result = []
        # if root is None:
        #     return result
        # queue.append(root)

        # while len(queue) != 0: # TC: O(n)
        #     size = len(queue) # calculate size for every level.
        #     for i in range(size):
        #         node = queue.pop(0)
        #         # print(node)
        #         if i == size-1: # i.e. when i equal to last element in the queue for a given level then append to result
        #             # for left view, do i == 0 that is first element in the queue for a given level
        #             result.append(node.val)
        #         if node.left != None:
        #             queue.append(node.left)
        #         if node.right != None:
        #             queue.append(node.right)

        #         # print(result)
        # return result

        # Approach 2: DFS TC: O(n), SC: O(height of recursive stack)

    # Put right side values first into the result i.e .traverse right child first
    def helper(root, level):
        # base
        if root == None:
            return

        # append with right side values first
        if len(result) == level:
            result.append(root.val)

        helper(root.right, level + 1)
        helper(root.left, level + 1)

    result = []
    if root == None:
        return result

    helper(root, 0)
    return result

    # This also can be done if you want to traverse left first
    # Put left side values in the tree first as we are traversing left child first. But then replace those values with right child values

    # def helper(root, level):
    #     # base
    #     if root == None:
    #         return

    #     # append with left side values first
    #     if len(result) == level:
    #         result.append(root.val)

    #     # if value already exists for a level, overwrite it because we had first put all left side values.
    #     if result[level] != None:
    #         result[level] = root.val

    #     helper (root.left, level + 1)
    #     helper(root.right, level + 1)

    # result = []
    # if root == None:
    #     return result

    # helper(root, 0)
    # return result
