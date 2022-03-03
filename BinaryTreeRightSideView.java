import java.util.ArrayList;
import java.util.List;

/*
Time Complexity: O(H+N) H is the height of the tree, and N is the length of the levels list
Space Complexity: O(H+N) height of the tree recursion and N is the size of the list
Any difficulties: no
Run on leetcode: yes

Approach:
1. When we will have level order traversal than the every last element of the every level values would be right leaf/root
2. I am recursively processing levels of the tree and keep storing values at root into the levels nested list
3. Once all the levels list is there, I am iterating to the levels list and getting the extreme end element and storing
it to the resultant list
 */
public class BinaryTreeRightSideView {
    public static class TreeNode{
        int val ;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }

        TreeNode (int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private static List<List<Integer>> levels;
    public static List<Integer> rightSideView(TreeNode root){
        levels = new ArrayList<>();

        if(root == null){
            return new ArrayList<>();
        }

        levelOrderTraversal(root, 0);
        List<Integer> result = new ArrayList<>();
        for(List<Integer> curr : levels){
            if(curr.size() == 1){
                result.add(curr.get(0));
            }else{
                result.add(curr.get(curr.size()-1));
            }
        }
        return result;
    }

    public static void levelOrderTraversal(TreeNode root, int level){
        if(levels.size() == level){
            levels.add(new ArrayList<>());
        }

        levels.get(level).add(root.val);

        if(root.left!= null){
            levelOrderTraversal(root.left, level+1);
        }

        if(root.right!= null){
            levelOrderTraversal(root.right, level+1);
        }
    }

    public static void main(String[] args){
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.left.right = new TreeNode(5);
            root.right = new TreeNode(3);
            root.right.right = new TreeNode(4);

            System.out.println(rightSideView(root));
    }

}
