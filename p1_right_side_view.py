# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        """
        Time Complexity: O(n)
        Space Complexity: O(n)
        Did this code successfully run on Leetcode: Yes 

        Any problem you faced while coding this: No
        Your code here along with comments explaining your approach:
        The approach: 
            - we use BFS
            - we travel from right to left on the level
            - if level (initalize it with 0) == length of result
                - we infer that for that level, we haven't added the node
                    - so add the node.val
        """      

        if root == None:
            return []
        q = list()
        res = list()
        q.append(root)
        level = 0
        while(len(q) > 0):
            for i in range(0,len(q)):
                t = q.pop(0)
                if level == len(res):
                    res.append(t.val)
                if t.right != None:
                    q.append(t.right)
                if t.left != None:
                    q.append(t.left)
            level += 1
        return res        

        """
        Time Complexity: O(n)
        Space Complexity: O(h)
        Did this code successfully run on Leetcode: Yes 

        Any problem you faced while coding this: No
        Your code here along with comments explaining your approach:
        The approach: 
            - We use recursion stack
            - we go to right node first and then left node
            - we use pre-order to see if we are visiting the level for the first time
            - if yes then append the node.val to the result which is a global variable
        """      

    # def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
    #     self.result = list()
    #     self.helper(root, 0)
    #     return self.result
    
    # def helper(self, node: Optional[TreeNode], level: int):
    #     # Base
    #     if node == None:
    #         return
    #     # logic 
    #     if len(self.result) == level:
    #         self.result.append(node.val)
    #     self.helper(node.right, level+1)
    #     self.helper(node.left, level+1)