from collections import deque

class Solution:
    def isCousins(self, root, x, y):
        if not root or x == y:
            return False
        queue = deque()
        queue.append(root)

        while queue:
            x_found = False
            y_found = False
            for _ in range(len(queue)):
                node = queue.popleft()
                if node.val == x:
                    x_found = True
                if node.val == y:
                    y_found = True
                
                if node.left and node.right:
                    if node.left.val == x and node.right.val == y:
                        return False
                    elif node.left.val == y and node.right.val == x:
                        return False
                
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
                
            if x_found == True and y_found == True:
                return True
            elif x_found or y_found:
                return False

if __name__ == "__main__":
    s = Solution()
    root = [1,2,3,4]
    x = 3
    y = 4
    s.isCousins(root, x, y)