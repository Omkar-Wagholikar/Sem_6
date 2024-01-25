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
