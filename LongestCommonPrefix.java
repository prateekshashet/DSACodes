
public class LongestCommonPrefix {
    //return the longest common prefix of 3 strings else return -1;

    public static String lcp(String s1,String s2,String s3){
        StringBuilder ans = new StringBuilder();
        int n = Math.min(s1.length(), Math.min(s2.length(), s3.length()));

        for (int i = 0; i < n; i++) {
            char c = s1.charAt(i);
            if (c == s2.charAt(i) && c == s3.charAt(i)) {
                ans.append(c);
            } else {
                break;
            }
        }

        if (ans.length() == 0) return "-1";
        return ans.toString();
    }
     public static void main(String[] args){
        String s1="flight";
        String s2="flow";
        String s3="flower";
       String ans=lcp(s1,s2,s3);
        System.out.println(ans);

    }
}


/*alternate approach-if list of string is been given

public static String lcp(String[] strs) {
    if (strs == null || strs.length == 0) return "-1";
    
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++) {
        // Keep trimming the prefix until the current string starts with it
        while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return "-1";
        }
    }
    return prefix;
}
     */