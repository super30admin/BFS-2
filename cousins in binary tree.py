# Time Complexity - O(n)
# Space Complexity - O(n)
def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = deque()
        q.append(root)
        while q:
            size = len(q)
            temp = []
            for i in range(size):
                curr = q.popleft()
                temp.append(curr.val)
                if curr.left!=None and curr.right!=None:
                    if (curr.left.val==x and curr.right.val==y) or (curr.left.val==y and curr.right.val==x):
                        return False
                if curr.left!=None:
                    q.append(curr.left)
                if curr.right!=None:
                    q.append(curr.right)
            if (x in temp and y not in temp) or (y in temp and x not in temp):
                return False
        return True
