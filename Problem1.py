'''
DFS
1. We are moving to the right side of the tree, so we will be traversing the right side first.
2. At any instance answer array will have length equal to the level of the node we are at.
3. If the level is equal to the length of the ans array, then we will append the value of the node to the ans array.
4. If there was only a left child, then right's call would have returned None, so we will append the left child's value to the ans array. 

TC: O(N)
SC: O(H) where H is the height of the tree

BFS
1. We will be using a queue to traverse the tree level by level.
2. We will be adding the right child first and then the left child to the queue.
3. At any instance, the last element in the queue will be the rightmost element of that level.

TC: O(N)
SC: O(N) N is diameter of the tree
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#DFS
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return None
        self.ans = []
        self.dfs(root,0)
        return self.ans

    def dfs(self,root: TreeNode, level: int):
        if root == None:
            return 
        if level == len(self.ans) :
            self.ans.append(root.val)
        self.dfs(root.right,level+1)
        self.dfs(root.left, level+1)

#BFS
from queue import Queue
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return None
        ans = []
        q = Queue()
        q.put(root)
        while not q.empty():
            size = q.qsize()
            for i in range(size):
                curr = q.get()
                if i==size-1:
                    ans.append(curr.val)
                if curr.left:
                    q.put(curr.left)
                if curr.right:
                    q.put(curr.right)
        return ans