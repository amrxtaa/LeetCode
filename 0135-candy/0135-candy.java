class Solution {
    public int candy(int[] ratings) {
        int u=0;
        int d=0;
        int pres=0;
        int can=0;
        for(int i=1;i<ratings.length;i++)
        {
            int curs= ratings[i]>ratings[i-1] ? 1 : ratings[i] < ratings[i-1] ? -1 : 0;
            if((pres<0 && curs>=0) || (pres>0 && curs==0))
            {
               can+=sum(u)+sum(d)+Math.max(u, d);
                u=0;
                d=0;    
            }
            if(curs>0) u++;
            else if(curs<0) d++;
            else can++;
            pres=curs;
        }
    can+=sum(u)+sum(d)+Math.max(u, d)+1;
        return can;
    }
    int sum(int n)
    {
        return (n*(n+1))/2;
    }
}