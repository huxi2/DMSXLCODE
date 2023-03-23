package other;

import java.util.List;

public class CanVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] flag = new boolean[rooms.size()];
        flag[0] = true;

        for (int i = 0; i < rooms.size(); i++) {
            if (!flag[i]) return false;
            List<Integer> keys = rooms.get(i);
            for (int j = 0; j < keys.size(); j++) {
                if (!flag[keys.get(j)]) {
                    flag[keys.get(j)] = true;
                    keys.addAll(rooms.get(keys.get(j)));
                }
            }
        }

        for (int i = 0; i < rooms.size(); i++) {
            if (!flag[i]) return false;
        }

        return true;
    }

    public void dfs(List<List<Integer>> rooms, boolean[] visited, int roomId) {
        if(visited[roomId]) return;
        visited[roomId]=true;
        for(int key:rooms.get(roomId)){
            if(!visited[key]) dfs(rooms,visited,key);
        }
    }

    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, visited, 0);
        for (int i = 0; i < rooms.size(); i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
}
