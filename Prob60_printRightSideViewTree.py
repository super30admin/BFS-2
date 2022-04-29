#Time Complexity :o(n)
# Space Complexity :o(h)
# Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no , Here I used DFS approach.

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
            queue = []
            next_nodes = []
            output = []
            if root != None:
                output = [root.val]
                queue = [root]
                while queue:
                    out = queue.pop(0)
                    if out.left:
                        next_nodes.append(out.left)
                    if out.right:
                        next_nodes.append(out.right)
                    if queue == []:
                        if next_nodes != []:
                            output.append(next_nodes[-1].val)
                        queue, next_nodes = next_nodes, queue
                return output
            else:
                return []