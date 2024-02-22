#
# @lc app=leetcode id=199 lang=python3
#
# [199] Binary Tree Right Side View
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
'''
Time Complexity - O(n). We are traversing all the nodes in any case.
Space Complexity - O(n). In BFS max queue size will be the number of leaf nodes which is n/2 or n.
                   O(h). for DFS as recursive stack will at max contain the same number of nodes as height of tree
'''
from collections import deque
class Solution:

    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        #BFS
        if root == None: #return none if tree is empty
            return result
        nodeQ = deque() #maintain a queue for maintanence
        nodeQ.append(root) #add root to queue
        while nodeQ: #continue until queue is not empty 
            rightMost = nodeQ[-1] #The last element at every level will be the right most element that will be visible from right.
            result.append(rightMost.val) # add the value to the result
            for i in range(len(nodeQ)): #ensure that we distinguish between the levels
                currNode = nodeQ.popleft() #process the queue take every node and add children to queue if present
                if currNode.left != None: 
                    nodeQ.append(currNode.left)
                if currNode.right != None:
                    nodeQ.append(currNode.right)

        #self.dfs(root, 0, result)
        return result 

    def dfs(self, root, level, result):
        if root == None: #(recursion termination)
            return
        if level == len(result): #if check if we are at a level larger than current result size, which means are currently deeper
            result.append(root.val) #append the value of the root if we reach deeper
        self.dfs(root.right, level+1, result) #traverse right
        self.dfs(root.left, level+1, result) #traverse left
# @lc code=end

