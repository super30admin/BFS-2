#Time complexity: O(n)
#Space complexity: O(n)
#Works on leetcode: yes
#Approach: For two nodes to be cousions, they need to be on same level but have different parent. So keep track of nodes with
#their respective level and parent and use a queue for BFS, starting from root. We pop nodes from the queue and add it
# to the dictionary and add its left and right nodes in the queue. Finally we check for x and y. 
class Solution(object):
	def isCousins(self, root, x, y):
		nodes = collections.defaultdict(list)
		queue = collections.deque([(root,0,0)])
		while queue:
			node,level,parent = queue.popleft()
			nodes[node.val] = [level,parent]

			if node.left:
				queue.append((node.left,level+1,node.val))
			if node.right:
				queue.append((node.right,level+1,node.val))

		if nodes[x][0]==nodes[y][0] and nodes[x][1] != nodes[y][1]:
			return True

		return False