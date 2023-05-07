class Solution {
    //TC - O(n)
    // SC - O(n)
public:
    bool isCousins(TreeNode* root, int x, int y) {
        queue<TreeNode*> que;
        que.push(root);
        bool isXFound = false;
        bool isYFound = false;
        while(que.size() !=0 ){
            int size = que.size();
            
            while(size){
                TreeNode* node = que.front();
                if(node->val == x) isXFound=true;
                if(node->val == y) isYFound=true;
                if(node->left && node->right){
                    if((node->left->val == x && node->right->val ==y) || (node->left->val == y && node->right->val ==x)){
                        return false;
                    }
                }
                if(node->left) que.push(node->left);
                if(node->right) que.push(node->right);
                que.pop();
                size--;
                if(isXFound && isYFound ) return true;
            }
            
            if(isXFound && !isYFound) return false;
            if(isYFound && !isXFound) return false;
            
        }
        
        return false;
    }
};