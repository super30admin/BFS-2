/// BFS Solution

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

    int x_val = 0;
    int y_val = 0;
    TreeNode* x_parent = NULL;
    TreeNode* y_parent = NULL;
    bool isCousins(TreeNode* root, int x, int y) {

            queue<TreeNode*> q;
            queue<TreeNode*> pq;

            q.push(root);
            pq.push(NULL);


            while(!q.empty()){
                int size = q.size();
               
                     bool x_val = false;
                    bool y_val = false;
                    TreeNode*  x_par = NULL;
                    TreeNode* y_par = NULL;  
                for(int i=0; i<size;i++){ 
                     TreeNode* curr = q.front();
                TreeNode* currPar = pq.front();
                q.pop();
                pq.pop();  
               
                             
                    if(x == curr->val){
                
                        x_val = true;
                        x_par = currPar;
                              
                    }
                    if(y == curr->val){
                        y_val = true;
                        y_par = currPar;
                           cout<< x_val <<"  "<<y_val;    
                    }

                    if(curr->left!=NULL){
                            q.push(curr->left);
                             pq.push(curr);
                             
                    }
                    if(curr->right!=NULL){
                            q.push(curr->right);
                             pq.push(curr);
                    } 
                     if(x_val && y_val){
                         if(x_par!=y_par){
                      return true;
                           }
                         }
                  

                }
                }

                return false;
            }

   





   // DFS Solution


            dfs(root,x,y,0,NULL);
            if(x_val == y_val && x_parent!=y_parent){
                return true;
            }

    

    void dfs(TreeNode* root,int x,int y,int level,TreeNode* parent){

        if(root == NULL){
            return;
        }

        if(x==root->val){
            x_val = level;
            x_parent = parent;
        }
        if(y==root->val){
            y_val = level;
            y_parent = parent;
        }


        dfs(root->left,x,y,level+1,root);
        dfs(root->right,x,y,level+1,root);
    }

};