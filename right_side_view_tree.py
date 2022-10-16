#time complexity:o(n), going th all the elements in bfs way
#space complexity:o(1),no extra space
#passed all cases on LeetCode:yes
#difficulty faced:
# comments:in the code
#https://leetcode.com/problems/binary-tree-right-side-view/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: 'Optional[TreeNode]') -> 'List[int]':
        l1 = []

        #always check this or later on it will give index out of range err for que
        if root == None: return None 

        q = []
        q.append(root)

        while q:
            size1 = len(q)
            #print(q)
            #this for loop runs from 0 to size calculated bec size changes
            for i in range(0,size1):
                #for fifo q we need to pop 1st element, remem that treenode to operate on it later
                curr = q.pop(0)
                if i == size1-1:
                    #print(curr.val)
                    l1.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
        
        return l1 




