//Time Complexity:O(N)
//Space Complexity:O(N*N)
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        boolean result;
        HashMap<Integer, Integer> depthMap = new HashMap<>();
        HashMap<Integer, Integer> parentsMap = new HashMap<>();
        traverseTree(root, x, y, 0, depthMap, parentsMap);
        result=(depthMap.get(x) == depthMap.get(y)) && (parentsMap.get(x) != parentsMap.get(y));
        return result;
    }
    public static void traverseTree(TreeNode root,  int x, int y,int depth, HashMap<Integer, Integer> depthMap, HashMap<Integer, Integer> parentsMap) {
        if (depthMap.containsKey(x) && depthMap.containsKey(y)){
            return;
        }
        if (root == null){
            return;
        }
        depthMap.put(root.val, depth);
        if (root.left != null){
            parentsMap.put(root.left.val, root.val);
        }
        if (root.right != null){
            parentsMap.put(root.right.val, root.val);
        }
        traverseTree(root.left, x, y, depth + 1, depthMap, parentsMap);
        traverseTree(root.right, x, y,depth + 1, depthMap, parentsMap);
    }
}