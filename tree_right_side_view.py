'''
Same as level order traversal, instead of pushing all the elements of the current level
Push the last element of the current stack.

TC: O(n) --> As we traverse all the nodes of the tree.
SC: O(n)  --> To maintain the queue.

'''
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:

        if root is None:
            return []

        queue = deque()

        queue.append(root)
        res=[]

        while queue:

            k = len(queue)

            stack=[]

            for i in range(k):

                curr_node = queue.popleft()
                stack.append(curr_node.val)

                if curr_node.left:
                    queue.append(curr_node.left)
                if curr_node.right:
                    queue.append(curr_node.right)

            res.append(stack[-1])

        return res
