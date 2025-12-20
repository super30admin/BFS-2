'''
In this problem we should find the elements which are seen from right side view of the tree.
Right side view has right most elements or last element of the level.
So while iterating on the tree, for every level we store the last element to result array.
To get the last element we maintain a size variable on each level.
'''
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if root is None: return result

        q = deque()
        q.append(root)

        while q:
            size = len(q)
            # iterating on size of each level of the tree
            for i in range(size):
                curr = q.popleft()
                # adding the last element of the level to result to get the right view of the tree
                if i == size - 1:
                    result.append(curr.val)
                
                # ading left and left childs of current nodes to the queue as long as they are not null
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
        return result
'''
Time Complexity: O(n)
We traverse the tree once which takes O(n) time for n nodes
Space Complexity: O(n)
At max space consumed is equal to width of the tree, O(n/2) -> O(n)
'''