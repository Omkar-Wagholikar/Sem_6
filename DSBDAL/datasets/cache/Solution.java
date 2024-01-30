import java.util.*;

class Solution {
    public void seive(int stop) {
        boolean [] check = new boolean[stop+1];
        check[0] = check[1] = true;
        for(int i=2; i<stop+1; i++){
            for(int j=i*i;j<stop+1; j+=i){
                check[j] = true;
            }
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i<stop+1; i++){
            if(i>1000 && !check[i]) set.add(i);
        }
        System.out.println(set.size());
    }
    public static void main(String [] args){
        Solution a = new Solution();
        
        a.seive(9999);
    }
}
// https://leetcode.com/problems/k-inverse-pairs-array
// https://leetcode.com/problems/longest-common-subsequence/description/
// https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/description/
// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/description/
// https://github.com/Edd17369/Algorithms/blob/2f9477ed9e2f1814275c2480232871dbc48222ba/DP.py
