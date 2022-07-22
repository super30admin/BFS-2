# Time Complexity: O(n)
# Space complexity: O(n)
# Approach: Use BFS
# use a queue as usual in BFS
# append the last element of the queue in each loop to result



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root== None:
            return None
        from queue import Queue
        q = Queue()
        result = []
        q.put(root)
        while not q.empty():
            size = q.qsize()
            for i in range(0, size):
                node = q.get()
                if node.left:
                    q.put(node.left)
                if node.right:
                    q.put(node.right)
                if i == size -1:
                    result.append(node.val)
        return result
        