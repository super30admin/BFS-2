class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:


        q = collections.deque()
        q.append(root)

        while len(q)!=0:
            size = len(q)
            x_found = False
            y_found = False
            for _ in range(size):

                cur = q.popleft()
                if cur.val==x:
                    x_found = True
                if cur.val==y:
                    y_found=True

                if cur.left is not None and cur.right is not None:
                    if ((cur.left.val==x and cur.right.val==y) or (cur.left.val==y and cur.right.val==x)):
                        return False

                if cur.left is not None:
                    q.append(cur.left)
                if cur.right is not None:
                    q.append(cur.right)

            if x_found and y_found:
                return True

        return False
