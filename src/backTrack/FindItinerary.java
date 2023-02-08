package backTrack;

import java.util.LinkedList;
import java.util.List;

public class FindItinerary {
    LinkedList<String> ans;
    boolean[] flag;

    public List<String> findItinerary(List<List<String>> tickets) {
        ans = new LinkedList<>();
        flag = new boolean[tickets.size()];
        tickets.sort((List<String> o1, List<String> o2) -> o2.get(1).compareTo(o1.get(1)));
        ans.add("JFK");
        backtrack(tickets, "JFK");
        return ans;
    }

    public boolean backtrack(List<List<String>> tickets, String target) {
        if (ans.size() == tickets.size() + 1) return true;

        for (int i = 0; i < tickets.size(); i++) {
            List<String> temp = tickets.get(i);
            if (!flag[i] && temp.get(0).equals(target)) {
                flag[i] = true;
                ans.add(temp.get(1));
                if (backtrack(tickets, temp.get(1))) return true;
                ans.removeLast();
                flag[i] = false;
            }
        }
        return false;
    }
}
