#Time complexity is O(n)
#Space complexity is O(n)
#Code ran successfully on leetcode
#Faced no issues while coding

#Binary tree view from right side
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#BFS Solution
import collections
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        #Creating an empty array to output the result
        final_result=[]
        #If the root is Null, we return empty lsit
        if(root==None):
            return []
        #Creating a queue to perform BFS operations
        dq=collections.deque()
        #We are appending root to the queue
        dq.append(root)
        while(len(dq)):
            #We will be collecting the size of the queue and we will be iterating through the queue
            size=len(dq)
            for i in range(0,size):
                curr=dq.popleft()
                #If the i is the last value in the loop, we add it to the final_result array
                if(i==size-1):
                    final_result.append(curr.val)
                #If there is element to the left or right of the curr node we add that to the queue
                if(curr.left):
                    dq.append(curr.left)
                if(curr.right):
                    dq.append(curr.right)
        #Finally returning the list
        return final_result

        