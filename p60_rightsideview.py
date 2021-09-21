
"""
Here we will use DFS to traverse the tree from the root node we will traverse level 1 and
we will update the value of the result every time we pop an element from the queue to become its root and traverse its left and right children. However we will update this value only when we have traversed the whole level so that the last value getting updated in the current value would be the rightmost which is we want, right value at every level.
Time- O(n)
Space-O(n)
"""

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        queu e =collections.deque()
        if not root or len(root )= =0:
            return []
        queue.append(root)
        resul t =[]
        while queue:
            siz e =len(queue)
            for i in range(size):
                curren t =queue.popleft()
                valu e =current.val
                if current.lef t! =None:
                    queue.append(current.left)
                if current.righ t! =None:
                    queue.append(current.right)
            result.append(current)


