class Solution {
    public int minCostConnectPoints(int[][] points) {
int n = points.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b)->a[2]-b[2]);
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                int mDist=Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
                minHeap.offer(new int[]{i, j, mDist});
            }
        }
        UnionFind uf=new UnionFind(n+1);
        int minCost= 0, connectedEdge = 0;
        while(!minHeap.isEmpty()){
            int[] node = minHeap.poll();
            if (uf.union(node[0], node[1])){
                connectedEdge++;
                minCost+=node[2];
            }
            if (connectedEdge==n-1)
                return minCost;
        }
        return minCost;
    }
}
class UnionFind{
    int[] root;
    UnionFind(int n){
        root = new int[n];
        for(int i = 0; i< n; i++){
            root[i]=i;
        }
    }
    int find(int v){
        if (root[v]==v)
            return v;
        return find(root[v]);
    }
    boolean union(int v1, int v2){
        int ar1 = find(v1);
        int ar2 = find(v2);
        if (ar1==ar2)
            return false;
        root[ar1]=ar2;
        return true;
    }
} 

