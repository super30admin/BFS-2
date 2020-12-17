/*
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        
        self.result = []
        
        self.dfs(root, 0)
        
        return self.result
    
    def dfs(self, root, level):
        if root is None:
            return
        
        if len(self.result) == level:
            self.result.append(root.val)
            
        self.dfs(root.right, level+1)
        self.dfs(root.left, level+1)



class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        
        self.result = []
        
        self.dfs(root, 0)
        
        return self.result

    def dfs(self, root, level):
        if root is None:
            return
        
        if len(self.result) == level:
            self.result.append(root.val)
        
        else:
            self.result[level] = root.val
        self.dfs(root.left, level+1)  
        self.dfs(root.right, level+1)




class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        
        queue = collections.deque()
        queue.append(root)
        result = []
        while len(queue) > 0:
            size = len(queue)
            last = None
            
            for i in range(size):
                frontelement = queue.popleft()
                last = frontelement.val
                
                if frontelement.left is not None:
                    queue.append(frontelement.left)
                    
                if frontelement.right is not None:
                    queue.append(frontelement.right)
            
            result.append(last)
        
        return result
*/
/*
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int level){
        if (root == null)
            return;
        
        if (result.size() == level)
            result.add(root.val);
        
        dfs(root.right, level+1);
        dfs(root.left, level+1);
            
            
    }
}


class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int level){
        if (root == null)
            return;
        
        if (result.size() == level)
            result.add(root.val);
        else
            result.set(level, root.val);
        
        dfs(root.left, level+1);
        dfs(root.right, level+1);
         
    }
}

*/

// Time Complexity : O(N) where N is no of nodes in tree
// Space Complexity : O(h) where h is height of tree. WOrst case it would be equal to N
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Started from root I travelled level wise and always added last of 
// that level to the result
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        int last = 0;
        q.add(root);
        
        while (!q.isEmpty()){
            int size = q.size();
            
            for (int i=0; i<size; i++){
                TreeNode node = q.poll();
                last = node.val;
                
                if (node.left != null)
                    q.add(node.left);
                
                if (node.right != null)
                    q.add(node.right);
            }
            
            result.add(last);
        }
        return result;
    }
}