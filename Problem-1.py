"""
Approach 1: BFS
At each level, the last element will be appended to the result list
TC: O(n)
SC: O(n)
"""
class Solution:
    """
    def rightSideView(self, root: TreeNode) -> List[int]:
        result = []
        if not root:
            return result

        q = deque()
        q.append(root)

        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if curr.left: q.append(curr.left)
                if curr.right: q.append(curr.right)
                if i == size - 1:
                    result.append(curr.val)
        return result
    """
    # Approach 2: DFS
    """
    keep track of size of the result list and the current level. Do a post order traversal and append all elements that 
    are encountered first at each level
    TC: O(n)
    SC: O(n) including the recursive stack
    """
    def rightSideView(self, root: TreeNode) -> List[int]:
        result = []
        if not root:
            return result
        self.helper(root, 0, result)
        return result

    def helper(self, root, level, result):
        # base
        if not root:
            return

        # logic
        if len(result) == level:
            result.append(root.val)
        self.helper(root.right, leve l +1, result)
        self.helper(root.left, leve l +1, result)