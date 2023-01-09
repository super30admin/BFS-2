#time complexity: O(n)
#space complexity: O(n)
#ran on leetcode: Yes
#initialize a queue with root. Get element level by level and insert them into queue. At each iteration get the last element in the queue and append it to the result array. Now pop all elements from queue according to size and add their children. Repeat the process until elements are present in queue. 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        Q=[]
        if(root==None):
            return []
        Q.append(root)
        right_side=[]
        while(Q):
            size=len(Q)
            right_side.append(Q[-1].val)
            while(size>0):
                curr=Q[0]
                del(Q[0])
                if(curr.left):
                    Q.append(curr.left)
                if(curr.right):
                    Q.append(curr.right)
                size-=1
        return right_side
