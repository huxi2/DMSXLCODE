package greedy;

import java.util.Arrays;

public class ReconstructQueue {
    //
    public int[][] reconstructQueue(int[][] people) {
        //按照身高逆序排
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] != o2[0]) return o2[0] - o1[0];
            return o1[1] - o2[1];
        });
        // 身高排序后  [hi,ki]之前的人都要高于（等于）该hi
        // 然后将其调到指定位置即可
        for (int i = 1; i < people.length; i++) {
            // 往前排
            int[] temp = people[i];
            int j = i, newIndex = people[i][1];
            for (; j > newIndex; j--) {
                people[j] = people[j - 1];
            }
            people[j] = temp;
        }
        return people;
    }
}
