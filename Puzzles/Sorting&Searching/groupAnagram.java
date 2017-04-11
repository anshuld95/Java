import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;

public class groupAnagram {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<List<String>>();
        HashMap<String, List<String>> hmap = new HashMap<String, List<String>>();
        for (int i = 0; i<strs.length; i++)
        {
            char[] tmp = strs[i].toCharArray(); 
            Arrays.sort(tmp);
            String sortedTmp = new String(tmp);
            if (hmap.containsKey(sortedTmp))
            {
                hmap.get(sortedTmp.toString()).add(strs[i]);
            }
            else
            {
                List<String> ls = new ArrayList<String>();
                ls.add(strs[i]);
                hmap.put(sortedTmp, ls);
            }
        }
        
        for(String s : hmap.keySet())
        {
            output.add(hmap.get(s));
        }
        
        return output;
    }
    
    public static void main(String[] args)
    {
        String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        for(List<String> s : groupAnagrams(strs))
        {
            for (String str:  s)
            {
                System.out.print(str+",");
            }
            System.out.println();
        }
    }
}