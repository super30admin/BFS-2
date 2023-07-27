/// BFS Solution 






   queue<TreeNode*> q;

            q.push(root);
            while(!q.empty()){
                int size = q.size();

                for(int i=0;i<size;i++){
                TreeNode * curr = q.front();
                q.pop();
            
                if(i == size-1 && curr!=NULL){
                        
                    j.push_back(curr->val);
                }
                if(curr!=NULL && curr->left !=NULL ) q.push(curr->left);
                if(curr!=NULL && curr->right !=NULL ) q.push(curr->right);

                }

            }





// DFS Solution 



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
 vector<int> j;
map<int,int> map;
    vector<int> rightSideView(TreeNode* root) {
           



                dfs(root,0);
            
                for(auto i: map){
                  j.push_back(i.second);
                }

            return j;
    }


    void dfs(TreeNode* root,int level){

            if(root == NULL ){
                return;
            }            

             if(root!=NULL){
                map[level] = root->val;
            }
          
             dfs(root->left,level+1);
           
             dfs(root->right,level+1);
            

    }
};