# Author: Naveen US
# Title: Binary Tree Right Side View

# Time complexity: O(n)
# Space complexity: O(n)
# Did the code run on leetcode: Yes

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root: return []
        queue = collections.deque([root])
        ans = []
        while queue:
            q_len = len(queue)
            for i in range(q_len):
                node = queue.popleft()
                if i==q_len-1:
                    ans.append(node.val)
                if node.left: queue.append(node.left)
                if node.right: queue.append(node.right)
        return ans
