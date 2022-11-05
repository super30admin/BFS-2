//TC: O(n)
//SC: O(n)
//works in leetcode
public class BinaryTreeRightSideView {

    public static List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<Integer>();

        if(root==null){
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode rightNode = null;

            int levelSize = q.size();

            while(levelSize > 0){ // loop for all nodes in level
                TreeNode node = q.remove();

                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);

                rightNode = node;
                levelSize--;
                System.out.println("right:" +rightNode.val);
            }

            result.add(rightNode.val); // last iteration value will come which will be rightmost

        }


        return result;
    }

    public static void main(String [] args){
        TreeNode node1 = new TreeNode(4, null,null);

        TreeNode node3 = new TreeNode(5,null,null);
        TreeNode node4 = new TreeNode(3,null,node1);
        TreeNode node2 = new TreeNode(2,null,node3);
        TreeNode head = new TreeNode(1,node2,node4);

        System.out.println(rightSideView(head));

    }
}












