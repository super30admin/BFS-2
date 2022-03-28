// Time Complexity : O(V+E) ~ BFS traversal visiting all the edges; 
// Space Complexity : O(n) ~
// 1. Storing the last sublist row, Any point the last row of tree will have Max of O(n/2) +1 nodes.
// Did this code successfully run on Leetcode : Yes; (https://leetcode.com/submissions/detail/668936171/)
// Any problem you faced while coding this : No;
// My Notes : Traverse using level order, then check childs found, then parents in the previous row if present.

class Solution { 
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode parent1 = null;
        TreeNode parent2 = null;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                
                if(node.left!=null){
                    // If any value matches the left node
                    if(node.left.val == x || node.left.val == y){
                        //System.out.println(" Checking node.left.val  : "+ node.left.val +", x,y"+x+","+y);
                        if(parent1 == null){parent1 = node;}else if(parent2 == null){parent2 = node;}
                        
                    }
                    queue.add(node.left);
                }
                
                if(node.right!=null){
                    // If any value matches the right node
                    if(node.right.val == x || node.right.val == y){
                        //System.out.println(" Checking node.right.val : "+ node.right.val+", x,y"+x+","+y);
                        if(parent1 == null){parent1 = node;}else if(parent2 == null){parent2 = node;}
                    }
                    queue.add(node.right);
                }
                subList.add(node.val);
            }
            result.add(subList);
            // If both values are found then break the loop
            if(parent1!=null && parent2!=null){
                //System.out.println("Parents are set :: " + parent1.val +", "+parent2.val +" size : "+result.size());
                break;
            }
        }
        //System.out.println("Result : "+result);
        List<Integer> lastRow = (result.get(result.size()-1));
        // If parent are not same and present in the previous row then return true.
        if(lastRow !=null && parent1!=null && parent2!=null){
            // Both same parents then they are not cousins
            if(parent1 == parent2){return false;}
            if(lastRow.contains(parent1.val) && lastRow.contains(parent2.val)){
                return true;
            }
        }
        return false;
    }
}