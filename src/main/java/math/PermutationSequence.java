/**
 The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 Given n and k, return the kth permutation sequence.

 Example 1:

 Input: n = 3, k = 3
 Output: "213"
 Example 2:

 Input: n = 4, k = 9
 Output: "2314"
 Example 3:

 Input: n = 3, k = 1
 Output: "123"

 Constraints:

 1 <= n <= 9
 1 <= k <= n!
 */

package main.java.math;

public class PermutationSequence {

    int[] perm;
    int permIdx;
    int[] buffer;
    int buffLen;

    int[] factorialHash = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    public String getPermutation(int n, int k) {
        perm = new int[n];
        permIdx = 0;

        buffer = new int[n];
        for (int i = 0; i < n; i++) {
            buffer[i] = i + 1;
        }
        buffLen = n;

        permutation(k, 0);

        StringBuilder stringBuilder = new StringBuilder();
        for (int p : perm) {
            stringBuilder.append(p);
        }

        return stringBuilder.toString();
    }

    private void permutation(int k, int l) {
        if (buffLen == 0) {
            return;
        }

        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] == 0) {
                continue;
            }
            int tmp = buffer[i];
            perm[permIdx++] = tmp;
            buffer[i] = 0;
            buffLen--;

            if (l + factorialHash[buffLen] < k) {
                l += factorialHash[buffLen];
                permIdx--;
                buffer[i] = tmp;
                buffLen++;
            } else {
                permutation(k, l);
                return;
            }

        }
    }

}
