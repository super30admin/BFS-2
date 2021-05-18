public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode getNode(int data) {
        return new TreeNode(data);
    }

    // [1,2,3]
    public TreeNode getSample() {
        TreeNode root = getNode(1);
        TreeNode node2 = getNode(2);
        TreeNode node3 = getNode(3);
        root.left = node2;
        root.right = node3;
        return root;
    }

    // [4,9,0,5,1]
    public TreeNode getSampleTwo() {
        TreeNode root = getNode(4);
        TreeNode node9 = getNode(9);
        TreeNode node0 = getNode(0);
        TreeNode node5 = getNode(5);
        TreeNode node1 = getNode(1);
        root.left = node9;
        root.right = node0;
        node9.left = node5;
        node9.right = node1;
        return root;
    }

    // [1,0]
    public TreeNode getSampleThree() {
        TreeNode root = getNode(1);
        TreeNode node0 = getNode(0);
        root.left = node0;
        return root;
    }

    // [5,3,9,0,4]
    public TreeNode getSampleBST() {
        TreeNode root = getNode(5);
        TreeNode node9 = getNode(9);
        TreeNode node0 = getNode(0); 
        TreeNode node4 = getNode(4);
        TreeNode node3 = getNode(3);
        root.left = node3;
        root.right = node9;
        node3.left = node0;
        node3.right = node4;
        return root;
    }
    
    public TreeNode getSampleBSTTwo() {
        TreeNode root = getNode(1);
        TreeNode node2 = getNode(2);
        TreeNode node2Two = getNode(2);
        TreeNode node3 = getNode(3);
        TreeNode node3Two = getNode(3);
        TreeNode node4 = getNode(4);
        TreeNode node4Two = getNode(4);

        root.left = node2;
        root.right = node2Two;
        node2.left = node3;
        node2.right = node3Two;
        node3.left = node4;
        node3.right = node4Two;
        return root;
    }

    //[3,9,20,null,null,15,7]
    public TreeNode getSampleFive() {
        TreeNode root = getNode(3);
        TreeNode node9 = getNode(9);
        TreeNode node20 = getNode(20);
        TreeNode node15 = getNode(15);
        TreeNode node7 = getNode(7);

        root.left = node9;
        root.right = node20;
        node20.left = node15;
        node20.right = node7;
        return root;
    }

}
