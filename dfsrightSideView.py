#Time complexity : O(n) i.e. n is the number of nodes in the tree
#Space complexity : O(h) i.e. number of nodes added to the recursive stack
#Did this code successfully run on Leetcode : Yes
#youtube : https://www.youtube.com/watch?v=iICZEF2BN24&ab_channel=%7BS30%7D
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = []
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        #for the null case
        if root == None:
            return self.result
        self.dfs(root, 0)
        return self.result
    #from dfs we left children will be done first and then right children so overwriting the values
    def dfs(self, root: TreeNode, level: int):
        #base condition
        if root == None:
            return 
        #if there is no element in the result at index level then add it
        if level == len(self.result):
            self.result.append(root.val)
        #if there is element in the result at index level then overwrite with the current value
        else:
            self.result[level] = root.val
       #calling left and then right children and incrementing the level 
        self.dfs(root.left, level+1)
        self.dfs(root.right, level+1)
