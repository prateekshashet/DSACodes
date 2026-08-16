import java.util.*;
public class LongestIncreasingSubsequence {
    /*
    The Core IdeaLet dp[i] be the length of the longest increasing subsequence that ends at index i.
    Base Case: Every single element by itself is an increasing subsequence of length 1. 
    So, initialize every entry in dp to 1.
    Transition: To find dp[i], look at all previous elements at index j 
    (where 0<= j < =i):If nums[i] > nums[j], it means nums[i] can extend the increasing subsequence that ends at
     j.So, dp[i] = max(dp[i], dp[j] + 1).
     Result: The answer is the maximum value found anywhere in the dp array.
     */

    public static void lis(int[] a,int n,int[] dp){
        if(n==1) return;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(a[i]>a[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }

    }
 public static void main(String[] args){
        int[] a={10, 9, 2, 5, 3, 7, 101, 18};
        int n=a.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        lis(a,n,dp);
        int maxlen=0;
        for(int v: dp){
            maxlen=Math.max(maxlen,v);
        }
        System.out.print(maxlen);
        
    }
}