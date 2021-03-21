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

    // [3,9,20,null,null,15,7]
    public TreeNode getSample() {
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

    // [1,2,3,4]
    public TreeNode getSampleTwo() {
        TreeNode root = getNode(1);
        TreeNode node2 = getNode(2);
        TreeNode node3 = getNode(3);
        TreeNode node4 = getNode(4);

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        return root;
    }

    // [1,2,3,null,4,null,5]
    public TreeNode getSampleThree() {
        TreeNode root = getNode(1);
        TreeNode node2 = getNode(2);
        TreeNode node3 = getNode(3);
        TreeNode node4 = getNode(4);
        TreeNode node5 = getNode(5);

        root.left = node2;
        root.right = node3;

        node2.right = node4;

        node3.right = node5;
        return root;
    }



        // [3,9,20,44,33,15,7]
        public TreeNode getSampleFour() {
            TreeNode root = getNode(3);
            TreeNode node9 = getNode(9);
            TreeNode node20 = getNode(20);
            TreeNode node15 = getNode(15);
            TreeNode node7 = getNode(7);
            TreeNode node44 = getNode(44);
            TreeNode node33 = getNode(33);
    
            root.left = node9;
            root.right = node20;
    
            node9.left = node44;
            node9.right = node33;

            node20.left = node15;
            node20.right = node7;
            return root;
        }


        //[1,2,3,null,4,null,5]
        public TreeNode getSampleSix() {
            TreeNode root = new TreeNode(1);
            TreeNode node2 = new TreeNode(2);
            TreeNode node3 = new TreeNode(3);
            TreeNode node4 = new TreeNode(4);
            TreeNode node5 = new TreeNode(5);

            root.left = node2;
            root.right = node3;
            node2.right = node4;
            node3.right = node5;
            return root;
        }

}
