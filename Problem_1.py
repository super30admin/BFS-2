# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []

    """
    BFS Implementaiton
    TC - O(n)
    SC - O(h)
    """

    def approach1(self, root):
        result = []
        q = []
        q.append(root)
        while len(q) != 0:
            size = len(q)
            for i in range(size):
                cur = q.pop(0)
                if i == size - 1:
                    result.append(cur.val)
                if cur.left != None:
                    q.append(cur.left)
                if cur.right != None:
                    q.append(cur.right)
        return result

    """
    DFS Implementaiton
    TC - O(n)
    SC - O(h)
    """

    def approach2(self, root, level):
        if root == None:
            return
        if level == len(self.result):
            self.result.append(root.val)
        self.approach2(root.right, level + 1)
        self.approach2(root.left, level + 1)

    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root == None:
            return []
        # return self.approach1(root)
        self.approach2(root, 0)
        return self.result

