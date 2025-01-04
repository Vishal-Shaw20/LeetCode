class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int s = 0;
        for(List L : items)
        {
            if(ruleKey.equals("type") && L.get(0).equals(ruleValue))
                s++;
            else if(ruleKey.equals("color") && L.get(1).equals(ruleValue))
                s++;
            else if(ruleKey.equals("name") && L.get(2).equals(ruleValue))
                s++;
        }
        return s;
    }
}