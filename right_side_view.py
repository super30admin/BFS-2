# // Time Complexity : O(n) where n is the num of nodes in the tree 
# // Space Complexity : O(2^h) where h is the height of the tree 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root: return []
        queue = deque()
        queue.append(root)
        res = []
        while queue:
            size = len(queue)
            temp = []
            while size:
                top = queue.popleft()
                if size == 1:
                    temp.append(top.val)
                if top.left: queue.append(top.left)
                if top.right: queue.append(top.right)
                size -= 1
            res.append(temp)
        ans = []
        for each in res:
            ans.append(each[-1])
        return ans
        

    # DFS

    # class Solution:
    #     def __init__(self):
    #     self.res = []
    
    # def rightSideView(self, root: TreeNode) -> List[int]:
    #     if not root: return []
    #     self.dfs(root,0)
    #     return self.res
    
    # def dfs(self,root,level):
    #     if not root: return None
        
    #     if len(self.res) == level:
    #         self.res.append(root.val)
    #     right = self.dfs(root.right,level+1)
    #     left = self.dfs(root.left,level+1)
                