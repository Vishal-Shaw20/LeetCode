class Solution {
    public boolean isIsomorphic(String s, String t) 
    {
        HashMap<Character, Character> sTotmap = new HashMap<>();
        HashMap<Character, Character> tTosmap = new HashMap<>();
        for(int i = 0; i < s.length(); i++)
        {
            char s_char = s.charAt(i);
            char t_char = t.charAt(i);
            if(sTotmap.containsKey(s_char))
            {
                if(sTotmap.get(s_char) == t_char)
                    continue;
                else
                    return false;
            }
            else if(tTosmap.containsKey(t_char))
            {
                if(tTosmap.get(t_char) == s_char)
                    continue;
                else
                    return false;
            }
            else
            {
                sTotmap.put(s_char, t_char);
                tTosmap.put(t_char, s_char);
            }
        }
        return true;
    }
}