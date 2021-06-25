package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class EdgeKruskals {
    int source;
    int destination;
    int weight;

    EdgeKruskals(int s, int d, int w) {
        this.source = s;
        this.destination = d;
        this.weight = w;
    }

    @Override
    public String toString() {
        return "Edge is from " + this.source + " to " + this.destination + " with weight " + this.weight;
    }
}

public class KruskalMST {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int v = Integer.parseInt(str[0]);
        int e = Integer.parseInt(str[1]);
        List<EdgeKruskals> edgeList = new ArrayList<>();
        for(int i=0; i<e; i++){
            str=br.readLine().split(" ");
            int src = Integer.parseInt(str[0]);
            int dest = Integer.parseInt(str[1]);
            int weight = Integer.parseInt(str[2]);
            EdgeKruskals edge = new EdgeKruskals(src, dest, weight);
            edgeList.add(edge);
        }
        //sort the edges in non-decreasing order
        Collections.sort(edgeList, new Comparator<EdgeKruskals>(){
           @Override
           public int compare(EdgeKruskals e1, EdgeKruskals e2){
               if(e1.weight > e2.weight){
                   return 1;
               }
               else if(e1.weight == e2.weight){
                   return 0;
               }
               else return -1;
           }
        });

        /*for(EdgeKruskals edges: edgeList){
            System.out.println(edges.toString());
        }*/
        solvekruskalMST(v, edgeList);
    }

    public static void solvekruskalMST(int vertices, List<EdgeKruskals> edgeList){
        int[] parent = new int[vertices];
        int[] rank = new int[vertices];
        for(int i=0; i<vertices; i++){
            parent[i] = -1;
        }
        List<EdgeKruskals> mst = new ArrayList<>();
        for(EdgeKruskals edge: edgeList){
            int u = edge.source;
            int v = edge.destination;
            int w = edge.weight;

            int uRoot = find(u, parent);
            int vRoot = find(v, parent);

            if(uRoot == vRoot){
                continue;
            }

            if(rank[uRoot] < rank[vRoot]){
                parent[uRoot] = vRoot;
                mst.add(edge);
            }
            else if(rank[vRoot] < rank[uRoot]){
                parent[vRoot] = uRoot;
                mst.add(edge);
            }
            else {
                parent[vRoot] = uRoot;
                rank[uRoot]++;
                mst.add(edge);
            }
        }
        System.out.println("Kruskals MST is -> ");
        for(EdgeKruskals edges: mst){
            System.out.println(edges.toString());
        }
    }

    public static int find(int x, int[] parent){
        if(parent[x] == -1){
            return x;
        }
        else return find(parent[x], parent);
    }

}

/*
9 14
0 1 4
0 7 8
1 2 8
1 7 11
2 3 7
2 5 4
2 8 2
3 4 9
3 5 14
4 5 10
5 6 2
6 7 1
6 8 6
7 8 7
 */
