'''
    Time Complexity:
        O(n) (where n = number of nodes in the Tree)

    Space Complexity:
        O(n) (where n = number of nodes in the Tree)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        BFS approach
        Keep track of the number of nodes at each level.
        Save the last node of each level in the output list.
'''
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        res = []
        if not root:
            return res

        q = collections.deque()
        q.append(root)

        while q:
            nodes = len(q)
            i = 0

            while i < nodes:
                node = q.popleft()
                i += 1

                if node.left:
                    q.append(node.left)

                if node.right:
                    q.append(node.right)

                if i == nodes:
                    res.append(node.val)

        return res
