class Solution {
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int k;
        if(n%2 == 0)
        {
            k = n / 2;
            for(int i = (n - 1); i >= 0; i--)
            {
                arr[i] = k--;
                if(k == 0)
                k--;
            }
        }
        else
        {
            k = n / 2;
            for(int i = (n - 1); i >= 0; i--)
            arr[i] = k--;
        }
        return arr;
    }
}