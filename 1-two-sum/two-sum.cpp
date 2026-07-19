class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        // Key: number from array, Value: its index
        unordered_map<int, int> num_map;

        for (int i=0; i < nums.size(); ++i) {
            int complement = target - nums[i];

            // Check if the required complement already exists in the map
            if (num_map.find(complement) != num_map.end()) {
                return {num_map[complement], i};
            }
            // Otherwise, store thee current number and its index
            num_map[nums[i]] = i;
        }

        // Return empty vector if no solution is found (guaranteed not to happen per problem constraints)
        return{};   
    }    
};