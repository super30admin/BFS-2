# TC: O(N) since we are iterating over all the nodes 
# SC: O(N) where N is the max size the queue can have

class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        queue = collections.deque()
        queue.append(root)
        
        while queue: 
            x_boolean = False
            y_boolean = False
            for i in range(len(queue)):
                curr = queue.popleft()
                if curr.val == x:
                    x_boolean = True 
                if curr.val == y:
                    y_boolean = True
                if curr.left and curr.right:
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.right.val == x and curr.left.val == y: 
                        return False
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            if x_boolean and y_boolean: 
                return True 
            if x_boolean or y_boolean:
                return False
        return False 
