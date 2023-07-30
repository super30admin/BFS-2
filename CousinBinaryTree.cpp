//Time Complexity:O(n)
//Space Complexity:O(n)
//Performed BFS to keep track of the node as well the parent node and check if x and y are on the same level and if their parents are
//different, if yes, return true, else return false
class Solution {
public:
    bool isCousins(TreeNode* root, int x, int y) { 
        queue<TreeNode*> q;
        queue<TreeNode*> pq;

        q.push(root);
        pq.push(NULL);

        bool x_found = false;
        bool y_found = false;
        TreeNode* xParent = NULL;
        TreeNode* yParent = NULL;

        while(!q.empty()){
            int size = q.size();
             
            for(int i=0;i<size;i++){
                TreeNode* curr = q.front();
                TreeNode* pCurr = pq.front();
                
                q.pop();
                pq.pop();
               

                if(curr->left!=NULL){
                    q.push(curr->left);
                    pq.push(curr);

                }
                if(curr->right!=NULL){
                    q.push(curr->right);
                    pq.push(curr);
                }

                if(curr->val == x){
                    x_found = true;
                    xParent = pCurr;
                }
                if(curr->val == y){
                    y_found = true;
                    yParent = pCurr;


                }

                




            }

            if((x_found && !y_found)||(y_found && !x_found)){
                return false;
            }
            
            if((x_found && y_found)&&(xParent != yParent)){
                return true;
                
            }


            
            


        }

        return false;

        
    }
};