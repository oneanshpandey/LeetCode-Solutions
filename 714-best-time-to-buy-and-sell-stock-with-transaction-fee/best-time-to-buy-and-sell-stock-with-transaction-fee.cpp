class Solution {
public:
    int maxProfit(vector<int>& prices, int fee) {
        int rest = 0;
        int hold = -prices[0];

        for (int i = 1; i < prices.size(); i++) {
            int oldRest = rest;
            int oldHold = hold;

            rest = max(oldRest, oldHold + prices[i] - fee);
            hold = max(oldHold, oldRest - prices[i]);
        }

        return rest;
    }
};