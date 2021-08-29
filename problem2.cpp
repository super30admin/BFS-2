//Time Complexity -O(N)
//Space Complexity - O(N)
class Solution {
public:
    bool isCousins(TreeNode* root, int x, int y) {
        queue<TreeNode*>q;
        q.push(root);
        int lvl=0,lvl1,lvl2;
        TreeNode* parent1=NULL;
        TreeNode* parent2=NULL;
        while(!q.empty()){
            int n=q.size();
            while(n--){
                if(q.front()->left){
                    q.push(q.front()->left);
                    if(q.front()->left->val==x){
                        parent1=q.front();
                        lvl1=lvl+1;
                    }
                    if(q.front()->left->val==y){
                        parent2=q.front();
                        lvl2=lvl+1;
                    }
                }
                if(q.front()->right){
                    q.push(q.front()->right);
                    if(q.front()->right->val==x){
                        parent1=q.front();
                        lvl1=lvl+1;
                    }
                    if(q.front()->right->val==y){
                        parent2=q.front();
                        lvl2=lvl+1;
                    }
                }
                if(parent1!=NULL&&parent2!=NULL){
                    return lvl1==lvl2 && parent1!=parent2;
                }
                q.pop();
            }
            lvl++;
        }
        return lvl1==lvl2 && parent1!=parent2;
    }
};