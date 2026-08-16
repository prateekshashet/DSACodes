
public class MajorityElement {
    //find the element in the array whose count appears more than n/2 times.if no such element, return -1

    public static int countMajority(int[] a){
        int count=0;
        int candidate=a[0];
        for(int i=0;i<a.length;i++){
           int current=a[i];
           if(count==0){
            candidate=current;
            //count++;
           }
           if(current!=candidate){
            count--;
           }
           else{
            count++;
           }
        }

        return count>(int)a.length/2?candidate:-1;
    }
     public static void main(String[] args){
        int[] a={3,2,3,4,1};
        int me=countMajority(a);
        System.out.println(me);

    }
}
