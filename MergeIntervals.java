import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    //merge the overlapping intervals
    public static void mergeIntervals(int[][] m,ArrayList<int[]> ans,int n){
        Arrays.sort(m,(a, b) -> Integer.compare(a[0], b[0]));
        int start1=m[0][0];
        int end1=m[0][1];
        for(int i=1;i<n;i++){
            int start2=m[i][0];
            int end2=m[i][1];
            if(end1>=start2){
                end1=Math.max(end1,end2);
                
                //ans.add(new int[]{start1,end1});
                continue;
            }
            ans.add(new int[]{start1,end1});
            start1=start2;
            end1=end2;
              
        }
        ans.add(new int[]{start1,end1});
        
    }
     public static void main(String[] args){
        int[][] m={{2,6},{1,3},{8,13},{15,18},{17,20}};
        int n=m.length;
        ArrayList<int[]> ans=new ArrayList<>();
        mergeIntervals(m,ans,n);
        
       for (int[] interval : ans) {
    System.out.println(java.util.Arrays.toString(interval));
}
    }


}
