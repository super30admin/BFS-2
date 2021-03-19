
//TC: O(n) 
//SC: O(n) where n is number of elements

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool isCousins(TreeNode* root, int x, int y) {
        if(root == NULL) 
            return false;
        
        //create a queue of pairs (element, element's parent). 
        //Perform a level order traversal and check if the values exist at any level together.
        queue<pair<TreeNode*, int>> q;
        
        q.push({root, -1});
        
        while(!q.empty()){
            //can check parents at this level
            int parentx = -1;
            int parenty = -1;            
            int qsize = q.size();
            for(int i=0; i<qsize; i++){
                
                pair<TreeNode*, int> curr = q.front();
                q.pop();
                
                if(curr.first->val == x){
                    parentx = curr.second;
                }
                else if(curr.first->val == y){
                    parenty = curr.second;
                }
                
                
                if(curr.first->left!=NULL)
                    q.push({curr.first->left, curr.first->val});
                
                if(curr.first->right!=NULL)
                    q.push({curr.first->right, curr.first->val});
                
            }
            
            //only condition where this passes is if both parents exist at this level and they are not the same.
            if(parentx!=-1 && parenty!=-1 && parentx!=parenty)
                return true;
            
            else if( (parentx!=-1 && parenty == -1) || (parentx == -1 && parenty !=-1))
                return false;
        }
        
        return false;
        
        
        
        
    }
};