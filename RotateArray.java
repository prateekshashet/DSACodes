import java.util.Arrays;

class RotateArray{
    //rotate the given array to the right based in the number of positions k, and it must be in place
    public static void rev(int start,int end,int[] a){
        while(start<end){
            int t=a[start];
            a[start]=a[end];
            a[end]=t;
            start++;
            end--;
        }
    }
    
    public static void rotate(int[] a,int k){
        int n=a.length;
        k%=n;
        rev(0,n-1,a);
        rev(0,k-1,a);
        rev(k,n-1,a);
    }

    public static void main(String[] args){
        int[] a={1,2,3,4,5,6,7};
        int k=2;
        rotate(a,k);
        System.out.println(Arrays.toString(a));

    }
}