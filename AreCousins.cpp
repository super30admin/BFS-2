class Solution {
    // TC - O(n)
    // SC - O(n)
public:
    vector<int> rightSideView(TreeNode* root) {
        queue<TreeNode*> bfs;
        vector<int> result;
        if(root) bfs.push(root);
        else return vector<int>();

        while(bfs.size()!=0){
            int size= bfs.size();
            while(size >0){
                TreeNode *node = bfs.front(); 
                if(size==1) result.push_back(node->val);
                if (node->left) bfs.push(node->left);
                if(node->right) bfs.push(node->right);

                bfs.pop();
                size--;
            }

        }
        return result;
        
    }
};