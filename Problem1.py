# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque

class Solution:
	def isCousins1(self, root: TreeNode, x: int, y: int) -> bool:
		# Time Complexity : O(n) where n is the number of nodes in the tree
		# Space Complexity : O(n) where n is the number of nodes in the tree
		NodeParent = dict() # to store the parent of every node in the tree
		NodeDepth = dict() # to store the depth of every node in the tree
		def FindParentDepth(node, par):
			if node:
				NodeDepth[node.val] = 1 + NodeDepth[par.val] if par else 0 # current node depth is depth of parent + 1
				NodeParent[node.val] = par
				FindParentDepth(node.left, node)
				FindParentDepth(node.right, node)
		FindParentDepth(root, None) # Parent of root node is None
		return NodeDepth[x] == NodeDepth[y] and NodeParent[x] != NodeParent[y]

	def isCousins2(self, root, x, y):
		queue = deque()
		queue.append(root)
		while len(queue) > 0:
			q_size = len(queue)
			x_found = False
			y_found = False
			for i in range(q_size):
				node = queue.popleft()
				if node.left != None and node.right != None:
					if (node.left.val == x and node.right.val == y) or (node.right.val == x and node.left.val == y):
						return False
				if node.val == x:
					x_found = True
				elif node.val == y:
					y_found = True
				if node.left != None:
					queue.append(node.left)
				if node.right != None:
					queue.append(node.right)
			if x_found and y_found:
				return True
		return False

	def isCousins3(self, root, x, y):
		queue = deque()
		queue.append(root)
		while len(queue) > 0:
			parentset = set()
			q_size = len(queue)
			for i in range(q_size):
				node = queue.popleft()
				if node.left != None:
					if node.left.val == x:
						parentset.add(node.val)
					elif node.left.val == y:
						parentset.add(node.val)
				if node.right != None:
					if node.right.val == x:
						parentset.add(node.val)
					elif node.right.val == y:
						parentset.add(node.val)
				if node.left != None:
					queue.append(node.left)
				if node.right != None:
					queue.append(node.right)
			if len(parentset) == 2:
				return True
		return False

	def isCousins4(self, root, x, y):
		queue = deque()
		queue.append(root)
		while len(queue) > 0:
			parentset = set()
			q_size = len(queue)
			for i in range(q_size):
				node = queue.popleft()
				if node.left != None and (node.left.val == x or node.left.val == y):
						parentset.add(node.val)
				if node.right != None and (node.right.val == x or node.right.val == y):
						parentset.add(node.val)
				if node.left != None:
					queue.append(node.left)
				if node.right != None:
					queue.append(node.right)
			if len(parentset) == 2:
				return True
		return False