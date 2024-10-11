class Solution2 {
    public char nextGreatestLetter(char[] letters, char target) {
        int first = 0, last = letters.length -1, mid = 0;
        while(first <= last)
        {
            mid = first + (last - first)/2;
            if(letters[mid] > target)
                last = mid - 1;
            else
                first = mid + 1;
        }
        return letters[first % letters.length];
    }
}