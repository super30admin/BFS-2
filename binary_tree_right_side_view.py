#BFS
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
from collections import deque, TreeNode, Optional, List
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        q = deque()
        q.append(root)

        if not root:
            return result

        while q:
            size = len(q)

            for i in range(size):
                curr = q.popleft()

                if i == size-1:
                    result.append(curr.val)

                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)

        return result

#DFS
# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if not root:
            return result
        
        def helper(root, level):
            if not root:
                return 
            
            if len(result) == level:
                result.append(root.val)
            else:
                result[level] = root.val
            
            helper(root.left, level+1)
            helper(root.right, level+1)
        
        helper(root, 0)
        return result