//time complexity: O(n)
//space complexity: O(n)

//pPerformed BFS and took the last element for each level
class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        if(root==NULL) return {};
        queue<TreeNode*> q;
        q.push(root);
        vector<int> li;



        while(!q.empty()){
            int size=q.size();
            
            for(int i=0;i<size;i++){
                TreeNode* curr = q.front();
                q.pop();

                if(i==size-1)li.push_back(curr->val);

                if(curr->left!=NULL){
                    q.push(curr->left);
                }
                if(curr->right!=NULL){
                    q.push(curr->right);
                }


            }
        
            
            


        }

        return li;
        
    }
};