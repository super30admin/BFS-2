# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
'''
Solution 1: DFS
Traverse right and then left. 
    - level as parameter of recursion
        - purpose: to check with size of the answer list. If they are equal, then
                   we are visiting the rightmost node at this level
Time : O(N)
Space : O(H), H=height of tree
'''
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        rightSideView_nodes = []
        self.helper(root,0,rightSideView_nodes)
        return rightSideView_nodes
    
    def helper(self,node,level,rightSideView_nodes):
        # base
        if node==None:
            return

        # logic
        if len(rightSideView_nodes)==level: # No Node at this level yet. Must be the rightmost view
            rightSideView_nodes.append(node.val)
        
        # WE first traverse right and then left
        self.helper(node.right,level+1,rightSideView_nodes)
        self.helper(node.left,level+1,rightSideView_nodes)

'''
Solution 2: BFS
Maintain the level by size parameter of the queue. Once at each parent level,
child nodes are added, just take the first element of the queue. 
While adding nodes, add right and then left child
Time : O(N)
Space : O(N/2), Leaf nodes
'''
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        rightSideView_nodes = []
        
        if root ==None:
            return rightSideView_nodes
        
        bfs_queue = deque()
        bfs_queue.append(root)

        while (len(bfs_queue)!=0):
            level_size = len(bfs_queue)
            for i in range(level_size):
                curr_node = bfs_queue.popleft()
                if i==0:
                    rightSideView_nodes.append(curr_node.val)
                if curr_node.right!=None:
                    bfs_queue.append(curr_node.right)
                if curr_node.left!=None:
                    bfs_queue.append(curr_node.left)

        return rightSideView_nodes