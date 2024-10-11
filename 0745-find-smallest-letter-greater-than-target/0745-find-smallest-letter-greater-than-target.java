class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int first = 0, last = letters.length -1, mid = 0;
        while(first <= last)
        {
            mid = first + (last - first)/2;
            if(letters[mid] > target)
                last = mid - 1;
            else if(letters[mid] < target)
                first = mid + 1;
            else if(letters[mid] == target)
            {
                while(letters[mid] == target)
                {
                    if(mid == (letters.length - 1))
                        return letters[0];
                    mid++;
                }
                return letters[mid];
            }
        }
        if((last >= 0) && (letters[last] == target))
        {
            while(letters[mid] == target)
            {
                if(mid == (letters.length - 1))
                    return letters[0];
                mid++;
            }
        }
        if(first >= letters.length)
            return letters[0];
        return letters[first];
    }
}