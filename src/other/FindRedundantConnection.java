package other;

import java.util.HashSet;
import java.util.Set;

public class FindRedundantConnection {
    public int findFather(int[] father,int current){
        while(father[current]!=current){
            current = father[current];
        }
        return current;
    }
    public void changeFather(int[] father,int root,int child){
        father[child] = root;
    }
    // 并查集
    public int[] findRedundantConnection(int[][] edges) {
        int[] ans = new int[2];
        //并查集的头节点
        int[] father = new int[edges.length + 1];
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }

        //重复边 -> 当后成完成的树以后，所有节点都从同一个父节点出发
        // 此时 若有边两端节点来自同一个根节点，则找到答案
        for (int[] edge : edges) {
             int f1 = findFather(father,edge[0]);
             int f2 = findFather(father,edge[1]);
             if(f1 == f2){
                 ans[0] = edge[0];
                 ans[1] = edge[1];
                 break;
             }else{
                 changeFather(father,f1,f2);
             }

        }
        return ans;
    }
}
