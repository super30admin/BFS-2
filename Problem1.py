#Time complexity: O(n)
#Space complexity: O(h) for DFS, O(n) for BFS

#Accepted on leetcode

#Approach

#BFS (BFS Traverse and append last node at each level to result)

#DFS 
#Perform preorder Root L R traversal and at each level if level == size of result, append val to result else overwrise result[level] with current val
#This way we will always have the rightmost visible val for a given level, written in the result array at the end

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = []
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.result  = []
        self.dfs(root, 0)
        return self.result

    def dfs(self, root, level):
        if root == None:
            return

        if level == len(self.result):
            self.result.append(root.val)
        else:
            self.result[level] = root.val
        self.dfs(root.left, level + 1)
        self.dfs(root.right, level + 1)



        