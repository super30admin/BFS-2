/*
Time complexity:
O(N) as we are traversing the tree only once
*/

/*
Space Complexity:
O(H) where H is the height of the tree.
*/

/*
Approach:
Recursion and dfs is is used. But here we are starting the dfs from the right side. As we
need only the right side nodes. And we make use of the size of the result and the level too.
At the start our level is 0 and the size of the result vector is also zero. Now their size
is same so we add the node to the result vector. Then we perform the dfs on the right side
and simultaneouly increase the level by 1. Then when we are on the next level which is level
1, the size of our result vector is also 1. So we add the current node again to the result.
This process goes on until we reach the NULL and then we move on to the left side. But now
when we are at level 1 we see that the size of the result is not equal to the level as
it already has the elements in it. So we do not put anything inside the result vector. This
process goes on and we get our right side view of the tree.

" We can get our answer by performing dfs starting with left side too." The only difference
there would be we have to replace the values when we hit the right side. 

"We can do it with BFS too "
*/

// The code ran perfectly on leetcode.

class Solution {
    vector<int> result;
public:
    
    vector<int> rightSideView(TreeNode* root) {
      dfs(root,0);
        return result;
    }
    
    private:
    void dfs(TreeNode* root, int level){
        //base
        if(root == NULL) return;
        //logic
        if(level== result.size()){
            result.push_back(root->val);
        } 
        
        dfs(root->right, level +1);
        dfs(root->left, level +1);
        
        }
    
};