# Time: O(n)
# Space: O(n)

# In a queue keep track of the parent of a particular node too
# On each level have track of if x or y is found and change their parent values accordingly
# Add the next elements
# Then at a particular level check if x and y are found if yes then check if their parents are not the same and return accordingly.
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = deque([(root, None)])

        while q:
            size = len(q)
            xFound = False
            yFound = False
            xParent = None
            yParent = None
            for i in range(size):
                curr, parent = q.popleft()
                if curr.val == x:
                    xFound = True
                    xParent = parent
                if curr.val == y:
                    yFound = True
                    yParent = parent
                if curr.left:
                    q.append((curr.left,curr))
                if curr.right:
                    q.append((curr.right,curr))
            if xFound and yFound:
                return xParent != yParent
        return False

# Time: O(n)
# Space: O(n)

# Be on the parent and check if the childrens are equal to x or y if both x and y have same parent return False
# And in a particular level keep track if x is found or y is found if both are found then return True
# As we have checked if parent is same already if x and y are there then they surely don't belong to the same parent.
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = deque([root])

        while q:
            size = len(q)
            xFound = False
            yFound = False
            for i in range(size):
                curr = q.popleft()
                if curr.val == x:
                    xFound = True
                if curr.val == y:
                    yFound = True
                if curr.left and curr.right:
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.left.val == y and curr.right.val == x:
                        return False
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            if xFound and yFound:
                return True
        return False