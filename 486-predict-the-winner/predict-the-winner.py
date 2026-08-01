class Solution:
    def predictTheWinner(self, A: List[int]) -> bool:
        @cache
        def maxDiff(i: int, j: int) -> int:
            if i == j: return A[i]
            return max(A[i] - maxDiff(i + 1, j),
                       A[j] - maxDiff(i, j - 1))

        return maxDiff(0, len(A) - 1) >= 0
