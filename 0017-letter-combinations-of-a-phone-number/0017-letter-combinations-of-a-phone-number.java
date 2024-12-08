class Solution {
    public static List<String> letterCombinations(String digits)
    {
        List<String> list = new ArrayList<>();
        if(digits.isEmpty())
            return list;
        display("",digits,list);
        return list;
    }
    public static void display(String p, String up, List<String> list)
    {
        if(up.isEmpty())
        {
            list.add(p);
            return;
        }
        int r = Integer.parseInt(Character.toString(up.charAt(0)));
        String s = pass(r);
        display(p + Character.toString(s.charAt(0)),up.substring(1),list);
        display(p + Character.toString(s.charAt(1)),up.substring(1),list);
        display(p + Character.toString(s.charAt(2)),up.substring(1),list);
        if(r == 7 || r == 9)
            display(p + Character.toString(s.charAt(3)),up.substring(1),list);
    }
    public static String pass(int a)
    {
        String[] h = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        return h[a];
    }
}