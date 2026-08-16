import java.util.ArrayList;

public class Subset{
    public static void subset(int[] arr,int n,ArrayList<ArrayList<Integer>> ans,int idx,ArrayList<Integer> temp){
        
        if(idx==n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        else{
            //ans.add(temp);
            subset(arr,n,ans,idx+1,temp);

            //picking
            temp.add(arr[idx]);
            subset(arr,n,ans,idx+1,temp);
            //ans.add(temp);
            temp.remove(temp.size() - 1);
        }
    }
    public static void main(String[] args){
        int[] arr={1,2,3};
        int n=arr.length;
        ArrayList<ArrayList<Integer>> ans =new ArrayList<>();
        ArrayList<Integer> temp =new ArrayList<>();
        subset(arr,n,ans,0,temp);
        System.out.print(ans);
    }
}