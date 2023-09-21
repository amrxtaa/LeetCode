class Solution {
    public double findMedianSortedArrays(int[] n1, int[] n2) {
        int n=n1.length+n2.length;
        double n3[]=new double[n];
        int m=0,s=n-1;
        double ans=0;
        int j=0;
        for(int i=0; i<n1.length;i++)
        {
            n3[j++]=n1[i];
        }
        for(int d=0;d<n2.length;d++)
        {
            n3[j]=n2[d];
            j++;
        }
          Arrays.sort(n3);  
        for(int a=0;a<n;a++)
        {
            System.out.println(n3[a]);
        }
        if(n%2==0)
        {
            int c=n/2;
            ans=((n3[c-1])+n3[c])/2;
        }
        else{
        while(m<s)
        {
            m++;
            s--;
        }
        if(m==s)
        {
             ans=n3[m];
        }
        }
        return ans;
    }
}