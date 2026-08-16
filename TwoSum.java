import java.util.ArrayList;
import java.util.HashMap;

public class TwoSum {
    public static void findsum(int[] a,ArrayList<int[]> ans,int t){
        HashMap<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<a.length;i++){
            int comp=t-a[i];
            if(m.containsKey(comp)){
                ans.add(new int[]{m.get(comp),i});
            }
            m.put(a[i],i);
        }
    }
    public static void main(String[] args){
        int[] a={2,5,7,11,4,15};
        int t=9;
        ArrayList<int[]> ans=new ArrayList<>();
        findsum(a,ans,t);
        for (int[] i : ans) {
    System.out.print(java.util.Arrays.toString(i)+" ");
}

    }
}
