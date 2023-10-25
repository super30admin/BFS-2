# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# creating a queue of treeNode objects
# define a rightSide node to pick up elements level by level
# then run a for loop in each level , pop the left element in the queue
# add the children babies to the queue
# append the level result to res
# time complexity 0(n) because you visit all the nodes 
# space complexity 0(n) because queue to store nodes 


class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        q = collections.deque([root])

        while q:
            rightSide = None
            qLen = len(q)

            for i in range(qLen):
                node = q.popleft()
                if node :
                    rightSide = node
                    q.append(node.left)
                    q.append(node.right)

            if rightSide :
                res.append(rightSide.val)
        
        return res