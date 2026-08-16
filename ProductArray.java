import java.util.Arrays;

public class ProductArray {
    //compute the product of the array elements except the current element
    // a[1,2,3,4] o/p [24,12,8,6]
    public static void product(int[] a,int n,int[] res){
        int pref=1;
        for(int i=0;i<n;i++){
            res[i]=pref;
            pref*=a[i];
        }
        int suff=1;
        for(int i=n-1;i>=0;i--){
            res[i]*=suff;
            suff*=a[i];
        }
    }
    public static void main(String[] args){
        int[] a={5,6,2,4};
        int n=a.length;
        int[] res=new int[n];
        Arrays.fill(res,1);
        product(a,n,res);
        System.out.println(Arrays.toString(res));
        
    }
}
