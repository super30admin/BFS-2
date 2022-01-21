class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root == None: return []
        q = []
        q.append(root)
        result = []
        while q:
            size = len(q)
            for i in range(0, size):
                curr = q.pop(0)
                if i == size - 1:
                    result.append(curr.val)
                if curr.left != None:
                    q.append(curr.left)
                if curr.right != None:
                    q.append(curr.right)
        return result
    

    # T.C=> O(N) = since we traverse through every node
    # S.C=> O(N) = using stack
    # Approach => Add the every element in a queue by following breadth size.
    # Take the size of the queue everytime and just add all the last element in the stack from the queue.