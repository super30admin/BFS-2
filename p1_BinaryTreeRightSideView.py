#199. Binary Tree Right Side View


# // Time Complexity : O(n)
# // Space Complexity : O(W) # width of binary tree
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root == None: return []
        res = []
        q =[root] # queue space O(n)
        while q:
            for _ in range(len(q)):
                root = q.pop(0)
                val = root.val
                if root.left:
                    q.append(root.left)
                if root.right:
                    q.append(root.right)
            res.append(val) # last val of for loop = right most value of curr level
        return res