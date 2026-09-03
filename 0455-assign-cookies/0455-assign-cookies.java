class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);
        int i = 0, j = 0, l = s.length, m = g.length, count = 0;
        while(i < l && j < m)
        {
            if(s[i] >= g[j])
            {
                count++;
                j++;
            }
            i++;
        }
        return count;
    }
}