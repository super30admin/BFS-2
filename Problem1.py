# Time Complexity : O(n)
# Space Complexity : O(n/2)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name: Binary Tree Right Side View

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
    # --------recursion-------------
    #     self.result = []
    #     self.dfs(root, 0)
    #     return self.result

    # def dfs(self, root: Optional[TreeNode], level: int):
    #     # base case
    #     if root == None:
    #         return

    #     if len(self.result) == level:
    #         self.result.append(root.val)
    #     else:
    #         self.result[level] = root.val


    #     self.dfs(root.left, level + 1)
    #     self.dfs(root.right, level + 1)


    #-----------BFS------------
        result = []
        if root == None:
            return result
        
        q = [root]

        while q:
            size = len(q)
            for i in range(size):
                curr = q.pop(0)
                if i == size - 1:
                    result.append(curr.val)
                if curr.left != None:
                    q.append(curr.left)
                if curr.right != None:
                    q.append(curr.right)
        
        return result
