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
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        if root:
            vals = [[root.val]]
            queue = [root]
            direc = 0
            while queue:
                temp = []
                for i in range(len(queue)):
                    node = queue.pop(0)
                    if node.left:
                        temp.append(node.left.val)
                        queue.append(node.left)
                    if node.right:
                        temp.append(node.right.val)
                        queue.append(node.right)
                if direc == 1 and len(temp) > 0:
                    vals.append(temp)
                    direc = 0
                elif direc == 0 and len(temp) > 0:
                    vals.append(temp[::-1])
                    direc = 1
            return vals

# Here I am doing the same thing as I was doing in the earlier problems for transversing the tree in BFS manner, except
# for now, I am keeping a flag which will reverse the element in a level alternatively.