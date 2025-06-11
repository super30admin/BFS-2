"""
Time - O(n)
Space - O(n)
Runs on leetcode - YES
"""
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        q = deque()
        
        q.append(root)
        result = []
        if root == None: return result
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if (i == size - 1): # for left view 0
                    result.append(curr.val)
                if curr.left != None:
                    q.append(curr.left)
                if curr.right != None:
                    q.append(curr.right)

        return result