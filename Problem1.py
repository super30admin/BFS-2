# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
	def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
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