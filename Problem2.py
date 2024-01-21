'''

Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach
Using BFS, I traverse thru the list level-wise and use two queues. One to track elements added level wise and the other queue
to store the corresponding parent element.

I use a conditional statement to check if both nodes are on the same level and don't have same parents
'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = collections.deque()
        par = collections.deque()
        q.append(root)
        par.append(root.val)

        level = -1
        pos = [-1,-2,-3,-4]
        # [level1,parent1,level2,parent2]

        while q:
            level += 1

            for i in range(len(q)):
                node = q.popleft()
                parent = par.popleft()

                if node:
                    if node.val == x:
                        pos[0] = level
                        pos[1] = parent

                    if node.val == y:
                        pos[2] = level
                        pos[3] = parent

                    q.append(node.left)
                    par.append(node.val)
                    q.append(node.right)
                    par.append(node.val)

            if level > 1 and pos[0] == pos[2] and pos[1] != pos[3]:
                return True

        return False

