// tc = O(n) , sc = O(n)
class Solution {
public:
    class Test {
        public:
        TreeNode *node;
        TreeNode *parent;
        int lvl;
        Test(TreeNode *n, TreeNode *p, int l) {
            node = n;
            parent = p;
            lvl = l;
        }
        Test() {
            
        }
    };
    bool isCousins(TreeNode* root, int x, int y) {
        if(!root) return false;
        
        TreeNode *parent = new TreeNode(-1);
        int level = 0;
        queue<Test> q; //root,parent,level
        q.push(Test(root,parent,level));
        
        Test xLevel;
        Test yLevel;
        
        while(!q.empty()) {
            int size = q.size();
            ++level;
            while(size--) {
                Test front = q.front();
                q.pop();
                
                if(front.node->left) {
                    q.push(Test(front.node->left, front.node, level));
                }
                if(front.node->right) {
                    q.push(Test(front.node->right, front.node, level));
                }
                
                if(front.node->val == x) {
                    xLevel = front;
                }
                if(front.node->val == y) {
                    yLevel = front;
                }
            }
        }
        
        
        return xLevel.lvl == yLevel.lvl && xLevel.parent->val != yLevel.parent->val;
    }
};