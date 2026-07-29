import java.util.Arrays;

public class Solution {
    // Upper bound for k to prevent overflow when counting total permutations
    private static final long MAX_K = 1_000_000_000_000_000_000L; 

    public String smallestPalindrome(String s, long k) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Validate if a palindrome rearrangement is possible
        int oddCount = 0;
        char midChar = '\0';
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                midChar = (char) ('a' + i);
            }
        }

        if (oddCount > 1) {
            return "";
        }

        // Extract frequencies required for the left half
        int[] halfCount = new int[26];
        int halfLen = 0;
        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
            halfLen += halfCount[i];
        }

        // Check if total possible unique palindromic permutations are less than k
        if (countPermutations(halfCount, halfLen) < k) {
            return "";
        }

        // Reconstruct the lexicographically smallest left half
        StringBuilder leftHalf = new StringBuilder();
        int remainingLen = halfLen;

        for (int step = 0; step < halfLen; step++) {
            for (int i = 0; i < 26; i++) {
                if (halfCount[i] == 0) continue;

                // Hypothetically place character i at current position
                halfCount[i]--;
                long arrangements = countPermutations(halfCount, remainingLen - 1);

                if (arrangements >= k) {
                    leftHalf.append((char) ('a' + i));
                    remainingLen--;
                    break; // Successfully chose character for this position
                } else {
                    k -= arrangements;
                    halfCount[i]++; // Backtrack and check next character
                }
            }
        }

        // Construct final string: Left half + Middle character (if exists) + Reversed left half
        String leftStr = leftHalf.toString();
        String rightStr = new StringBuilder(leftStr).reverse().toString();
        
        if (midChar != '\0') {
            return leftStr + midChar + rightStr;
        }
        return leftStr + rightStr;
    }

    // Helper method to compute unique multinomial arrangements safely without overflow
    private long countPermutations(int[] halfCount, int total) {
        long res = 1;
        int currentTotal = total;

        for (int freq : halfCount) {
            if (freq == 0) continue;
            res = multiplyAndCap(res, nCr(currentTotal, freq));
            if (res >= MAX_K) return MAX_K;
            currentTotal -= freq;
        }
        return res;
    }

    // Combination function nCr calculated dynamically
    private long nCr(int n, int r) {
        if (r > n) return 0;
        if (r == 0 || r == n) return 1;
        if (r > n - r) r = n - r; // Optimize computations

        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - i + 1) / i;
            if (res >= MAX_K) return MAX_K;
        }
        return res;
    }

    // Safe multiplication bounded by a maximum threshold value
    private long multiplyAndCap(long a, long b) {
        if (a == 0 || b == 0) return 0;
        if (a >= MAX_K || b >= MAX_K) return MAX_K;
        if (a > MAX_K / b) return MAX_K;
        return a * b;
    }
}