# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque

class Solution:
	def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
		if root == None:
			return None
		queue = deque()
		queue.append(root) # queue to store the elements visited in the tree in every level
		res = []
		LeftToRight = True
		while len(queue) > 0:
			temp = len(queue) # to store the number of elements at a particular level
			tempList = [] # to store the values of a node present at that level
			for i in range(temp):
				tempNode = queue.popleft()
				tempList.append(tempNode.val)
				if tempNode.left != None:
					queue.append(tempNode.left)
				if tempNode.right != None:
					queue.append(tempNode.right)
			if LeftToRight:
				res.append(tempList) # Append the values of that level to the result
				LeftToRight = False
			else:
				tempList = tempList[::-1]
				res.append(tempList) # Append the values of that level to the result
				LeftToRight = True
		return res