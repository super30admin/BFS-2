#Time Complexity:O(n)
#Space COmplexity:O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        result=[]                                       #output array declared
        if not root:                                    #if tree is empty return empty output
            return result
        d=deque()                                       #declaring the queue
        d.append(root)                                  #append the root into the queue
        while(d):                                       #while the queue is not empty
            l=len(d)                                    #obtain the length of the queue
            result.append(d[-1].val)                    #append the rightmost node into the output array
            for r in range(l):                          #for nodes in each level
                curr=d.popleft()                        #obtain nodes one by one
                if curr.left:                           #append the right and left child nodes if the exist into the queue
                    d.append(curr.left)
                if curr.right:
                    d.append(curr.right)
        return result                                   #return the result.
            