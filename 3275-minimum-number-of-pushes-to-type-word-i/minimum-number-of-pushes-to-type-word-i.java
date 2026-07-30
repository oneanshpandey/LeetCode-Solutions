class Solution {
    public int minimumPushes(String word) {
        int length = word.length();
        int totalPushes = 0;
        
        // Loop through each character position in the word
        for (int i = 0; i < length; i++) {
            // Determine the push cost based on its group of 8
            totalPushes += (i / 8) + 1;
        }
        
        return totalPushes;
    }
}