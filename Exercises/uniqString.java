import java.util.HashSet;

public class uniqString {
    public static int findSubstringInWraproundString(String p) {
        HashSet<String> hset = new HashSet<String>();
        String s = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        for(int windowSize = 1; windowSize <= p.length(); windowSize++)
        {
            int i = 0;
            for(int j = windowSize; j <= p.length(); j++)
            {
                String sub = p.substring(i,j);
                System.out.println(windowSize + ":" + sub);
                if(!hset.contains(sub))
                {
                    if(s.contains(sub))
                    {
                        System.out.println("Adding" + sub);
                        hset.add(sub);
                    }
                }
                i++;
            }
        }
        return hset.size();
        
    }

    public static void main(String[] args)
    {
        System.out.println(findSubstringInWraproundString("zab"));
    }
}