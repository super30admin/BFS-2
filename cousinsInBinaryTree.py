#Time Complexity : O(n) where n is number of elements in tree
#Space Complexity :  O(n)

#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: Performing BFS we check at every node if the two children of it are the x and y values, if they are then we return False then only as they don't have different parents. We also maintain a visited set for each level, if which we come across x or y element then we put it in the set and if by the end of visiting the entire level, if both x and y elements are in the set then, we can return True.


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        q = deque([root])

        while q:
            visited = set()
            for _ in range(len(q)):
                curr = q.popleft()

                if curr:
                    if curr.left:
                        q.append(curr.left)
                    if curr.right:
                        q.append(curr.right)

                    if curr.left and curr.right:
                        if curr.left.val == x and curr.right.val == y or curr.left.val == y and curr.right.val == x:
                            return False
                    if curr.val == x or curr.val == y:
                        visited.add(curr.val)

            if x in visited and y in visited:
                return True

        return False
