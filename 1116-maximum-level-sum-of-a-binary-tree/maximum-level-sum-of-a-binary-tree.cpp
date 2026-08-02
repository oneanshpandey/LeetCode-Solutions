class Solution {
public:
    int maxLevelSum(TreeNode* root) {
        queue<TreeNode*> q;
        q.push(root);
        int level = 1 , maxSum = INT_MIN;
        int ans = 0;
        while(!q.empty()){
            int levelSum = 0;
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode* node = q.front();
                q.pop();
                levelSum += node->val;
                if(node->left) q.push(node->left);
                if(node->right) q.push(node->right);
            }
            if(levelSum > maxSum){
                ans = level;
            }
            maxSum = max(maxSum,levelSum);
            level++;
        }
        return ans;
    }
};