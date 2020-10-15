# Time complexity - O(N)
# Space complexity - O(N)

# Ran on Leetcode - Yes


class Solution:
    p = []
    d = []
    def traverse(self, node, parent, depth, target):
        if node is None:
            return

        if node.val in target:
            self.p.append(parent)
            self.d.append(depth)
            return

        self.traverse(node.left, node, depth+1, target)
        self.traverse(node.right, node, depth+1, target)
                  
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        self.p = []
        self.d = []

        self.traverse(root, None, 0, set([x,y]))
        print(self.p)
        print(self.d)

        p = self.p
        d = self.d

        if len(p)==2 and len(d)==2 and p[0] != p[1] and d[0] == d[1]:
            return True
        else:
            return False
    
