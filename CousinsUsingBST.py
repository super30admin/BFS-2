#Time complexity: O(n)
#Space complexity:O(n)

#Use parent and child queue. When children are equal, compare its parent. Since we are doing this every level
#using size, we don't require height
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q=collections.deque()
        pq=collections.deque()
        q.append(root)
        pq.append(None)
        x_parent=None
        y_parent=None
        x_val=False
        y_val=False
        while q:
            size=len(q)
            temp=0
            parent=None
            print(size)
            for i in range(0,size):
                temp=q.popleft()
                parent=pq.popleft()
                if temp.val==x:
                    x_parent=parent
                    x_val=True
                elif temp.val==y:
                    y_parent=parent
                    y_val=True
                if temp.left:
                    q.append(temp.left)
                    pq.append(temp)
                if temp.right:
                    q.append(temp.right)
                    pq.append(temp)
            if x_val and y_val and x_parent!=y_parent:
                return True
            elif (x_val) or (y_val):
                return False
        return False
