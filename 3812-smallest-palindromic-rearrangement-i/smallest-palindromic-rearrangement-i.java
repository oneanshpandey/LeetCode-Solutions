class Solution {
    public String smallestPalindrome(String s) {
        // Step 1: Count character frequencies
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        
        // Step 2: Build the first half and find the middle character
        StringBuilder firstHalf = new StringBuilder();
        String mid = "";
        
        for (int i = 0; i < 26; i++) {
            if (counts[i] == 0) continue;
            
            // If the character count is odd, it must be the central character
            if (counts[i] % 2 != 0) {
                mid = String.valueOf((char) (i + 'a'));
            }
            
            // Append half of the frequencies to the first half
            for (int j = 0; j < counts[i] / 2; j++) {
                firstHalf.append((char) (i + 'a'));
            }
        }
        
        // Step 3: Combine first half, middle character, and the reversed first half
        String half = firstHalf.toString();
        String secondHalf = firstHalf.reverse().toString();

        return half + mid + secondHalf;
    }
}