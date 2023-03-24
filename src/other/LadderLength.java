package other;

import java.util.*;

public class LadderLength {

    public boolean checkPath(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (diff > 1) return false;
            if (s1.charAt(i) != s2.charAt(i)) diff++;
        }
        return diff == 1;
    }

    //最短路径 -> 广度优先
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int ans = 0;
        Set<String> visited = new HashSet<>();
        Deque<String> que = new ArrayDeque<>();
        que.add(beginWord);

        // 图的广度遍历等于层次优先
        while (!que.isEmpty()) {
            ans++;
            int n = que.size();
            for (int i = 0; i < n; i++) {
                beginWord = que.poll();
                if(beginWord.equals(endWord))return ans;

                // 判断下一层节点
                for (String node : wordList) {
                    if (visited.contains(node) || !checkPath(beginWord, node)) continue;
                    visited.add(node);
                    que.add(node);
                }
            }
        }

        return 0;
    }
}
