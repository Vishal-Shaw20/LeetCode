class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backtrack(list, map, new StringBuilder(), digits, 0);
        return list;
    }
    public void backtrack(List<String> list, String[] map, StringBuilder str, String digits, int index)
    {
        if(index == digits.length())
        {
            list.add(str.toString());
            return;
        }
        String l = map[digits.charAt(index) - '0'];
        for(char ch : l.toCharArray())
        {
            str.append(ch);
            backtrack(list, map, str, digits, index + 1);
            str.deleteCharAt(str.length() - 1);
        }
    }
}