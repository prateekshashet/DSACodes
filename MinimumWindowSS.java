import java.util.Arrays;

public class MinimumWindowSS {
    
    public static boolean fun(int[] need,int[] have){
        for(int i=0;i<256;i++){
            if(need[i]>have[i]) return false;


        }
        return true;
    }

    public static String minWindow(String s, String t) {
        int[] have=new int[256];
        int[] need=new int[256];
        Arrays.fill(need,0);
        Arrays.fill(have,0);
        for(int i=0;i<t.length();i++){
            need[t.charAt(i)]++;
        }
        /*for(int i=0;i<s.length();i++){
            have[s.charAt(i)-'0']++;
        }*/
        int l=0;
        int res=Integer.MAX_VALUE;
        int start=0;
        for(int h=0;h<s.length();h++){
            have[s.charAt(h)]++;
            while(fun(need,have)){
                int len=h-l+1;
                if(len<res){
                    res=Math.min(res,len);
                    start=l;
                }
                
            
            have[s.charAt(l)]--;
            l++;
            }
        }
        return res==Integer.MAX_VALUE?"":s.substring(start,start+res);
    }


    public static void main(String[] args){
        String s="ADOBECODEBANC";
        String t="ABC";
        String ans=minWindow(s,t);
        System.out.print(ans);
    }

}