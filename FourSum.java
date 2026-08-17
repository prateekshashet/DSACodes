import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void solve(int[] a,int n,List<ArrayList<Integer>> ans,int target){
        for(int i=0;i<n-4;i++){
            if(i>0&&a[i]==a[i-1]) continue;
            for(int j=i+1;j<n-3;j++){
                if(j>i+1&&a[j]==a[j-1]) continue;
                int l=j+1;
                int r=n-1;
                while(l<r){
                    int sum=a[i]+a[j]+a[l]+a[r];
                    if(sum==target){
                        ans.add(new ArrayList<>(Arrays.asList(a[i],a[j],a[l],a[r])));
                        while(l<r&&a[l]==a[l+1]) l++;
                        while(l<r&&a[r]==a[r-1]) r--;
                        l++;
                        r--;
                    }
                    else if(sum<target) l++;
                    else r--;
                }
            }
        }
    }
    public static void main(String[] args){
        int[] a={1,0,-1,0,-2,2};
        int target=0;
        Arrays.sort(a);
        List<ArrayList<Integer>> ans =new ArrayList<>();
        int n=a.length;
        solve(a,n,ans,target);
        System.out.println(ans);
    }
}
