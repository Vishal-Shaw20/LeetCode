class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        ArrayList<Integer> number = new ArrayList<>();
        ArrayList<Integer> key = new ArrayList<>();
        int n = 0;
        for(int i = 0; (i < num.length) || (k != 0); i++,k/=10)
        {
            if(i < num.length)
                number.add(num[i]);
            else
                number.addFirst(0);
            key.add(k%10);
        }
        Collections.reverse(key);
        for(int i = (number.size()-1); i >= 0; i--)
        {
            n+= number.get(i) + key.get(i);
            number.set(i,n%10);
            n/=10;
        }
        if(n != 0)
            number.addFirst(n);
        return number;
    }
}