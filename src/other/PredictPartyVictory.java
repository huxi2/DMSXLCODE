package other;

import java.util.Arrays;

public class PredictPartyVictory {
    public String predictPartyVictory(String senate) {
        // 禁言权力
        int RMute = 0, DMute = 0;
        boolean[] isMuted = new boolean[senate.length()];

        int[] state = new int[3];  //0 表示仅有R发言 1表示仅有D发言  2表示当前轮双方都发言
        while (true) {
            Arrays.fill(state, 0);
            for (int i = 0; i < senate.length(); i++) {
                if (isMuted[i]) continue;
                if (senate.charAt(i) == 'R') {// 当前阵营
                    if (RMute > 0) {//有人将他禁言
                        isMuted[i] = true;
                        RMute--;
                    } else {//可以发言
                        DMute++;
                        state[0] = 1;
                        if (state[1] == 1) state[2] = 1;
                    }
                } else {
                    if (DMute > 0) {//有人将他禁言
                        isMuted[i] = true;
                        DMute--;
                    } else {//可以发言
                        RMute++;
                        state[1] = 1;
                        if (state[0] == 1) state[2] = 1;
                    }
                }
            }
            if (state[2] != 1) break;
        }
        return state[0] == 1 ? "Radiant" : "Dire";
    }
}
