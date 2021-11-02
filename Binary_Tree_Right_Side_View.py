class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []
        self.final = [root.val]
        temp = []
        temp.append(root)
        while len(temp) != 0:
            new_temp = []
            for head in temp:
                if head.left is not None:
                    new_temp.append(head.left)
                if head.right is not None:
                    new_temp.append(head.right)
            if len(new_temp) == 0:
                break
            else:
                # print(new_temp[-1].val)
                self.final.append(new_temp[-1].val)
                temp = new_temp
            
        return self.final