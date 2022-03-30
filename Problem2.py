# Time Complexity:O(n)
# Space Complexity:O(h)
# Did it run on Leetcode: YES
# Did you have any problems: No
class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        queue = [root]
        while queue:
            siblings = False
            cousins = False  
            for i in range(len(queue)):
                node = queue.pop(0)  

                if node is None:
                    siblings = False
                else:
                    if node.val == x or node.val == y:
                        if not cousins:
                            siblings, cousins = True, True
                        else:
                            return not siblings

                    queue.append(node.left) if node.left else None
                    queue.append(node.right) if node.right else None
                    queue.append(None)
                    
            if cousins:
                return False

        return False