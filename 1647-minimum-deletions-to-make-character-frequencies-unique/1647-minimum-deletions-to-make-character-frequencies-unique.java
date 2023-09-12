class Solution {
    public int minDeletions(String s) {
        HashMap<Character, Integer> m=new HashMap<>();
        int n=0;
        char[] str=s.toCharArray();
        for(char c:str)
        {
            if(!m.containsKey(c))
                m.put(c,1);
            else
                m.put(c,m.get(c)+1);
        }
        ArrayList<Integer> f=new ArrayList<>(m.values());
        HashSet<Integer> h=new HashSet<>();
        for(int a: f)
        {
            if(!h.contains(a))
                h.add(a);
            else{
                while(a>0 && h.contains(a))
                {         a--;
                    n++;
            }
            }
            h.add(a);
        }
        return n;
                }
            }
        