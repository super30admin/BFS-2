/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     List<List<Integer>> ll;
     public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result= new ArrayList<>(); 
        ll = new ArrayList<>();
        dfs(root,0);
        for(int i=0; i<ll.size();i++){
            int j=ll.get(i).size()-1;
            result.add(ll.get(i).get(j));
        }
        return result;
    }
    private void dfs(TreeNode root, int level){
 
        if(root==null) return;
        if(ll.size()== level){
            ll.add(new ArrayList<>());
        }
        ll.get(level).add(root.val);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}

// class solution 
class Solution {
     List<Integer> ll;
     public List<Integer> rightSideView(TreeNode root) { 
        ll = new ArrayList<>();
        dfs(root,0);
        return ll;
    }
    private void dfs(TreeNode root, int level){
 
        if(root==null) return;
        if(ll.size()== level){
            ll.add(root.val);
        }
        dfs(root.right,level+1);
        dfs(root.left,level+1);
    }
}
// OR

class Solution {
     List<Integer> ll;
     public List<Integer> rightSideView(TreeNode root) { 
        ll = new ArrayList<>();
        dfs(root,0);
        return ll;
    }
    private void dfs(TreeNode root, int level){
 
        if(root==null) return;
        if(ll.size()== level){
            ll.add(root.val);
        }
       else{
           ll.set(level,root.val)
;       }
        dfs(root.left,level+1);
         dfs(root.right,level+1);
    }
}

// BFS approach 

class Solution {
     public List<Integer> rightSideView(TreeNode root) { 
    List<Integer> ll = new ArrayList();
        if(root== null) return ll;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size= q.size();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                if(i== size-1) ll.add(curr.val);
                if(curr.left!= null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                
            }
        }
            return ll;
    }
}

//time complexity- O(n)
//Space complexity- O(n)