class Solution {
    public int numberOfSubstrings(String s) {
        int[] arr = new int[3];
        int i = 0, j = 0, count = 0, len = s.length();
        while(j < len)
        {
            arr[s.charAt(j) - 'a']++;
            while(arr[0] > 0 && arr[1] > 0 && arr[2] > 0)
            {
                count += len - j;
                arr[s.charAt(i++) - 'a']--;
            }
            j++;
        }
        return count;
    }
}