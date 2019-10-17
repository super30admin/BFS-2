# Time Complexity : O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if root is not None:

            queue = [root]
            parent = {root.val: None}
            while queue:
                l = len(queue)
                temp = []
                for i in range(l):
                    node = queue.pop(0)
                    if node.left:
                        queue.append(node.left)
                        parent[node.left.val] = node.val
                        temp.append(node.left.val)
                    if node.right:
                        queue.append(node.right)
                        parent[node.right.val] = node.val
                        temp.append(node.right.val)
                if x in temp and y in temp and parent[x] != parent[y]:
                    return True
                    break

            return False

# Here I am maintaining a queue to iterate over the tree in BFS manner. I have also maintained  a dictionery for the parent
# of the nodes. Then after a single level is iterated then I am checking if X an Y are prent and the parents of both the
# nodes are different. If it is the case then I will return True.