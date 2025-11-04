class Solution {
    public List<String> generateParenthesis(int n) 
    {
        List<String> list = new ArrayList<>();
        return helper(n, new StringBuilder(), 0, 0, list);
    }
    public List<String> helper(int n, StringBuilder str, int n1, int n2, List<String> list)
    {
        if(n == n1 && n == n2)
        {
            list.add(str.toString());
            return list;
        }
        if(n1 < n)
        {
            str.append("(");
            helper(n, str, n1 + 1, n2, list);
            str.deleteCharAt(str.length() - 1);
        }
        if(n2 < n1)
        {
            str.append(")");
            helper(n, str, n1, n2 + 1, list);
            str.deleteCharAt(str.length() - 1);
        }
        return list;
    }
}