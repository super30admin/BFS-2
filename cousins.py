# Time Complexity: O(N)
# Space Complexity: O(N)
def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        queue = deque([(root, None)])
        while queue:
            child, Parent = None, None
            for i in range(len(queue)):
                node, curr_p = queue.popleft()
                if child and (node.val == x or node.val == y) and Parent != curr_p:
                    return True
                if node.val == x or node.val == y:
                    child, Parent = True, curr_p
                if node.left:
                    queue.append((node.left, node))
                if node.right:
                    queue.append((node.right, node))
                              
		    if child:
                return False
        return False