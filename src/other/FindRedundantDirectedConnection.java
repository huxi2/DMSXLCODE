package other;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindRedundantDirectedConnection {
    public int findFather(int[] father,int current){
        while(father[current]!=current)
            current = father[current];
        return current;
    }
    // 并查集判断环中需要删除的边
    public int[] getRemoveEdge(int[][] edges) {
        int[] ans = new int[2];
        //并查集父节点
        int[] father = new int[edges.length+1];
        for (int i = 0; i < father.length; i++){
            father[i]=i;
        }

        for (int[] edge : edges) {
            int f1 = findFather(father,edge[0]);
            int f2 = findFather(father,edge[1]);
            if(f1==f2){
                ans[0] = edge[0];
                ans[1] = edge[1];
                break;
            }else{
                //changeFather(father,f1,f2);
                father[f2]=f1;
            }
        }
        return ans;
    }

    // 删除 edge判断是否构成树
    public boolean isTree(int[][] edges,int[] remove){
        //使用并查集检查是否存在环
        int[] father=new int[edges.length+1];
        for (int i = 0; i < father.length; i++) {
            father[i]=i;
        }
        // 
        for (int[] edge:edges) {
            if(edge[0]==remove[0] && edge[1]==remove[1] )continue;
            int f1 = findFather(father,edge[0]);
            int f2 = findFather(father,edge[1]);
            if(f1==f2){
                return false;
            }
            father[f2]=f1;
        }
        
        return true;
    }


    // 冗余三种情况 有向图  入度为1则为树（环）   入读为2则有冗余边
    public int[] findRedundantDirectedConnection(int[][] edges) {
        Deque<int[]> que = new ArrayDeque<>();
        //判断入度
        int[] inDegree = new int[edges.length + 1];
        for (int[] edge : edges) {
            inDegree[edge[1]]++;
        }
        // 从入度为2的边中删除 查看是否是树
        for (int[] edge : edges) {// 统计边
            if (inDegree[edge[1]] == 2) que.addFirst(edge);
        }
        while (!que.isEmpty()) {// 逆序删除
            int[] edge = que.pollFirst();
            if (isTree(edges, edge)) {
                return edge;
            }
        }

        return getRemoveEdge(edges);//存在环，使用并查集处理
    }
}
