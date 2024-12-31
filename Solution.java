
import java.util.*;

public class Solution {
    public static String getHint(String secret, String guess) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int bulls=0,c=0;
        for(int i=0;i<secret.length();i++)
        {
            if(secret.charAt(i)==guess.charAt(i))
                bulls++;
            else
            {
                if(hm.containsKey(secret.charAt(i)))
                    hm.put(secret.charAt(i), hm.get(secret.charAt(i))+1);
                else
                    hm.put(secret.charAt(i), 1);
            }
        }
        for(int i=0;i<guess.length();i++)
        {
            if(!(secret.charAt(i)==guess.charAt(i)))
            {
                if(hm.containsKey(guess.charAt(i)) && hm.get(guess.charAt(i))>0)
                {
                    hm.put(guess.charAt(i), hm.get(guess.charAt(i))-1);
                    c++;
                }
            }

        }
        String  str= bulls+"A"+c+"B";
        return str;
        
    }

    public static void main(String[] args) {
        String secret = "1123";
        String guess = "0111";

        String ans = getHint(secret,guess);
        System.out.println(ans);
    }
}
